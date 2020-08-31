package io.electrum.vas.api;

import io.electrum.prepaidutility.api.ITokenPurchasesResource;
import io.electrum.prepaidutility.model.ConfirmationAdvice;
import io.electrum.prepaidutility.model.PurchaseRequest;
import io.electrum.prepaidutility.model.ReversalAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

/**
 * This class provides an implementation of the {@link ITokenPurchasesResource} interface for testing purposes.
 * <p>
 * There are two aspects of the {@link ITokenPurchasesResource} interface which are tested so as not to break existing
 * interface implementations:
 * <ul>
 * <li>That new interface methods are defined with a default implementation.</li>
 * <li>That new interface methods which overload existing methods lead to calling the existing method.</li>
 * </ul>
 * <p>
 * If this class does not compile after you have changed the {@link ITokenPurchasesResource} interface, you have likely
 * broken the {@link ITokenPurchasesResource} interface as per the first point above.
 *
 */
public class ITokenPurchasesResourceTestImpl implements ITokenPurchasesResource {

   @Override
   public void confirmTokenPurchase(
         String purchaseId,
         String confirmationId,
         ConfirmationAdvice body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo) {

   }

   @Override
   public void createTokenPurchaseRequest(
         String purchaseId,
         PurchaseRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo) {

   }

   @Override
   public void retryPurchaseRequest(
         String purchaseId,
         PurchaseRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo) {

   }

   @Override
   public void reverseTokenPurchase(
         String purchaseId,
         String reversalId,
         ReversalAdvice body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo) {

   }
}
