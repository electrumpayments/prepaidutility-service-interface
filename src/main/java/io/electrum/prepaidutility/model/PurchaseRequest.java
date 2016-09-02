package io.electrum.prepaidutility.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Tender;
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
   private Amount purchaseAmount = null;
   private String utilityType = null;
   private List<Tender> tenders = new ArrayList<Tender>();

   public PurchaseRequest meterId(Meter meter) {
      this.meter = meter;
      return this;
   }

   /**
    * Details of the meter for which a purchase is requested. The object must include at least a value for meterId.
    * 
    * @return meter
    **/
   @ApiModelProperty(required = true, value = "Details of the meter for which a purchase is requested. The object must include at least a value for meterId.")
   @NotNull
   @Pattern(regexp = "[a-zA-Z0-9]{0,20}")
   public Meter getMeter() {
      return meter;
   }

   public void setMeter(Meter meter) {
      this.meter = meter;
   }

   public PurchaseRequest purchaseAmount(Amount purchaseAmount) {
      this.purchaseAmount = purchaseAmount;
      return this;
   }

   /**
    * Monetary amount, in minor denomination, of the requested token purchase.
    * 
    * @return purchaseAmount
    **/
   @ApiModelProperty(required = true, value = "Monetary amount, in minor denomination, of the requested token purchase.")
   @NotNull
   public Amount getPurchaseAmount() {
      return purchaseAmount;
   }

   public void setPurchaseAmount(Amount purchaseAmount) {
      this.purchaseAmount = purchaseAmount;
   }

   public PurchaseRequest utilityType(String utilityType) {
      this.utilityType = utilityType;
      return this;
   }

   /**
    * Type of utility purchase being requested (e.g. electricity, water, gas).
    * 
    * @return utilityType
    **/
   @ApiModelProperty(value = "Type of utility purchase being requested (e.g. electricity, water, gas).")
   public String getUtilityType() {
      return utilityType;
   }

   public void setUtilityType(String utilityType) {
      this.utilityType = utilityType;
   }

   public PurchaseRequest tenders(List<Tender> tenders) {
      this.tenders = tenders;
      return this;
   }

   public PurchaseRequest addTendersItem(Tender tendersItem) {
      this.tenders.add(tendersItem);
      return this;
   }

   /**
    * Details of method(s) of payment and amount(s) tendered. Only present if the PoS implementation is for
    * single-message pair transactions (i.e. no confirmation request is sent).
    * 
    * @return tenders
    **/
   @ApiModelProperty(value = "Details of method(s) of payment and amount(s) tendered. Only present if the PoS implementation is for single-message pair transactions (i.e. no confirmation request is sent).")
   public List<Tender> getTenders() {
      return tenders;
   }

   public void setTenders(List<Tender> tenders) {
      this.tenders = tenders;
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
      sb.append("    utilityType: ").append(Utils.toIndentedString(utilityType)).append("\n");
      sb.append("    tenders: ").append(Utils.toIndentedString(tenders)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
