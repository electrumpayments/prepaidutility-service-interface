package io.electrum.prepaidutility.api;

import io.electrum.prepaidutility.model.PurchaseResponse;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

public interface IEventsResource {

   default void notifyTokenPurchase(
         String purchaseId,
         PurchaseResponse body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo) {

      asyncResponse.resume(new ServerErrorException("This operation has not been implemented.", 501));
   }
}
