package io.electrum.prepaidutility.model;

import io.electrum.vas.model.Customer;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
   private LedgerAmount arrearsAmount = null;
   private Boolean bsstDue = null;

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

   public MeterLookupResponse meter(Meter meter) {
      this.meter = meter;
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

   public MeterLookupResponse customer(Customer customer) {
      this.customer = customer;
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

   public MeterLookupResponse utility(Utility utility) {
      this.utility = utility;
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

   public MeterLookupResponse minAmount(LedgerAmount minAmount) {
      this.minAmount = minAmount;
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
   public LedgerAmount getArrearsAmount() {
      return arrearsAmount;
   }

   public void setArrearsAmount(LedgerAmount arrearsAmount) {
      this.arrearsAmount = arrearsAmount;
   }

   public MeterLookupResponse arrearsAmount(LedgerAmount arrearsAmount) {
      this.arrearsAmount = arrearsAmount;
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

   public MeterLookupResponse bsstDue(Boolean bsstDue) {
      this.bsstDue = bsstDue;
      return this;
   }

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("MeterLookupResponse{");
      sb.append("meter=").append(meter);
      sb.append(", customer=").append(customer);
      sb.append(", utility=").append(utility);
      sb.append(", minAmount=").append(minAmount);
      sb.append(", maxAmount=").append(maxAmount);
      sb.append(", arrearsAmount=").append(arrearsAmount);
      sb.append(", bsstDue=").append(bsstDue);
      sb.append(", id='").append(id).append('\'');
      sb.append(", time=").append(time);
      sb.append(", originator=").append(originator);
      sb.append(", client=").append(client);
      sb.append(", settlementEntity=").append(settlementEntity);
      sb.append(", receiver=").append(receiver);
      sb.append(", thirdPartyIdentifiers=").append(thirdPartyIdentifiers);
      sb.append('}');
      return sb.toString();
   }
}
