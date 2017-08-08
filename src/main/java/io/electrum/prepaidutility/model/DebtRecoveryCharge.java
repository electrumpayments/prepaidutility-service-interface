package io.electrum.prepaidutility.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.electrum.vas.Utils;
import io.electrum.vas.model.LedgerAmount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a charge deducted from the purchase to recover outstanding debt
 */
@ApiModel(description = "Represents a charge deducted from the purchase to recover outstanding debt")
@JsonInclude(Include.NON_NULL)
public class DebtRecoveryCharge {

   private TaxableAmount amount = null;
   private String description = null;
   private LedgerAmount balance = null;
   private String receiptNum = null;

   /**
    * Amount charged and tax levied for debt recovery, in minor denomination.
    **/
   public DebtRecoveryCharge amount(TaxableAmount amount) {
      this.amount = amount;
      return this;
   }

   @ApiModelProperty(required = true, value = "Amount charged and tax levied for debt recovery, in minor denomination.")
   @NotNull
   @Valid
   public TaxableAmount getAmount() {
      return amount;
   }

   public void setAmount(TaxableAmount amount) {
      this.amount = amount;
   }

   /**
    * Description of this debt recovery charge (e.g. municipal rates arrears).
    **/
   public DebtRecoveryCharge description(String description) {
      this.description = description;
      return this;
   }

   @ApiModelProperty(required = true, value = "Description of this debt recovery charge (e.g. municipal rates arrears).")
   @NotNull
   @Length(max = 40)
   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   /**
    * Remaining balance on this account.
    **/
   public DebtRecoveryCharge balance(LedgerAmount balance) {
      this.balance = balance;
      return this;
   }

   @ApiModelProperty(required = true, value = "Remaining balance on this account.")
   @NotNull
   @Valid
   public LedgerAmount getBalance() {
      return balance;
   }

   public void setBalance(LedgerAmount balance) {
      this.balance = balance;
   }

   /**
    * Receipt number for this charge.
    **/
   public DebtRecoveryCharge receiptNum(String receiptNum) {
      this.receiptNum = receiptNum;
      return this;
   }

   @ApiModelProperty(value = "Receipt number for this charge.")
   @Length(max = 30)
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
      return Objects.equals(this.amount, debtRecoveryCharge.amount)
            && Objects.equals(this.description, debtRecoveryCharge.description)
            && Objects.equals(this.balance, debtRecoveryCharge.balance)
            && Objects.equals(this.receiptNum, debtRecoveryCharge.receiptNum);
   }

   @Override
   public int hashCode() {
      return Objects.hash(amount, description, balance, receiptNum);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class DebtRecoveryCharge {\n");

      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    description: ").append(Utils.toIndentedString(description)).append("\n");
      sb.append("    balance: ").append(Utils.toIndentedString(balance)).append("\n");
      sb.append("    receiptNum: ").append(Utils.toIndentedString(receiptNum)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
