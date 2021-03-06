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
import io.electrum.prepaidutility.model.KeyChangeConfirmation;
import io.electrum.prepaidutility.model.KeyChangeTokenRequest;
import io.electrum.prepaidutility.model.KeyChangeTokenResponse;
import io.electrum.vas.model.BasicAdvice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path(KeyChangeTokenRequestsResource.PATH)
@Api(description = "the keyChangeTokenRequests API", authorizations = { @Authorization("httpBasic") })
public abstract class KeyChangeTokenRequestsResource {

   protected abstract IKeyChangeTokenRequestsResource getResourceImplementation();

   public static final String PATH = "/keyChangeTokenRequests";

   public class CreateKeyChangeTokenRequest {
      public static final String CREATE_KEY_CHANGE_TOKEN_REQUEST = "createKeyChangeTokenRequest";
      public static final int SUCCESS = 201;
      public static final String RELATIVE_PATH = "/{" + PathParameters.REQUEST_ID + "}";
      public static final String PATH = KeyChangeTokenRequestsResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String REQUEST_ID = "requestId";
      }
   }

   public class ConfirmKeyChange {
      public static final String CONFIRM_KEY_CHANGE = "confirmKeyChange";
      public static final int SUCCESS = 202;
      public static final String RELATIVE_PATH =
            "/{" + PathParameters.REQUEST_ID + "}/confirmations/{" + PathParameters.CONFIRMATION_ID + "}";
      public static final String PATH = KeyChangeTokenRequestsResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String REQUEST_ID = "requestId";
         public static final String CONFIRMATION_ID = "confirmationId";
      }
   }

   @POST
   @Path(CreateKeyChangeTokenRequest.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = CreateKeyChangeTokenRequest.CREATE_KEY_CHANGE_TOKEN_REQUEST, value = "Request a key change token", notes = "Requests a key change token for a specified meter. This resource is used when the utility has updated a meter's encryption key and the customer required a token to input the new key to the meter. Key change tokens are typically supplied as part of a normal purchase, so this operation is rarely used.")
   @ApiResponses(value = {
         @ApiResponse(code = CreateKeyChangeTokenRequest.SUCCESS, message = "Created", response = KeyChangeTokenResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void createKeyChangeTokenRequest(
         @ApiParam(value = "The randomly generated UUID of this request.", required = true) @PathParam(CreateKeyChangeTokenRequest.PathParameters.REQUEST_ID) String requestId,
         @ApiParam(value = "A key change token request", required = true) KeyChangeTokenRequest body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().createKeyChangeTokenRequest(
            requestId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }

   @POST
   @Path(ConfirmKeyChange.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = ConfirmKeyChange.CONFIRM_KEY_CHANGE, value = "Confirms that key change tokens have been provided to the customer.", notes = "Confirms that key change tokens have been provided successfully")
   @ApiResponses(value = {
         @ApiResponse(code = ConfirmKeyChange.SUCCESS, message = "Accepted", response = BasicAdvice.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 404, message = "Not found", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void confirmKeyChange(
         @ApiParam(value = "The randomly generated UUID of the original request.", required = true) @PathParam(ConfirmKeyChange.PathParameters.REQUEST_ID) String requestId,
         @ApiParam(value = "The randomly generated UUID of this confirmation.", required = true) @PathParam(ConfirmKeyChange.PathParameters.CONFIRMATION_ID) String confirmationId,
         @ApiParam(value = "A key change confirmation", required = true) KeyChangeConfirmation body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().confirmKeyChange(
            requestId,
            confirmationId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }

}
