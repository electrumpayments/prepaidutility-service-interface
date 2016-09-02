package io.electrum.prepaidutility.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a request for a token reprint
 */
@ApiModel(description = "Represents a request for a token reprint")
@JsonInclude(Include.NON_NULL)
public class TokenReprintRequest extends Transaction {

   private Meter meter = null;
   private String originalRef = null;

   public TokenReprintRequest meterId(Meter meter) {
      this.meter = meter;
      return this;
   }

   /**
    * Details of the meter for which a token reprint is requested. The object must include at least a value for meterId.
    * 
    * @return meter
    **/
   @ApiModelProperty(required = true, value = "Details of the meter for which a token reprint is requested. The object must include at least a value for meterId.")
   @NotNull
   public Meter getMeter() {
      return meter;
   }

   public void setMeter(Meter meter) {
      this.meter = meter;
   }

   public TokenReprintRequest originalRef(String originalRef) {
      this.originalRef = originalRef;
      return this;
   }

   /**
    * Reference or receipt number for the original token in the case that a specific token is requested. If this field
    * is not present, then the last-issued token will be requested from the provider.
    * 
    * @return originalRef
    **/
   @ApiModelProperty(value = "Reference or receipt number for the original token in the case that a specific token is requested. If this field is not present, then the last-issued token will be requested from the provider.")
   public String getOriginalRef() {
      return originalRef;
   }

   public void setOriginalRef(String originalRef) {
      this.originalRef = originalRef;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class TokenReprintRequest {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    meter: ").append(Utils.toIndentedString(meter)).append("\n");
      sb.append("    originalRef: ").append(Utils.toIndentedString(originalRef)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
