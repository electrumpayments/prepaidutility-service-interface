package io.electrum.prepaidutility.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.*;

import io.electrum.prepaidutility.model.ErrorDetail;
import io.electrum.prepaidutility.model.MeterLookupRequest;
import io.electrum.prepaidutility.model.MeterLookupResponse;
import io.swagger.annotations.*;

@Path(MeterLookupsResource.PATH)
@Api(description = "the meterLookups API", authorizations = { @Authorization("httpBasic") })
public abstract class MeterLookupsResource {

   protected abstract IMeterLookupsResource getResourceImplementation();

   public static final String PATH = PrepaidUtilityApi.API_BASE_PATH + "/meterLookups";

   public class CreateMeterLookup {
      public static final String CREATE_METER_LOOKUP = "createMeterLookup";
      public static final int SUCCESS = 201;
      public static final String PATH = "/{" + PathParameters.LOOKUP_ID + "}";

      public class PathParameters {
         public static final String LOOKUP_ID = "lookupId";
      }
   }

   @POST
   @Path(CreateMeterLookup.PATH)
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
