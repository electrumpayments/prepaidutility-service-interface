package io.electrum.prepaidutility.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * DebtRecoveryCharge
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-26T07:31:58.129Z")
public class DebtRecoveryCharge {
   private Amount amount = null;

   private Tax tax = null;

   private String description = null;

   private Amount balance = null;

   private String receiptNum = null;

   public DebtRecoveryCharge amount(Amount amount) {
      this.amount = amount;
      return this;
   }

   /**
    * Amount charged for debt recovery, in minor denomination.
    * 
    * @return amount
    **/
   @ApiModelProperty(required = true, value = "Amount charged for debt recovery, in minor denomination.")
   public Amount getAmount() {
      return amount;
   }

   public void setAmount(Amount amount) {
      this.amount = amount;
   }

   public DebtRecoveryCharge tax(Tax tax) {
      this.tax = tax;
      return this;
   }

   /**
    * Tax levied on this charge.
    * 
    * @return tax
    **/
   @ApiModelProperty(required = true, value = "Tax levied on this charge.")
   public Tax getTax() {
      return tax;
   }

   public void setTax(Tax tax) {
      this.tax = tax;
   }

   public DebtRecoveryCharge description(String description) {
      this.description = description;
      return this;
   }

   /**
    * Description of this debt recovery charge (e.g. municipal rates arrears).
    * 
    * @return description
    **/
   @ApiModelProperty(required = true, value = "Description of this debt recovery charge (e.g. municipal rates arrears).")
   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public DebtRecoveryCharge balance(Amount balance) {
      this.balance = balance;
      return this;
   }

   /**
    * Remaining balance on this account.
    * 
    * @return balance
    **/
   @ApiModelProperty(required = true, value = "Remaining balance on this account.")
   public Amount getBalance() {
      return balance;
   }

   public void setBalance(Amount balance) {
      this.balance = balance;
   }

   public DebtRecoveryCharge receiptNum(String receiptNum) {
      this.receiptNum = receiptNum;
      return this;
   }

   /**
    * Receipt number for this charge.
    * 
    * @return receiptNum
    **/
   @ApiModelProperty(value = "Receipt number for this charge.")
   public String getReceiptNum() {
      return receiptNum;
   }

   public void setReceiptNum(String receiptNum) {
      this.receiptNum = receiptNum;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      DebtRecoveryCharge debtRecoveryCharge = (DebtRecoveryCharge) o;
      return Objects.equals(this.amount, debtRecoveryCharge.amount) && Objects.equals(this.tax, debtRecoveryCharge.tax)
            && Objects.equals(this.description, debtRecoveryCharge.description)
            && Objects.equals(this.balance, debtRecoveryCharge.balance)
            && Objects.equals(this.receiptNum, debtRecoveryCharge.receiptNum);
   }

   @Override
   public int hashCode() {
      return Objects.hash(amount, tax, description, balance, receiptNum);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class DebtRecoveryCharge {\n");

      sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
      sb.append("    tax: ").append(toIndentedString(tax)).append("\n");
      sb.append("    description: ").append(toIndentedString(description)).append("\n");
      sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
      sb.append("    receiptNum: ").append(toIndentedString(receiptNum)).append("\n");
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
