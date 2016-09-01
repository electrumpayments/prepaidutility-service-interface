package io.electrum.prepaidutility.model;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a monetary amount
 */
@ApiModel(description = "Represents a monetary amount")
public class Amount {

   private Long amount = null;
   private String currency = null;

   public Amount amount(Long amount) {
      this.amount = amount;
      return this;
   }

   /**
    * Amount in minor denomination (e.g. cents).
    * 
    * @return amount
    **/
   @ApiModelProperty(required = true, value = "Amount in minor denomination (e.g. cents).")
   public Long getAmount() {
      return amount;
   }

   public void setAmount(Long amount) {
      this.amount = amount;
   }

   public Amount currency(String currency) {
      this.currency = currency;
      return this;
   }

   /**
    * Three digit numeric ISO 4217 currency code (e.g. South African Rand is encoded as 710).
    * 
    * @return currency
    **/
   @ApiModelProperty(required = true, value = "Three digit numeric ISO 4217 currency code (e.g. South African Rand is encoded as 710).")
   public String getCurrency() {
      return currency;
   }

   public void setCurrency(String currency) {
      this.currency = currency;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Amount amount = (Amount) o;
      return Objects.equals(this.amount, amount.amount) && Objects.equals(this.currency, amount.currency);
   }

   @Override
   public int hashCode() {
      return Objects.hash(amount, currency);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Amount {\n");

      sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
      sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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
