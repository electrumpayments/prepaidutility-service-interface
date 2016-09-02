package io.electrum.prepaidutility.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a response to a fault report
 *
 */
@ApiModel(description = "Represents a response to a fault report")
public class FaultReportResponse extends Transaction {

   String reference = null;
   String description = null;

   public String reference(String reference) {
      this.reference = reference;
      return reference;
   }

   /**
    * Reference number for the fault report
    * 
    * @return reference
    */
   @ApiModelProperty(required = true, value = "Reference number for the fault report")
   @NotNull
   public String getReference() {
      return reference;
   }

   public void setReference(String reference) {
      this.reference = reference;
   }

   public String description(String description) {
      this.description = description;
      return description;
   }

   /**
    * Description of the fault
    * 
    * @return reference
    */
   @ApiModelProperty(required = true, value = "Description of the fault")
   @NotNull
   @Length(max = 160)
   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
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
      sb.append("    reference: ").append(Utils.toIndentedString(reference)).append("\n");
      sb.append("    description: ").append(Utils.toIndentedString(description)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
