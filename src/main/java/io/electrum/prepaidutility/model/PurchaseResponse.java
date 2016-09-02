package io.electrum.prepaidutility.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Customer;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents the response to a token purchase request
 */
@ApiModel(description = "Represents the response to a token purchase request")
@JsonInclude(Include.NON_NULL)
public class PurchaseResponse extends Transaction {

   private Meter meter = null;
   private Customer customer = null;
   private Utility utility = null;
   private String utilityType = null;
   private List<Token> tokens = new ArrayList<Token>();
   private List<DebtRecoveryCharge> debtRecoveryCharges = new ArrayList<DebtRecoveryCharge>();
   private List<ServiceCharge> serviceCharges = new ArrayList<ServiceCharge>();
   private PrintableSlip printableSlip = null;

   public PurchaseResponse meter(Meter meter) {
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
   public Meter getMeter() {
      return meter;
   }

   public void setMeter(Meter meter) {
      this.meter = meter;
   }

   public PurchaseResponse customer(Customer customer) {
      this.customer = customer;
      return this;
   }

   /**
    * Details of the person or organization to whom the meter belongs.
    * 
    * @return customer
    **/
   @ApiModelProperty(required = true, value = "Details of the person or organization to whom the meter belongs.")
   @NotNull
   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   public PurchaseResponse utility(Utility utility) {
      this.utility = utility;
      return this;
   }

   /**
    * Details of the utility which manages this meter's account.
    * 
    * @return utility
    **/
   @ApiModelProperty(required = true, value = "Details of the utility which manages this meter's account.")
   @NotNull
   public Utility getUtility() {
      return utility;
   }

   public void setUtility(Utility utility) {
      this.utility = utility;
   }

   public PurchaseResponse utilityType(String utilityType) {
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

   public PurchaseResponse tokens(List<Token> tokens) {
      this.tokens = tokens;
      return this;
   }

   public PurchaseResponse addTokensItem(Token tokensItem) {
      this.tokens.add(tokensItem);
      return this;
   }

   /**
    * List of tokens issued for the purchase.
    * 
    * @return tokens
    **/
   @ApiModelProperty(value = "List of tokens issued for the purchase.")
   public List<Token> getTokens() {
      return tokens;
   }

   public void setTokens(List<Token> tokens) {
      this.tokens = tokens;
   }

   public PurchaseResponse debtRecoveryCharges(List<DebtRecoveryCharge> debtRecoveryCharges) {
      this.debtRecoveryCharges = debtRecoveryCharges;
      return this;
   }

   public PurchaseResponse addDebtRecoveryChargesItem(DebtRecoveryCharge debtRecoveryChargesItem) {
      this.debtRecoveryCharges.add(debtRecoveryChargesItem);
      return this;
   }

   /**
    * List of charges that have been levied in order to reclaim outstanding debts associated with the meter.
    * 
    * @return debtRecoveryCharges
    **/
   @ApiModelProperty(value = "List of charges that have been levied in order to reclaim outstanding debts associated with the meter.")
   public List<DebtRecoveryCharge> getDebtRecoveryCharges() {
      return debtRecoveryCharges;
   }

   public void setDebtRecoveryCharges(List<DebtRecoveryCharge> debtRecoveryCharges) {
      this.debtRecoveryCharges = debtRecoveryCharges;
   }

   public PurchaseResponse serviceCharges(List<ServiceCharge> serviceCharges) {
      this.serviceCharges = serviceCharges;
      return this;
   }

   public PurchaseResponse addServiceChargesItem(ServiceCharge serviceChargesItem) {
      this.serviceCharges.add(serviceChargesItem);
      return this;
   }

   /**
    * List of service charges levied against this meter.
    * 
    * @return serviceCharges
    **/
   @ApiModelProperty(value = "List of service charges levied against this meter.")
   public List<ServiceCharge> getServiceCharges() {
      return serviceCharges;
   }

   public void setServiceCharges(List<ServiceCharge> serviceCharges) {
      this.serviceCharges = serviceCharges;
   }

   public PurchaseResponse printableSlip(PrintableSlip printableSlip) {
      this.printableSlip = printableSlip;
      return this;
   }

   /**
    * A ready-to-print till slip. This is supplied by some providers either in addition to or in place of individual
    * message elements. Where present, it must be used by POS to print the slip.
    * 
    * @return printableSlip
    */
   @ApiModelProperty(value = "A ready-to-print till slipA ready-to-print till slip. This is supplied by some providers either in addition to or in place of individual message elements. Where present, it must be used by POS to print the slip.")
   public PrintableSlip getPrintableSlip() {
      return printableSlip;
   }

   public void setPrintableSlip(PrintableSlip printableSlip) {
      this.printableSlip = printableSlip;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PurchaseResponse {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    meter: ").append(Utils.toIndentedString(meter)).append("\n");
      sb.append("    customer: ").append(Utils.toIndentedString(customer)).append("\n");
      sb.append("    utility: ").append(Utils.toIndentedString(utility)).append("\n");
      sb.append("    utilityType: ").append(Utils.toIndentedString(utilityType)).append("\n");
      sb.append("    tokens: ").append(Utils.toIndentedString(tokens)).append("\n");
      sb.append("    debtRecoveryCharges: ").append(Utils.toIndentedString(debtRecoveryCharges)).append("\n");
      sb.append("    serviceCharges: ").append(Utils.toIndentedString(serviceCharges)).append("\n");
      sb.append("    printableSlip: ").append(Utils.toIndentedString(printableSlip)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
