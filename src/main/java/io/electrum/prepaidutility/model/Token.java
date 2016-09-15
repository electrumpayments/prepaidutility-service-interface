package io.electrum.prepaidutility.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a prepaid utility token
 */
@ApiModel(description = "Represents a prepaid utility token")
@JsonInclude(Include.NON_NULL)
public class Token {
   /**
    * Type of token, namely standard (STD), basic service support tariff (BSST), refund (REFUND), key change (KC).
    */
   public enum TokenTypeEnum {
      STD("STD"), BSST("BSST"), REFUND("REFUND"), KC("KC");

      private String value;

      TokenTypeEnum(String value) {
         this.value = value;
      }

      @Override
      public String toString() {
         return String.valueOf(value);
      }
   }

   private TokenTypeEnum tokenType = null;
   private BigDecimal units = null;
   private TaxableAmount amount = null;
   private String receiptNum = null;
   private String token = null;
   private List<TariffBlock> tariffCalc = new ArrayList<TariffBlock>();

   public Token tokenType(TokenTypeEnum tokenType) {
      this.tokenType = tokenType;
      return this;
   }

   /**
    * Type of token, namely standard (STD), basic service support tariff (BSST), refund (REFUND), key change (KC).
    * 
    * @return tokenType
    **/
   @ApiModelProperty(required = true, value = "Type of token, namely standard (STD), basic service support tariff (BSST), refund (REFUND), key change (KC).")
   @NotNull
   public TokenTypeEnum getTokenType() {
      return tokenType;
   }

   public void setTokenType(TokenTypeEnum tokenType) {
      this.tokenType = tokenType;
   }

   public Token units(BigDecimal units) {
      this.units = units;
      return this;
   }

   /**
    * Number of units redeemable by this token.
    * 
    * @return units
    **/
   @ApiModelProperty(required = true, value = "Number of units redeemable by this token.")
   @NotNull
   public BigDecimal getUnits() {
      return units;
   }

   public void setUnits(BigDecimal units) {
      this.units = units;
   }

   public Token amount(TaxableAmount amount) {
      this.amount = amount;
      return this;
   }

   /**
    * Monetary value of the token.
    * 
    * @return amount
    **/
   @ApiModelProperty(required = true, value = "Monetary value of the token")
   @NotNull
   public TaxableAmount getAmount() {
      return amount;
   }

   public void setAmount(TaxableAmount amount) {
      this.amount = amount;
   }

   public Token receiptNum(String receiptNum) {
      this.receiptNum = receiptNum;
      return this;
   }

   /**
    * Receipt number issued for the transaction.
    * 
    * @return receiptNum
    **/
   @ApiModelProperty(value = "Receipt number issued for the transaction.")
   public String getReceiptNum() {
      return receiptNum;
   }

   public void setReceiptNum(String receiptNum) {
      this.receiptNum = receiptNum;
   }

   public Token token(String token) {
      this.token = token;
      return this;
   }

   /**
    * Numeric sequence to be entered into the meter to redeem the token's value.
    * 
    * @return token
    **/
   @ApiModelProperty(required = true, value = "Numeric sequence to be entered into the meter to redeem the token's value.")
   @NotNull
   public String getToken() {
      return token;
   }

   public void setToken(String token) {
      this.token = token;
   }

   public Token tariffCalc(List<TariffBlock> tariffCalc) {
      this.tariffCalc = tariffCalc;
      return this;
   }

   public Token addTariffCalcItem(TariffBlock tariffCalcItem) {
      this.tariffCalc.add(tariffCalcItem);
      return this;
   }

   /**
    * List of tariff blocks determining how the overall tariff is calculated.
    * 
    * @return tariffCalc
    **/
   @ApiModelProperty(value = "List of tariff blocks determining how the overall tariff is calculated.")
   public List<TariffBlock> getTariffCalc() {
      return tariffCalc;
   }

   public void setTariffCalc(List<TariffBlock> tariffCalc) {
      this.tariffCalc = tariffCalc;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Token token = (Token) o;
      return Objects.equals(this.tokenType, token.tokenType) && Objects.equals(this.units, token.units)
            && Objects.equals(this.amount, token.amount) && Objects.equals(this.receiptNum, token.receiptNum)
            && Objects.equals(this.token, token.token) && Objects.equals(this.tariffCalc, token.tariffCalc);
   }

   @Override
   public int hashCode() {
      return Objects.hash(tokenType, units, amount, receiptNum, token, tariffCalc);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Token {\n");

      sb.append("    tokenType: ").append(Utils.toIndentedString(tokenType)).append("\n");
      sb.append("    units: ").append(Utils.toIndentedString(units)).append("\n");
      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    receiptNum: ").append(Utils.toIndentedString(receiptNum)).append("\n");
      sb.append("    token: ").append(Utils.toIndentedString(token)).append("\n");
      sb.append("    tariffCalc: ").append(Utils.toIndentedString(tariffCalc)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
