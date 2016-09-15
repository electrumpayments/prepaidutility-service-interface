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

   private TaxableAmount amount = null;
   private String description = null;

   public ServiceCharge amount(TaxableAmount amount) {
      this.amount = amount;
      return this;
   }

   /**
    * Amount charged and tax levied for the service.
    * 
    * @return amount
    **/
   @ApiModelProperty(required = true, value = "Amount charged and tax levied for the service.")
   @NotNull
   public TaxableAmount getAmount() {
      return amount;
   }

   public void setAmount(TaxableAmount amount) {
      this.amount = amount;
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
      return Objects.equals(this.amount, serviceCharge.amount)
            && Objects.equals(this.description, serviceCharge.description);
   }

   @Override
   public int hashCode() {
      return Objects.hash(amount, description);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ServiceCharge {\n");

      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    description: ").append(Utils.toIndentedString(description)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
