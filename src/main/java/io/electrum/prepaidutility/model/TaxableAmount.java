package io.electrum.prepaidutility.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import io.electrum.vas.Utils;
import io.electrum.vas.model.LedgerAmount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents an amount on which tax has been levied
 */
@ApiModel(description = "Represents an amount on which tax has been levied")
public class TaxableAmount extends LedgerAmount {

   private Long tax = null;
   private String taxType = null;
   private BigDecimal taxRate = null;

   public TaxableAmount tax(Long tax) {
      this.tax = tax;
      return this;
   }

   /**
    * Tax amount. Only present and non-zero if the <code>amount</code> field is exclusive of tax.
    * 
    * @return tax
    */
   @ApiModelProperty(required = true, value = "Tax amount. Only present and non-zero if the amount field is exclusive of tax.")
   @NotNull
   public Long getTax() {
      return tax;
   }

   public void setTax(Long tax) {
      this.tax = tax;
   }

   public TaxableAmount taxType(String taxType) {
      this.taxType = taxType;
      return this;
   }

   /**
    * Description of the type of tax (e.g. VAT).
    * 
    * @return taxType
    **/
   @ApiModelProperty(required = true, value = "Description of the type of tax (e.g. VAT).")
   @NotNull
   @Length(max = 10)
   public String getTaxType() {
      return taxType;
   }

   public void setTaxType(String taxType) {
      this.taxType = taxType;
   }

   public TaxableAmount rate(BigDecimal rate) {
      this.taxRate = rate;
      return this;
   }

   /**
    * Rate at which tax is levied, expressed as a percentage.
    * 
    * @return taxRate
    **/
   @ApiModelProperty(required = true, value = "Rate at which tax is levied, expressed as a percentage.")
   @NotNull
   public BigDecimal getTaxRate() {
      return taxRate;
   }

   public void setTaxRate(BigDecimal rate) {
      this.taxRate = rate;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      TaxableAmount tax = (TaxableAmount) o;
      return Objects.equals(this.amount, tax.amount) && Objects.equals(this.currency, tax.currency)
            && Objects.equals(ledgerIndicator, tax.ledgerIndicator) && Objects.equals(this.tax, tax.tax)
            && Objects.equals(this.taxType, tax.taxType) && Objects.equals(this.taxRate, tax.taxRate);
   }

   @Override
   public int hashCode() {
      return Objects.hash(amount, currency, ledgerIndicator, tax, taxType, taxRate);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class TaxableAmount {\n");

      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    currency: ").append(Utils.toIndentedString(currency)).append("\n");
      sb.append("    ledgerIndicator: ").append(Utils.toIndentedString(ledgerIndicator)).append("\n");
      sb.append("    tax: ").append(Utils.toIndentedString(tax)).append("\n");
      sb.append("    taxType: ").append(Utils.toIndentedString(taxType)).append("\n");
      sb.append("    taxRate: ").append(Utils.toIndentedString(taxRate)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
