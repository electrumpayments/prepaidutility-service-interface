package io.electrum.prepaidutility.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a request for information about a meter
 */
@ApiModel(description = "Represents a request for information about a meter")
public class MeterLookupRequest extends Transaction {

   private Meter meter;

   public MeterLookupRequest meter(Meter meter) {
      this.meter = meter;
      return this;
   }

   /**
    * Details of the meter for which information is requested. The object must include at least a value for meterId.
    * 
    * @return meter
    **/
   @ApiModelProperty(required = true, value = "Details of the meter for which information is requested. The object must include at least a value for meterId.")
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
      sb.append("class MeterLookupRequest {\n");

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
