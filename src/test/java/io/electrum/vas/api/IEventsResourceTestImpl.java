package io.electrum.vas.api;

import io.electrum.prepaidutility.api.IEventsResource;
import io.electrum.prepaidutility.model.PurchaseResponse;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

/**
 * This class provides an implementation of the {@link IEventsResource} interface for testing purposes.
 * <p>
 * There are two aspects of the {@link IEventsResource} interface which are tested so as not to break existing interface
 * implementations:
 * <ul>
 * <li>That new interface methods are defined with a default implementation.</li>
 * <li>That new interface methods which overload existing methods lead to calling the existing method.</li>
 * </ul>
 * <p>
 * If this class does not compile after you have changed the {@link IEventsResource} interface, you have likely broken
 * the {@link IEventsResource} interface as per the first point above.
 *
 */
public class IEventsResourceTestImpl implements IEventsResource {

   @Override
   public void notifyTokenPurchase(
         String purchaseId,
         PurchaseResponse body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo) {

   }
}
