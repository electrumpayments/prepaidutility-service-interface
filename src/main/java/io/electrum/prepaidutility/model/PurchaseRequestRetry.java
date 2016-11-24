package io.electrum.prepaidutility.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a token purchase request retry
 */
@ApiModel(description = "Represents a token purchase request retry")
@JsonInclude(Include.NON_NULL)
public class PurchaseRequestRetry {

   private String retryId = null;
   private DateTime retryTime = null;
   private PurchaseRequest originalRequest = null;

   /**
    * The randomly generated UUID identifying this transaction, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122)
    */
   public PurchaseRequestRetry retryId(String retryId) {
      this.retryId = retryId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this transaction, as defined for a variant 4 UUID in [RFC 4122](https://tools.ietf.org/html/rfc4122)")
   @NotNull
   public String getRetryId() {
      return retryId;
   }

   public void setRetryId(String retryId) {
      this.retryId = retryId;
   }

   /**
    * The date and time of the message in UTC, as recorded by the sender. The format shall be as defined for date-time
    * in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional
    * time-secfrac be included up to millisecond precision
    */
   public PurchaseRequestRetry retryTime(DateTime retryTime) {
      this.retryTime = retryTime;
      return this;
   }

   @ApiModelProperty(required = true, value = "The date and time of the message as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision")
   @NotNull
   public DateTime getRetryTime() {
      return retryTime;
   }

   public void setRetryTime(DateTime retryTime) {
      this.retryTime = retryTime;
   }

   /**
    * The original {@link PurchaseRequest} that is being retried
    */
   public PurchaseRequestRetry originalRequest(PurchaseRequest originalRequest) {
      this.originalRequest = originalRequest;
      return this;
   }

   @ApiModelProperty(required = true, value = "The original PurchaseRequest that is being retried")
   @NotNull
   public PurchaseRequest getOriginalRequest() {
      return originalRequest;
   }

   public void setOriginalRequest(PurchaseRequest originalRequest) {
      this.originalRequest = originalRequest;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      PurchaseRequestRetry vasRequest = (PurchaseRequestRetry) o;
      return Objects.equals(retryId, vasRequest.retryId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(retryId);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PurchaseRequestRetry {\n");

      sb.append("    retryId: ").append(Utils.toIndentedString(retryId)).append("\n");
      sb.append("    retryTime: ").append(Utils.toIndentedString(retryTime)).append("\n");
      sb.append("    originalRequest: ").append(Utils.toIndentedString(originalRequest)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
