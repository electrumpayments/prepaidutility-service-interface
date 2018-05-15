package io.electrum.prepaidutility.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.PaymentMethod;
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

   private Meter meter;
   private LedgerAmount purchaseAmount;
   private String utilityType;
   private String msisdn;
   private List<Tender> tenders = new ArrayList<>();
   private List<PaymentMethod> paymentMethods = null;

   /**
    * Details of the meter for which a purchase is requested. The object must include at least a value for meterId.
    **/
   public PurchaseRequest meterId(Meter meter) {
      this.meter = meter;
      return this;
   }

   @ApiModelProperty(required = true, value = "Details of the meter for which a purchase is requested. The object must include at least a value for meterId.")
   @NotNull
   @Valid
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
   @Valid
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

   @ApiModelProperty(value = "Mobile phone number of the customer to which the outcome of a transaction can be communicated. This should conform to the ITU E.164 numbering plan (https://www.itu.int/rec/T-REC-E.164/en), but a 10-digit number beginning with zero is also acceptable.")
   @Pattern(regexp = "(^\\+?[1-9]\\d{1,14})|(^[0][0-9]{9})")
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

   @ApiModelProperty(required = false, value = "An array of tenders used to pay for the transaction. This is used " +
         "if payment is tendered at the point of sale. A Tender differs from a PaymentMethod in that the former " +
         "represents a payment that has already been collected at the point of sale, whereas the latter represents " +
         "a payment that still needs to be collected from a third party.")
   @Valid
   public List<Tender> getTenders() {
      return tenders;
   }

   public void setTenders(List<Tender> tenders) {
      this.tenders = tenders;
   }

   /**
    * An array of payment methods used to pay for the transaction.
    */
   public PurchaseRequest paymentMethods(List<PaymentMethod> paymentMethods) {
      this.paymentMethods = paymentMethods;
      return this;
   }

   @ApiModelProperty(required = false, value = "An array of payment methods to be used as payment for the " +
         "transaction. This is used if payment is not tendered at the point of sale, but is effected through one " +
         "or more calls to third party payment providers as part of the request. A PaymentMethod differs from a " +
         "Tender in that the former represents payment that still needs to be collected from a third party, " +
         "whereas the latter represents payment that has already been collected at the point of sale.")
   @JsonProperty("paymentMethods")
   public List<PaymentMethod> getPaymentMethods() {
      return paymentMethods;
   }

   public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
      this.paymentMethods = paymentMethods;
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
      sb.append("    paymentMethods: ").append(Utils.toIndentedString(paymentMethods)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
