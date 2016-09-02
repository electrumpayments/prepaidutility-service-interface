package io.electrum.prepaidutility.model;

import javax.validation.constraints.NotNull;

import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicReversal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data required to request the reversal of a purchase request
 */
@ApiModel(description = "Data required to request the reversal of a purchase request")
public class ReversalRequest extends BasicReversal {

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
   @NotNull
   public PurchaseRequest getOriginalRequest() {
      return originalRequest;
   }

   public void setOriginalRequest(PurchaseRequest originalRequest) {
      this.originalRequest = originalRequest;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ReversalRequest {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    reversalReason: ").append(Utils.toIndentedString(reversalReason)).append("\n");
      sb.append("    originalRequest: ").append(Utils.toIndentedString(originalRequest)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
