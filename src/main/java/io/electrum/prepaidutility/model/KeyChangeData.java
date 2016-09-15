package io.electrum.prepaidutility.model;

import java.util.Objects;

import javax.validation.constraints.Pattern;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents updated meter encryption key data
 */
@ApiModel(description = "Represents updated meter encryption key data")
public class KeyChangeData {

   private String newSupplyGroupCode = null;
   private String newKeyRevisionNumber = null;
   private String newTariffIndex = null;

   public KeyChangeData newSupplyGroupCode(String newSupplyGroupCode) {
      this.newSupplyGroupCode = newSupplyGroupCode;
      return this;
   }

   /**
    * New supply group code. Only relevant if this has been changed by the utility and a key change token has been
    * issued.
    * 
    * @return newSupplyGroupCode
    **/
   @ApiModelProperty(value = "New supply group code. Only relevant if this has been changed by the utility and a key change token has been issued.")
   @Pattern(regexp = "[0-9]{6}")
   public String getNewSupplyGroupCode() {
      return newSupplyGroupCode;
   }

   public void setNewSupplyGroupCode(String newSupplyGroupCode) {
      this.newSupplyGroupCode = newSupplyGroupCode;
   }

   public KeyChangeData newKeyRevisionNumber(String newKeyRevisionNumber) {
      this.newKeyRevisionNumber = newKeyRevisionNumber;
      return this;
   }

   /**
    * New key revision number. Only relevant if this has been changed by the utility and a key change token has been
    * issued.
    * 
    * @return newKeyRevisionNumber
    **/
   @ApiModelProperty(value = "New key revision number. Only relevant if this has been changed by the utility and a key change token has been issued.")
   @Pattern(regexp = "[0-9]{1}")
   public String getNewKeyRevisionNumber() {
      return newKeyRevisionNumber;
   }

   public void setNewKeyRevisionNumber(String newKeyRevisionNumber) {
      this.newKeyRevisionNumber = newKeyRevisionNumber;
   }

   public KeyChangeData newTariffIndex(String newTariffIndex) {
      this.newTariffIndex = newTariffIndex;
      return this;
   }

   /**
    * New tariff index. Only relevant if this has been changed by the utility and a key change token has been issued.
    * 
    * @return newTariffIndex
    **/
   @ApiModelProperty(value = "New tariff index. Only relevant if this has been changed by the utility and a key change token has been issued.")
   @Pattern(regexp = "[0-9]{2}")
   public String getNewTariffIndex() {
      return newTariffIndex;
   }

   public void setNewTariffIndex(String newTariffIndex) {
      this.newTariffIndex = newTariffIndex;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      KeyChangeData keyChangeData = (KeyChangeData) o;
      return Objects.equals(this.newSupplyGroupCode, keyChangeData.newSupplyGroupCode)
            && Objects.equals(this.newKeyRevisionNumber, keyChangeData.newKeyRevisionNumber)
            && Objects.equals(this.newTariffIndex, keyChangeData.newTariffIndex);
   }

   @Override
   public int hashCode() {
      return Objects.hash(newSupplyGroupCode, newKeyRevisionNumber, newTariffIndex);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class KeyChangeData {\n");

      sb.append("    newSupplyGroupCode: ").append(Utils.toIndentedString(newSupplyGroupCode)).append("\n");
      sb.append("    newKeyRevisionNumber: ").append(Utils.toIndentedString(newKeyRevisionNumber)).append("\n");
      sb.append("    newTariffIndex: ").append(Utils.toIndentedString(newTariffIndex)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
