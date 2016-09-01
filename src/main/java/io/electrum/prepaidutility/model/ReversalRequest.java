package io.electrum.prepaidutility.model;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data required to request the reversal of a purchase request
 */
@ApiModel(description = "Data required to request the reversal of a purchase request")
public class ReversalRequest {

   private PurchaseRequest originalRequest = null;

   public ReversalRequest originalRequest(PurchaseRequest originalRequest) {
      this.originalRequest = originalRequest;
      return this;
   }

   /**
    * The purchase request for which this reversal has been generated.
    * 
    * @return originalRequest
    **/
   @ApiModelProperty(required = true, value = "The purchase request for which this reversal has been generated.")
   public PurchaseRequest getOriginalRequest() {
      return originalRequest;
   }

   public void setOriginalRequest(PurchaseRequest originalRequest) {
      this.originalRequest = originalRequest;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ReversalRequest reversalRequest = (ReversalRequest) o;
      return Objects.equals(this.originalRequest, reversalRequest.originalRequest);
   }

   @Override
   public int hashCode() {
      return Objects.hash(originalRequest);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ReversalRequest {\n");

      sb.append("    originalRequest: ").append(toIndentedString(originalRequest)).append("\n");
      sb.append("}");
      return sb.toString();
   }

   /**
    * Convert the given object to string with each line indented by 4 spaces (except the first line).
    */
   private String toIndentedString(java.lang.Object o) {
      if (o == null) {
         return "null";
      }
      return o.toString().replace("\n", "\n    ");
   }
}
