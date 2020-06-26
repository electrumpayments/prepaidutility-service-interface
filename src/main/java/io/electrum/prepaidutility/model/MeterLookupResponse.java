package io.electrum.prepaidutility.model;

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
 * Represents a response to a meter lookup request
 */
@ApiModel(description = "Represents a response to a meter lookup request")
@JsonInclude(Include.NON_NULL)
public class MeterLookupResponse extends Transaction {

   private Meter meter = null;
   private Customer customer = null;
   private Utility utility = null;
   private LedgerAmount minAmount = null;
   private LedgerAmount maxAmount = null;
   private Boolean bsstDue = null;
   /**
    * @since v3.9.0
    */
   private LedgerAmount balanceAmount = null;

   public MeterLookupResponse meter(Meter meter) {
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

   public MeterLookupResponse customer(Customer customer) {
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
   @Valid
   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   public MeterLookupResponse utility(Utility utility) {
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
   @Valid
   public Utility getUtility() {
      return utility;
   }

   public void setUtility(Utility utility) {
      this.utility = utility;
   }

   public MeterLookupResponse minAmount(LedgerAmount minAmount) {
      this.minAmount = minAmount;
      return this;
   }

   /**
    * Minimum purchase amount that can be requested by the customer.
    * 
    * @return minAmount
    **/
   @ApiModelProperty(value = "Minimum purchase amount that can be requested by the customer.")
   @Valid
   public LedgerAmount getMinAmount() {
      return minAmount;
   }

   public void setMinAmount(LedgerAmount minAmount) {
      this.minAmount = minAmount;
   }

   public MeterLookupResponse maxAmount(LedgerAmount maxAmount) {
      this.maxAmount = maxAmount;
      return this;
   }

   /**
    * Maximum purchase amount that can be requested by the customer.
    * 
    * @return maxAmount
    **/
   @ApiModelProperty(value = "Maximum purchase amount that can be requested by the customer.")
   @Valid
   public LedgerAmount getMaxAmount() {
      return maxAmount;
   }

   public void setMaxAmount(LedgerAmount maxAmount) {
      this.maxAmount = maxAmount;
   }

   public MeterLookupResponse bsstDue(Boolean bsstDue) {
      this.bsstDue = bsstDue;
      return this;
   }

   /**
    * Boolean flag indicating whether a free basic service support token is owing on this meter. Not all meters support
    * this and typically only one free token is issued per calendar month. If the value of this field is true, then a
    * purchase request with an amount of 0 can be sent and the response will contain the free token.
    * 
    * @return bsstDue
    **/
   @ApiModelProperty(value = "Boolean flag indicating whether a free basic service support token is owing on this meter. Not all meters support this and typically only one free token is issued per calendar month. If the value of this field is true, then a purchase request with an amount of 0 can be sent and the response will contain the free token.")
   public Boolean getBsstDue() {
      return bsstDue;
   }

   public void setBsstDue(Boolean bsstDue) {
      this.bsstDue = bsstDue;
   }

   public MeterLookupResponse balanceAmount(LedgerAmount balanceAmount) {
      this.balanceAmount = balanceAmount;
      return this;
   }

   /**
    * The balance of the customer's account. If the customer is in debt, a portion of their purchase may be allocated by
    * the authority to repay the debt rather than to pay for electricity units.
    * 
    * @return balanceAmount
    * @since v3.9.0
    **/
   @ApiModelProperty(value = "The balance of the customer's account. If the customer is in debt, a portion of their purchase may be allocated by the authority to repay the debt rather than to pay for electricity units.")
   @Valid
   public LedgerAmount getBalanceAmount() {
      return balanceAmount;
   }

   public void setBalanceAmount(LedgerAmount balanceAmount) {
      this.balanceAmount = balanceAmount;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MeterLookupResponse {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append('\n');
      sb.append("    time: ").append(Utils.toIndentedString(time)).append('\n');
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append('\n');
      sb.append("    client: ").append(Utils.toIndentedString(client)).append('\n');
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append('\n');
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append('\n');
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append('\n');
      sb.append("    meter: ").append(Utils.toIndentedString(meter)).append('\n');
      sb.append("    customer: ").append(Utils.toIndentedString(customer)).append('\n');
      sb.append("    utility: ").append(Utils.toIndentedString(utility)).append('\n');
      sb.append("    minAmount: ").append(Utils.toIndentedString(minAmount)).append('\n');
      sb.append("    maxAmount: ").append(Utils.toIndentedString(maxAmount)).append('\n');
      sb.append("    bsstDue: ").append(Utils.toIndentedString(bsstDue)).append('\n');
      sb.append("    balanceAmount: ").append(Utils.toIndentedString(balanceAmount)).append('\n');
      sb.append('}');
      return sb.toString();
   }
}
