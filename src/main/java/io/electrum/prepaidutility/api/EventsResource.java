package io.electrum.prepaidutility.api;

import io.electrum.prepaidutility.model.ErrorDetail;
import io.electrum.prepaidutility.model.PurchaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

/**
 * @since 3.10.0
 */
@Path(EventsResource.PATH)
@Api(description = "the events API", authorizations = { @Authorization("httpBasic") })
public abstract class EventsResource {

   protected abstract IEventsResource getResourceImplementation();

   public static final String PATH = "/events";

   public static class NotifyTokenPurchase {
      public static final String NOTIFY_TOKEN_PURCHASE = "notifyTokenPurchase";
      public static final int SUCCESS = 202;
      public static final String RELATIVE_PATH = "/tokenPurchases";
      public static final String PATH = EventsResource.PATH + RELATIVE_PATH;

      public static class QueryParameters {
         public static final String PURCHASE_ID = "purchaseId";
      }
   }

   @POST
   @Path(NotifyTokenPurchase.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = NotifyTokenPurchase.NOTIFY_TOKEN_PURCHASE, value = "Notifies that a successful token purchase has taken place.", notes = "An event notification to signal that a successful token purchase was performed. This operation is for informational purposes only. Implementations that do not need to subscribe to this event may simply return an HTTP status code 501.")
   @ApiResponses(value = {
         @ApiResponse(code = NotifyTokenPurchase.SUCCESS, message = "Accepted"),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 404, message = "Not found", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void notifyTokenPurchase(
         @ApiParam(value = "The id of the original purchase request.", required = true) @QueryParam(NotifyTokenPurchase.QueryParameters.PURCHASE_ID) String purchaseId,
         @ApiParam(value = "A token purchase response", required = true) PurchaseResponse body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().notifyTokenPurchase(
            purchaseId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }
}
