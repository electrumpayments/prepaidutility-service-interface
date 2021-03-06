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
import io.electrum.prepaidutility.model.PurchaseResponse;
import io.electrum.prepaidutility.model.TokenReprintRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path(TokenReprintsResource.PATH)
@Api(description = "the tokenReprints API", authorizations = { @Authorization("httpBasic") })
public abstract class TokenReprintsResource {

   protected abstract ITokenReprintsResource getResourceImplementation();

   public static final String PATH = "/tokenReprints";

   public class RequestTokenReprint {
      public static final String REQUEST_TOKEN_REPRINT = "requestTokenReprint";
      public static final int SUCCESS = 200;
      public static final String RELATIVE_PATH = "/{" + PathParameters.REPRINT_ID + "}";
      public static final String PATH = TokenReprintsResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String REPRINT_ID = "reprintId";
      }
   }

   @POST
   @Path(RequestTokenReprint.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = RequestTokenReprint.REQUEST_TOKEN_REPRINT, value = "Requests a reprint of a token", notes = "Requests a reprint of a token that was previously issued for a specified meter. The request can be for either the last token issued for that meter, or for a specific transaction reference, depending on what the provider supports.")
   @ApiResponses(value = {
         @ApiResponse(code = RequestTokenReprint.SUCCESS, message = "Success", response = PurchaseResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void requestTokenReprint(
         @ApiParam(value = "The randomly generated UUID of this request.", required = true) @PathParam(RequestTokenReprint.PathParameters.REPRINT_ID) String reprintId,
         @ApiParam(value = "A token reprint request.", required = true) TokenReprintRequest body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().requestTokenReprint(
            reprintId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }
}
