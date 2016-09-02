package io.electrum.prepaidutility.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ServiceCharge
 */
@ApiModel(description = "Represents a service charge deducted from the purchase amount")
public class ServiceCharge {

   private Amount amount = null;
   private Tax tax = null;
   private String description = null;

   public ServiceCharge amount(Amount amount) {
      this.amount = amount;
      return this;
   }

   /**
    * Amount charged for the service.
    * 
    * @return amount
    **/
   @ApiModelProperty(required = true, value = "Amount charged for the service.")
   @NotNull
   public Amount getAmount() {
      return amount;
   }

   public void setAmount(Amount amount) {
      this.amount = amount;
   }

   public ServiceCharge tax(Tax tax) {
      this.tax = tax;
      return this;
   }

   /**
    * Tax levied on this charge.
    * 
    * @return tax
    **/
   @ApiModelProperty(required = true, value = "Tax levied on this charge.")
   @NotNull
   public Tax getTax() {
      return tax;
   }

   public void setTax(Tax tax) {
      this.tax = tax;
   }

   public ServiceCharge description(String description) {
      this.description = description;
      return this;
   }

   /**
    * Description of this service charge (e.g. connection fee).
    * 
    * @return description
    **/
   @ApiModelProperty(required = true, value = "Description of this service charge (e.g. connection fee).")
   @NotNull
   @Length(max = 40)
   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ServiceCharge serviceCharge = (ServiceCharge) o;
      return Objects.equals(this.amount, serviceCharge.amount) && Objects.equals(this.tax, serviceCharge.tax)
            && Objects.equals(this.description, serviceCharge.description);
   }

   @Override
   public int hashCode() {
      return Objects.hash(amount, tax, description);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ServiceCharge {\n");

      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    tax: ").append(Utils.toIndentedString(tax)).append("\n");
      sb.append("    description: ").append(Utils.toIndentedString(description)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
