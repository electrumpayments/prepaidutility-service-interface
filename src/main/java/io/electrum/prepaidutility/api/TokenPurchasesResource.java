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

import io.electrum.prepaidutility.model.ConfirmationAdvice;
import io.electrum.prepaidutility.model.ErrorDetail;
import io.electrum.prepaidutility.model.PurchaseRequest;
import io.electrum.prepaidutility.model.PurchaseResponse;
import io.electrum.prepaidutility.model.ReversalAdvice;
import io.electrum.vas.model.BasicAdviceResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path(TokenPurchasesResource.PATH)
@Api(description = "the tokenPurchases API", authorizations = { @Authorization("httpBasic") })
public abstract class TokenPurchasesResource {

   protected abstract ITokenPurchasesResource getResourceImplementation();

   public static final String PATH = "/tokenPurchases";

   public class ConfirmTokenPurchase {
      public static final String CONFIRM_TOKEN_PURCHASE = "confirmTokenPurchase";
      public static final int SUCCESS = 202;
      public static final String RELATIVE_PATH =
            "/{" + PathParameters.PURCHASE_ID + "}/confirmations/{" + PathParameters.CONFIRMATION_ID + "}";
      public static final String PATH = TokenPurchasesResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String CONFIRMATION_ID = "confirmationId";
         public static final String PURCHASE_ID = "purchaseId";
      }
   }

   public class CreateTokenPurchaseRequest {
      public static final String CREATE_TOKEN_PURCHASE_REQUEST = "createTokenPurchaseRequest";
      public static final int SUCCESS = 201;
      public static final String RELATIVE_PATH = "/{" + PathParameters.PURCHASE_ID + "}";
      public static final String PATH = TokenPurchasesResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String PURCHASE_ID = "purchaseId";
      }
   }

   public class RetryPurchaseRequest {
      public static final String RETRY_PURCHASE_REQUEST = "retryPurchaseRequest";
      public static final int SUCCESS = 202;
      public static final String RELATIVE_PATH = "/{" + PathParameters.PURCHASE_ID + "}/retry";
      public static final String PATH = TokenPurchasesResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String PURCHASE_ID = "purchaseId";
      }
   }

   public class ReverseTokenPurchase {
      public static final String REVERSE_TOKEN_PURCHASE = "reverseTokenPurchase";
      public static final int SUCCESS = 202;
      public static final String RELATIVE_PATH =
            "/{" + PathParameters.PURCHASE_ID + "}/reversals/{" + PathParameters.REVERSAL_ID + "}";
      public static final String PATH = TokenPurchasesResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String REVERSAL_ID = "reversalId";
         public static final String PURCHASE_ID = "purchaseId";
      }
   }

   public class TrialTokenPurchaseRequest {
      public static final String TRIAL_TOKEN_PURCHASE_REQUEST = "trialTokenPurchaseRequest";
      public static final int SUCCESS = 200;
      public static final String RELATIVE_PATH =  "/{" + PathParameters.TRIAL_ID+"}/trial";
      public static final String PATH = TokenPurchasesResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String TRIAL_ID = "trialId";
      }
   }

   @POST
   @Path(ConfirmTokenPurchase.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = ConfirmTokenPurchase.CONFIRM_TOKEN_PURCHASE, value = "Confirms that a purchase has been completed successfully.", notes = "Confirms that a purchase has been completed successfully (i.e. the tokens have been issued to the customer and payment has been received by the merchant). It is typical that token providers do not support confirmations (aka advices), but certain point-of-sale integrations may require support for these. A confirmation request must be sent repeatedly until an HTTP response code indicating a final state has been received (i.e. either 202 or 400).")
   @ApiResponses(value = {
         @ApiResponse(code = ConfirmTokenPurchase.SUCCESS, message = "Accepted", response = BasicAdviceResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 404, message = "Not found", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void confirmTokenPurchase(
         @ApiParam(value = "The randomly generated UUID of the original purchase request.", required = true) @PathParam(ConfirmTokenPurchase.PathParameters.PURCHASE_ID) String purchaseId,
         @ApiParam(value = "The randomly generated UUID of this confirmation.", required = true) @PathParam(ConfirmTokenPurchase.PathParameters.CONFIRMATION_ID) String confirmationId,
         @ApiParam(value = "A token purchase confirmation", required = true) ConfirmationAdvice body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().confirmTokenPurchase(
            purchaseId,
            confirmationId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }

   @POST
   @Path(CreateTokenPurchaseRequest.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = CreateTokenPurchaseRequest.CREATE_TOKEN_PURCHASE_REQUEST, value = "Requests a token purchase for a specified meter.", notes = "Requests that the provider issue a token against the meter for a given monetary value. In the case that the meter and/or utility supports the issue of free tokens under a basic service support tariff scheme, then any free tokens due will also be returned. If the requested amount is 0 and a free token is due to the meter, then only this free token will be returned. A portion of the request amount may be used by the provider to offset outstanding debt or service charges owed by the customer, in which case the value of the token returned may be less than the request amount (see interface documentation for further details).")
   @ApiResponses(value = {
         @ApiResponse(code = CreateTokenPurchaseRequest.SUCCESS, message = "Created", response = PurchaseResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void createTokenPurchaseRequest(
         @ApiParam(value = "The randomly generated UUID of this request.", required = true) @PathParam(CreateTokenPurchaseRequest.PathParameters.PURCHASE_ID) String purchaseId,
         @ApiParam(value = "A token purchase request.", required = true) PurchaseRequest body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().createTokenPurchaseRequest(
            purchaseId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }

   @POST
   @Path(RetryPurchaseRequest.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = RetryPurchaseRequest.RETRY_PURCHASE_REQUEST, value = "Retry a previously submitted purchase request.", notes = "If no response was received to a purchase request due to a timeout or temporary communications failure, PoS may retry the same purchase request by calling this resource. The original purchase request will be resubmitted to the provider. If the provider had received the original request, it will respond by returning any tokens that were already issued. If not, then either new tokens may be issued as per a normal purchase or the retry will be declined.")
   @ApiResponses(value = {
         @ApiResponse(code = RetryPurchaseRequest.SUCCESS, message = "Accepted", response = PurchaseResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 404, message = "Not found", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void retryPurchaseRequest(
         @ApiParam(value = "The randomly generated UUID of the original purchase request.", required = true) @PathParam(RetryPurchaseRequest.PathParameters.PURCHASE_ID) String purchaseId,
         @ApiParam(value = "The original token purchase request.", required = true) PurchaseRequest body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().retryPurchaseRequest(
            purchaseId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }

   @POST
   @Path(ReverseTokenPurchase.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = ReverseTokenPurchase.REVERSE_TOKEN_PURCHASE, value = "Notifies the provider that a purchase was not completed successfully.", notes = "Notifies that a purchase was not completed successfully. This can occur if the original request timed out or if payment was unsuccessful. Many providers, however, do not support reversals and once a token has been issued the merchant becomes liable for the cost irrespective of payment failure or timeout. The token may still be retrieved by a reprint request, which merchants may use to help accommodate this scenario. A reversal request must be sent repeatedly until an HTTP response code indicating a final state has been received (i.e. either 202 or 400).")
   @ApiResponses(value = {
         @ApiResponse(code = ReverseTokenPurchase.SUCCESS, message = "Accepted", response = BasicAdviceResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 404, message = "Not found", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void reverseTokenPurchase(
         @ApiParam(value = "The randomly generated UUID of the original purchase request.", required = true) @PathParam(ReverseTokenPurchase.PathParameters.PURCHASE_ID) String purchaseId,
         @ApiParam(value = "The randomly generated UUID of this reversal.", required = true) @PathParam(ReverseTokenPurchase.PathParameters.REVERSAL_ID) String reversalId,
         @ApiParam(value = "A token purchase reversal.", required = true) ReversalAdvice body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().reverseTokenPurchase(
            purchaseId,
            reversalId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }

   /**
    * Requests a trial token purchase for a specified meter
    * 
    * This operation is identical to the '{@code createTokenPurchaseRequest}' operation except that
    * this operation carries no financial impact. Tokens may or may not be returned for this operation,
    * if returned then they are not valid. This operation allows the customer to make an informed
    * choice regarding the purchase costs before committing to purchasing electricity. This operation serves to inform a
    * customer exactly what the outcome of their purchase is: the service charges which will be levied, the debt
    * recovery charges, the number of units which will be provided etc. If a customer is dissatisfied with the details
    * in the response, the customer may abort the transaction without any consequences.
    * 
    * @param purchaseId
    * @param body
    * @param securityContext
    * @param asyncResponse
    * @param request
    * @param httpServletRequest
    * @param httpHeaders
    * @param uriInfo
    * @since v3.12.0
    */
   @POST
   @Path(TrialTokenPurchaseRequest.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = TrialTokenPurchaseRequest.TRIAL_TOKEN_PURCHASE_REQUEST, value = "Requests a trial token purchase for a specified meter.", notes = "This operation is identical to the '"
         + CreateTokenPurchaseRequest.CREATE_TOKEN_PURCHASE_REQUEST
         + "' operation except that no tokens are returned and this operation carries no financial impact. This operation allows the customer to make an informed choice about the transaction outcome before committing to purchase electricity. This operation serves to inform a customer exactly what the outcome of their purchase is: the service charges which will be levied, the debt recovery charges, the number of units which will be provided etc. If a customer is dissatisfied with the details in the response, the customer may abort the transaction without any consequences.")
   @ApiResponses(value = {
         @ApiResponse(code = TrialTokenPurchaseRequest.SUCCESS, message = "OK", response = PurchaseResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void trialTokenPurchaseRequest(
         @ApiParam(value = "The randomly generated UUID of this request.", required = true) @PathParam(TrialTokenPurchaseRequest.PathParameters.TRIAL_ID) String purchaseId,
         @ApiParam(value = "A token purchase request.", required = true) PurchaseRequest body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().trialTokenPurchaseRequest(
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
