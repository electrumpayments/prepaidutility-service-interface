package io.electrum.prepaidutility.model;

import java.math.BigDecimal;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a block of units charged at a specific tariffO
 */
@ApiModel(description = "Represents a block of units charged at a specific tariff")
public class TariffBlock {

   private BigDecimal units = null;
   private BigDecimal rate = null;

   public TariffBlock units(BigDecimal units) {
      this.units = units;
      return this;
   }

   /**
    * Number of units in this tariff block.
    * 
    * @return units
    **/
   @ApiModelProperty(required = true, value = "Number of units in this tariff block.")
   public BigDecimal getUnits() {
      return units;
   }

   public void setUnits(BigDecimal units) {
      this.units = units;
   }

   public TariffBlock rate(BigDecimal rate) {
      this.rate = rate;
      return this;
   }

   /**
    * Tariff rate for this block in minor denomination.
    * 
    * @return rate
    **/
   @ApiModelProperty(required = true, value = "Tariff rate for this block in minor denomination.")
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
      TariffBlock tariffBlock = (TariffBlock) o;
      return Objects.equals(this.units, tariffBlock.units) && Objects.equals(this.rate, tariffBlock.rate);
   }

   @Override
   public int hashCode() {
      return Objects.hash(units, rate);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class TariffBlock {\n");

      sb.append("    units: ").append(toIndentedString(units)).append("\n");
      sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
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
