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

import io.electrum.prepaidutility.model.PurchaseResponse;
import io.electrum.prepaidutility.model.TokenReprintRequest;
import io.electrum.vas.model.ErrorDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/tokenReprints")

@Api(description = "the tokenReprints API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-26T07:31:58.129Z")
public abstract class TokenReprintsResource {

   protected abstract ITokenReprintsResource getResourceImplementetion();

   @POST
   @Path("/{reprintId}")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = "Requests a reprint of a token", notes = "Requests a reprint of a token that was previously issued for a specified meter. The request can be for either the last token issued for that meter, or for a specific transaction reference, depending on what the provider supports.")
   @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = PurchaseResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void requestTokenReprint(
         @ApiParam(value = "The randomly generated UUID of this request.", required = true) @PathParam("reprintId") String reprintId,
         @ApiParam(value = "A token reprint request.", required = true) TokenReprintRequest body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementetion().requestTokenReprint(
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
