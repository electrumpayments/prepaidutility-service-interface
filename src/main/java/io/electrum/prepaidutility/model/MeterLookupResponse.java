package io.electrum.prepaidutility.model;

import java.util.Objects;

import io.electrum.vas.model.Customer;
import io.swagger.annotations.ApiModelProperty;

/**
 * MeterLookupResponse
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-26T07:31:58.129Z")
public class MeterLookupResponse {
   private Meter meter = null;

   private Customer customer = null;

   private Utility utility = null;

   private Amount minAmount = null;

   private Amount maxAmount = null;

   private Boolean bsstDue = null;

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
   @ApiModelProperty(value = "Details of the person or organization to whom the meter belongs.")
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
   @ApiModelProperty(value = "Details of the utility which manages this meter's account.")
   public Utility getUtility() {
      return utility;
   }

   public void setUtility(Utility utility) {
      this.utility = utility;
   }

   public MeterLookupResponse minAmount(Amount minAmount) {
      this.minAmount = minAmount;
      return this;
   }

   /**
    * Minimum purchase amount that can be requested by the customer.
    * 
    * @return minAmount
    **/
   @ApiModelProperty(value = "Minimum purchase amount that can be requested by the customer.")
   public Amount getMinAmount() {
      return minAmount;
   }

   public void setMinAmount(Amount minAmount) {
      this.minAmount = minAmount;
   }

   public MeterLookupResponse maxAmount(Amount maxAmount) {
      this.maxAmount = maxAmount;
      return this;
   }

   /**
    * Maximum purchase amount that can be requested by the customer.
    * 
    * @return maxAmount
    **/
   @ApiModelProperty(value = "Maximum purchase amount that can be requested by the customer.")
   public Amount getMaxAmount() {
      return maxAmount;
   }

   public void setMaxAmount(Amount maxAmount) {
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

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      MeterLookupResponse meterLookupResponse = (MeterLookupResponse) o;
      return Objects.equals(this.meter, meterLookupResponse.meter)
            && Objects.equals(this.customer, meterLookupResponse.customer)
            && Objects.equals(this.utility, meterLookupResponse.utility)
            && Objects.equals(this.minAmount, meterLookupResponse.minAmount)
            && Objects.equals(this.maxAmount, meterLookupResponse.maxAmount)
            && Objects.equals(this.bsstDue, meterLookupResponse.bsstDue);
   }

   @Override
   public int hashCode() {
      return Objects.hash(meter, customer, utility, minAmount, maxAmount, bsstDue);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MeterLookupResponse {\n");

      sb.append("    meter: ").append(toIndentedString(meter)).append("\n");
      sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
      sb.append("    utility: ").append(toIndentedString(utility)).append("\n");
      sb.append("    minAmount: ").append(toIndentedString(minAmount)).append("\n");
      sb.append("    maxAmount: ").append(toIndentedString(maxAmount)).append("\n");
      sb.append("    bsstDue: ").append(toIndentedString(bsstDue)).append("\n");
      sb.append("}");
      return sb.toString();
   }

   /**
    * Convert the given object to string with each line indented by 4 spaces (except the first line).
    */
   private String toIndentedString(java.lang.Object o) {
      if (o == null) {
         return "null";
      }
      return o.toString().replace("\n", "\n    ");
   }
}
