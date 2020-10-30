package io.electrum.prepaidutility.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.prepaidutility.model.ErrorDetail;
import io.electrum.prepaidutility.model.MeterLookupRequest;
import io.electrum.prepaidutility.model.MeterLookupResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path(MeterLookupsResource.PATH)
@Api(description = "the meterLookups API", authorizations = { @Authorization("httpBasic") })
public abstract class MeterLookupsResource {

   protected abstract IMeterLookupsResource getResourceImplementation();

   public static final String PATH = "/meterLookups";

   public class CreateMeterLookup {
      public static final String CREATE_METER_LOOKUP = "createMeterLookup";
      public static final int SUCCESS = 201;
      public static final String RELATIVE_PATH = "/{" + PathParameters.LOOKUP_ID + "}";
      public static final String PATH = MeterLookupsResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String LOOKUP_ID = "lookupId";
      }
   }

   @POST
   @Path(CreateMeterLookup.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = CreateMeterLookup.CREATE_METER_LOOKUP, value = "Request information about a specified meter", notes = "Request information about a specified meter, including customer and utility details. This resource is used to verify that a meter number is valid and registered with the correct details. It also confirms whether the meter is recognised by a provider and that tokens can be issued against it.")
   @ApiResponses(value = {
         @ApiResponse(code = CreateMeterLookup.SUCCESS, message = "Created", response = MeterLookupResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void createMeterLookup(
         @ApiParam(value = "The randomly generated UUID of this request.", required = true) @PathParam(CreateMeterLookup.PathParameters.LOOKUP_ID) String lookupId,
         @ApiParam(value = "A meter information lookup request.", required = true) MeterLookupRequest body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().createMeterLookup(
            lookupId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }
}
