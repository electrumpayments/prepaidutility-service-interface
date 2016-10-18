package io.electrum.prepaidutility.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.prepaidutility.model.ConfirmationAdvice;
import io.electrum.prepaidutility.model.PurchaseRequest;
import io.electrum.prepaidutility.model.PurchaseRequestRetry;
import io.electrum.prepaidutility.model.ReversalRequest;

public interface ITokenPurchasesResource {

   public void confirmTokenPurchase(
         String purchaseId,
         String confirmationId,
         ConfirmationAdvice body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   public void createTokenPurchaseRequest(
         String purchaseId,
         PurchaseRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   public void retryPurchaseRequest(
         String purchaseId,
         String retryId,
         PurchaseRequestRetry body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   public void reverseTokenPurchase(
         String purchaseId,
         String reversalId,
         ReversalRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

}
