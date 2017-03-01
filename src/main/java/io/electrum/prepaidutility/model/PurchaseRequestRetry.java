package io.electrum.prepaidutility.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a token purchase request retry
 */

@JsonInclude(Include.NON_NULL)
public class PurchaseRequestRetry {

   private String retryId = null;
   private PurchaseRequest originalRequest = null;

   /**
    * The randomly generated UUID identifying this transaction, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122)
    */
   public PurchaseRequestRetry retryId(String retryId) {
      this.retryId = retryId;
      return this;
   }

   public String getRetryId() {
      return retryId;
   }

   public void setRetryId(String retryId) {
      this.retryId = retryId;
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
      sb.append("    originalRequest: ").append(Utils.toIndentedString(originalRequest)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
