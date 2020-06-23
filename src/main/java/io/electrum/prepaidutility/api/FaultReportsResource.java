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

import io.electrum.prepaidutility.model.ErrorDetail;
import io.electrum.prepaidutility.model.FaultReportRequest;
import io.electrum.prepaidutility.model.FaultReportResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path(FaultReportsResource.PATH)
@Api(description = "the faultReports API", authorizations = { @Authorization("httpBasic") })
public abstract class FaultReportsResource {

   protected abstract IFaultReportsResource getResourceImplementation();

   public static final String PATH = "/faultReports";

   public class CreateFaultReport {
      public static final String CREATE_FAULT_REPORT = "createFaultReport";
      public static final int SUCCESS = 201;
      public static final String PATH = FaultReportsResource.PATH + "/{" + PathParameters.REQUEST_ID + "}";

      public class PathParameters {
         public static final String REQUEST_ID = "requestId";
      }
   }

   @POST
   @Path(CreateFaultReport.PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = CreateFaultReport.CREATE_FAULT_REPORT, value = "Report a fault on a meter", notes = "Reports a technical fault on a specified meter. This resource is used when a customer wishes to report a technical fault to the utility with whom the meter is reqistered.")
   @ApiResponses(value = {
         @ApiResponse(code = CreateFaultReport.SUCCESS, message = "Created", response = FaultReportResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void createFaultReport(
         @ApiParam(value = "The randomly generated UUID of this request.", required = true) @PathParam(CreateFaultReport.PathParameters.REQUEST_ID) String requestId,
         @ApiParam(value = "A fault report", required = true) FaultReportRequest body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().createFaultReport(
            requestId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }

}
