package io.electrum.prepaidutility.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.electrum.vas.Utils;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a token purchase request
 */
@ApiModel(description = "Represents a token purchase request")
@JsonInclude(Include.NON_NULL)
public class PurchaseRequest extends Transaction {

   private Meter meter = null;
   private LedgerAmount purchaseAmount = null;
   private Integer slipWidth = null;
   private List<AdditionalDataElement> additionalData = new ArrayList<AdditionalDataElement>();

   /**
    * Details of the meter for which a purchase is requested. The object must include at least a value for meterId.
    **/
   public PurchaseRequest meterId(Meter meter) {
      this.meter = meter;
      return this;
   }

   @ApiModelProperty(required = true, value = "Details of the meter for which a purchase is requested. The object must include at least a value for meterId.")
   @NotNull
   @Pattern(regexp = "[a-zA-Z0-9]{0,20}")
   public Meter getMeter() {
      return meter;
   }

   public void setMeter(Meter meter) {
      this.meter = meter;
   }

   /**
    * Monetary amount, in minor denomination, of the requested token purchase.
    **/
   public PurchaseRequest purchaseAmount(LedgerAmount purchaseAmount) {
      this.purchaseAmount = purchaseAmount;
      return this;
   }

   @ApiModelProperty(required = true, value = "Monetary amount, in minor denomination, of the requested token purchase.")
   @NotNull
   public LedgerAmount getPurchaseAmount() {
      return purchaseAmount;
   }

   public void setPurchaseAmount(LedgerAmount purchaseAmount) {
      this.purchaseAmount = purchaseAmount;
   }

   /**
    * Width of the slip on which POS prints the transaction receipt.
    */
   public PurchaseRequest slipWidth(Integer slipWidth) {
      this.slipWidth = slipWidth;
      return this;
   }

   @ApiModelProperty(value = "Width of the slip on which POS prints the transaction receipt.")
   @Min(21)
   @Max(80)
   public Integer getSlipWidth() {
      return slipWidth;
   }

   public void setSlipWidth(Integer slipWidth) {
      this.slipWidth = slipWidth;
   }
   
   /**
    * Array of {@link AdditionalDataElement} fields. 
    */
   public PurchaseRequest additionalData(List<AdditionalDataElement> additionalData) {
      this.additionalData = additionalData;
      return this;
   }
   
   @ApiModelProperty(value = "")
   public List<AdditionalDataElement> getAdditionalData() {
      return additionalData;
   }
   
   public void setAdditionalData(List<AdditionalDataElement> additionalData) {
      this.additionalData = additionalData;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PurchaseRequest {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    meterId: ").append(Utils.toIndentedString(meter)).append("\n");
      sb.append("    purchaseAmount: ").append(Utils.toIndentedString(purchaseAmount)).append("\n");
      sb.append("    slipWidth: ").append(Utils.toIndentedString(slipWidth)).append("\n");
      sb.append("    additionalData: ").append(Utils.toIndentedString(additionalData)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
