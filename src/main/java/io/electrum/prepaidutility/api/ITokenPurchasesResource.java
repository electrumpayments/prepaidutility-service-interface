package io.electrum.prepaidutility.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.prepaidutility.model.ConfirmationRequest;
import io.electrum.prepaidutility.model.PurchaseRequest;
import io.electrum.prepaidutility.model.ReversalRequest;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-26T07:31:58.129Z")
public interface ITokenPurchasesResource {

   public abstract Response confirmTokenPurchase(
         String purchaseId,
         String confirmationId,
         ConfirmationRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   public abstract Response createTokenPurchaseRequest(
         String purchaseId,
         PurchaseRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   public abstract Response retryPurchaseRequest(
         String purchaseId,
         String retryId,
         PurchaseRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   public abstract Response reverseTokenPurchase(
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
