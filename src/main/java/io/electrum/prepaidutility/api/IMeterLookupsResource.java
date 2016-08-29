package io.electrum.prepaidutility.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.prepaidutility.model.MeterLookupRequest;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-26T07:31:58.129Z")
public interface IMeterLookupsResource {

   public void createMeterLookup(
         String lookupId,
         MeterLookupRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);
}
