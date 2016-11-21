package io.electrum.prepaidutility.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.electrum.vas.Utils;
import io.electrum.vas.model.LedgerAmount;
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
   private LedgerAmount purchaseAmount = null;
   private String utilityType = null;
   private String msisdn = null;
   private List<Tender> tenders = new ArrayList<>();

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
    * Type of utility purchase being requested (e.g. electricity, water, gas).
    */
   public PurchaseRequest utilityType(String utilityType) {
      this.utilityType = utilityType;
      return this;
   }

   @ApiModelProperty(value = "Type of utility purchase being requested (e.g. electricity, water, gas).")
   public String getUtilityType() {
      return utilityType;
   }

   public void setUtilityType(String utilityType) {
      this.utilityType = utilityType;
   }

   /*
    * Mobile phone number of the customer to which the outcome of a transaction can be communicated. Must conform to the
    * ITU E.164 numbering plan (https://www.itu.int/rec/T-REC-E.164/en).
    */
   public PurchaseRequest msisdn(String msisdn) {
      this.msisdn = msisdn;
      return this;
   }

   @ApiModelProperty(value = "Mobile phone number of the customer to which the outcome of a transaction can be communicated. Must conform to the ITU E.164 numbering plan (https://www.itu.int/rec/T-REC-E.164/en).")
   @Pattern(regexp = "^\\+?[1-9]\\d{1,14}")
   public String getMsisdn() {
      return msisdn;
   }

   public void setMsisdn(String msisdn) {
      this.msisdn = msisdn;
   }

   /**
    * An array of tenders used to pay for the transaction.
    */
   public PurchaseRequest tenders(List<Tender> tenders) {
      this.tenders = tenders;
      return this;
   }

   @ApiModelProperty(value = "An array of tenders used to pay for the transaction.")
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
      sb.append("    msisdn: ").append(Utils.toIndentedString(msisdn)).append("\n");
      sb.append("    tenders: ").append(Utils.toIndentedString(tenders)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
