package io.electrum.prepaidutility.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a request for a key change token
 *
 */
@ApiModel(description = "Represents a request for a key change token")
public class KeyChangeTokenRequest extends Transaction {

   private Meter meter = null;

   public KeyChangeTokenRequest meter(Meter meter) {
      this.meter = meter;
      return this;
   }
   
   /**
    * Details of the meter.
    * 
    * @return meter
    **/
   @ApiModelProperty(required = true, value = "Details of the meter.")
   @NotNull
   @Valid
   public Meter getMeter() {
      return meter;
   }

   public void setMeter(Meter meter) {
      this.meter = meter;
   }
   
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class KeyChangeTokenRequest {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    meter: ").append(Utils.toIndentedString(meter)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
