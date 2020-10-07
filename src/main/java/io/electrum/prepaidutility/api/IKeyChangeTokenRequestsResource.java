package io.electrum.prepaidutility.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.prepaidutility.model.KeyChangeConfirmation;
import io.electrum.prepaidutility.model.KeyChangeReversal;
import io.electrum.prepaidutility.model.KeyChangeTokenRequest;

public interface IKeyChangeTokenRequestsResource {

   public void createKeyChangeTokenRequest(
           String requestId,
           KeyChangeTokenRequest body,
           SecurityContext securityContext,
           AsyncResponse asyncResponse,
           Request request,
           HttpServletRequest httpServletRequest,
           HttpHeaders httpHeaders,
           UriInfo uriInfo);

   public void createKeyChangeConfirmationRequest(
           String requestId,
           String confirmsationId,
           KeyChangeConfirmation body,
           SecurityContext securityContext,
           AsyncResponse asyncResponse,
           Request request,
           HttpServletRequest httpServletRequest,
           HttpHeaders httpHeaders,
           UriInfo uriInfo);

   public void createKeyChangeReversalRequest(
           String requestId,
           String reversalId,
           KeyChangeReversal body,
           SecurityContext securityContext,
           AsyncResponse asyncResponse,
           Request request,
           HttpServletRequest httpServletRequest,
           HttpHeaders httpHeaders,
           UriInfo uriInfo);
}
