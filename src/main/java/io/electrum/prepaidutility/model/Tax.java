package io.electrum.prepaidutility.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a tax levied on the transaction
 */
@ApiModel(description = "Represents a tax levied on the transaction")
public class Tax {

   private Amount amount = null;
   private String description = null;
   private BigDecimal rate = null;

   public Tax amount(Amount amount) {
      this.amount = amount;
      return this;
   }

   /**
    * Amount of tax levied in minor denomination.
    * 
    * @return amount
    **/
   @ApiModelProperty(required = true, value = "Amount of tax levied in minor denomination.")
   @NotNull
   public Amount getAmount() {
      return amount;
   }

   public void setAmount(Amount amount) {
      this.amount = amount;
   }

   public Tax description(String description) {
      this.description = description;
      return this;
   }

   /**
    * Description of the type of tax (e.g. VAT).
    * 
    * @return description
    **/
   @ApiModelProperty(required = true, value = "Description of the type of tax (e.g. VAT).")
   @NotNull
   @Length(max = 10)
   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Tax rate(BigDecimal rate) {
      this.rate = rate;
      return this;
   }

   /**
    * Rate at which tax is levied, expressed as a percentage.
    * 
    * @return rate
    **/
   @ApiModelProperty(required = true, value = "Rate at which tax is levied, expressed as a percentage.")
   @NotNull
   public BigDecimal getRate() {
      return rate;
   }

   public void setRate(BigDecimal rate) {
      this.rate = rate;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Tax tax = (Tax) o;
      return Objects.equals(this.amount, tax.amount) && Objects.equals(this.description, tax.description)
            && Objects.equals(this.rate, tax.rate);
   }

   @Override
   public int hashCode() {
      return Objects.hash(amount, description, rate);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Tax {\n");

      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    description: ").append(Utils.toIndentedString(description)).append("\n");
      sb.append("    rate: ").append(Utils.toIndentedString(rate)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
