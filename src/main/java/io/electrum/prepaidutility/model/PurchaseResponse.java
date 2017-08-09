package io.electrum.prepaidutility.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Customer;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents the response to a token purchase request
 */
@ApiModel(description = "Represents the response to a token purchase request")
@JsonInclude(Include.NON_NULL)
public class PurchaseResponse extends Transaction {

   private LedgerAmount purchaseTotal = null;
   private LedgerAmount taxTotal = null;
   private Meter meter = null;
   private Customer customer = null;
   private Utility utility = null;
   private String utilityType = null;
   private List<Token> tokens = new ArrayList<Token>();
   private List<DebtRecoveryCharge> debtRecoveryCharges = new ArrayList<DebtRecoveryCharge>();
   private List<ServiceCharge> serviceCharges = new ArrayList<ServiceCharge>();

   /**
    * The total amount charged for tokens on this purchase. This amount is exclusive of tax and also excludes any debt
    * recoveries or service charges deducted from the purchase amount.
    */
   public PurchaseResponse purchaseTotal(LedgerAmount saleTotal) {
      this.purchaseTotal = saleTotal;
      return this;
   }

   @ApiModelProperty(value = "The total amount charged for tokens on this purchase. This amount is exclusive of tax and also excludes any debt recoveries or service charges deducted from the purchase amount.")
   @Valid
   public LedgerAmount getPurchaseTotal() {
      return purchaseTotal;
   }

   public void setPurchaseTotal(LedgerAmount purchaseTotal) {
      this.purchaseTotal = purchaseTotal;
   }

   /**
    * The total tax charged for this purchase. This amount may include taxes levied on the tokens purchased, as well as
    * any taxes on debt recovery or service charges.
    */
   public PurchaseResponse taxTotal(LedgerAmount taxTotal) {
      this.taxTotal = taxTotal;
      return this;
   }

   @ApiModelProperty(value = "The total tax charged for this purchase. This amount may include taxes levied on the tokens purchased, as well as any taxes on debt recovery or service charges.")
   @Valid
   public LedgerAmount getTaxTotal() {
      return taxTotal;
   }

   public void setTaxTotal(LedgerAmount taxTotal) {
      this.taxTotal = taxTotal;
   }

   /**
    * Details of the meter.
    **/
   public PurchaseResponse meter(Meter meter) {
      this.meter = meter;
      return this;
   }

   @ApiModelProperty(required = true, value = "Details of the meter.")
   @NotNull
   @Valid
   public Meter getMeter() {
      return meter;
   }

   public void setMeter(Meter meter) {
      this.meter = meter;
   }

   /**
    * Details of the person or organization to whom the meter belongs.
    **/
   public PurchaseResponse customer(Customer customer) {
      this.customer = customer;
      return this;
   }

   @ApiModelProperty(required = true, value = "Details of the person or organization to whom the meter belongs.")
   @NotNull
   @Valid
   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   /**
    * Details of the utility which manages this meter's account.
    **/
   public PurchaseResponse utility(Utility utility) {
      this.utility = utility;
      return this;
   }

   @ApiModelProperty(required = true, value = "Details of the utility which manages this meter's account.")
   @NotNull
   @Valid
   public Utility getUtility() {
      return utility;
   }

   public void setUtility(Utility utility) {
      this.utility = utility;
   }

   /**
    * Type of utility purchase being requested (e.g. electricity, water, gas).
    **/
   public PurchaseResponse utilityType(String utilityType) {
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

   /**
    * List of tokens issued for the purchase.
    **/
   public PurchaseResponse tokens(List<Token> tokens) {
      this.tokens = tokens;
      return this;
   }

   public PurchaseResponse addTokensItem(Token tokensItem) {
      this.tokens.add(tokensItem);
      return this;
   }

   @ApiModelProperty(value = "List of tokens issued for the purchase.")
   @Valid
   public List<Token> getTokens() {
      return tokens;
   }

   public void setTokens(List<Token> tokens) {
      this.tokens = tokens;
   }

   /**
    * List of charges that have been levied in order to reclaim outstanding debts associated with the meter.
    **/
   public PurchaseResponse debtRecoveryCharges(List<DebtRecoveryCharge> debtRecoveryCharges) {
      this.debtRecoveryCharges = debtRecoveryCharges;
      return this;
   }

   public PurchaseResponse addDebtRecoveryChargesItem(DebtRecoveryCharge debtRecoveryChargesItem) {
      this.debtRecoveryCharges.add(debtRecoveryChargesItem);
      return this;
   }

   @ApiModelProperty(value = "List of charges that have been levied in order to reclaim outstanding debts associated with the meter.")
   @Valid
   public List<DebtRecoveryCharge> getDebtRecoveryCharges() {
      return debtRecoveryCharges;
   }

   public void setDebtRecoveryCharges(List<DebtRecoveryCharge> debtRecoveryCharges) {
      this.debtRecoveryCharges = debtRecoveryCharges;
   }

   /**
    * List of service charges levied against this meter.
    **/
   public PurchaseResponse serviceCharges(List<ServiceCharge> serviceCharges) {
      this.serviceCharges = serviceCharges;
      return this;
   }

   public PurchaseResponse addServiceChargesItem(ServiceCharge serviceChargesItem) {
      this.serviceCharges.add(serviceChargesItem);
      return this;
   }

   @ApiModelProperty(value = "List of service charges levied against this meter.")
   @Valid
   public List<ServiceCharge> getServiceCharges() {
      return serviceCharges;
   }

   public void setServiceCharges(List<ServiceCharge> serviceCharges) {
      this.serviceCharges = serviceCharges;
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
      sb.append("    purchaseTotal: ").append(Utils.toIndentedString(purchaseTotal)).append("\n");
      sb.append("    taxTotal: ").append(Utils.toIndentedString(taxTotal)).append("\n");
      sb.append("    meter: ").append(Utils.toIndentedString(meter)).append("\n");
      sb.append("    customer: ").append(Utils.toIndentedString(customer)).append("\n");
      sb.append("    utility: ").append(Utils.toIndentedString(utility)).append("\n");
      sb.append("    utilityType: ").append(Utils.toIndentedString(utilityType)).append("\n");
      sb.append("    tokens: ").append(Utils.toIndentedString(tokens)).append("\n");
      sb.append("    debtRecoveryCharges: ").append(Utils.toIndentedString(debtRecoveryCharges)).append("\n");
      sb.append("    serviceCharges: ").append(Utils.toIndentedString(serviceCharges)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
