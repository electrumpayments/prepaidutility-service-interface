package io.electrum.prepaidutility.model;

import java.util.Objects;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data associated with a prepaid utility meter
 */
@ApiModel(description = "Data associated with a prepaid utility meter")
@JsonInclude(Include.NON_NULL)
public class Meter {

   private String meterId = null;
   private String serviceType = null;
   private String supplyGroupCode = null;
   private String keyRevisionNum = null;
   private String tariffIndex = null;
   private String tokenTechCode = null;
   private String algorithmCode = null;
   private String newSupplyGroupCode = null;
   private String newKeyRevisionNumber = null;
   private String newTariffIndex = null;

   public Meter meterId(String meterId) {
      this.meterId = meterId;
      return this;
   }

   /**
    * Unique identifier for the meter (e.g. serial number).
    * 
    * @return meterId
    **/
   @ApiModelProperty(required = true, value = "Unique identifier for the meter (e.g. serial number).")
   @Pattern(regexp = "[a-zA-Z0-9]{0,20}")
   public String getMeterId() {
      return meterId;
   }

   public void setMeterId(String meterId) {
      this.meterId = meterId;
   }

   public Meter serviceType(String serviceType) {
      this.serviceType = serviceType;
      return this;
   }

   /**
    * Type of service dispensed by this meter (e.g. electricity, water or gas).
    * 
    * @return serviceType
    **/
   @ApiModelProperty(value = "Type of service dispensed by this meter (e.g. electricity, water or gas).")
   @Pattern(regexp = "[a-zA-Z0-9]{0,12}")
   public String getServiceType() {
      return serviceType;
   }

   public void setServiceType(String serviceType) {
      this.serviceType = serviceType;
   }

   public Meter supplyGroupCode(String supplyGroupCode) {
      this.supplyGroupCode = supplyGroupCode;
      return this;
   }

   /**
    * Code used to identify a group of suppliers.
    * 
    * @return supplyGroupCode
    **/
   @ApiModelProperty(value = "Code used to identify a group of suppliers.")
   @Pattern(regexp = "[0-9]{6}")
   public String getSupplyGroupCode() {
      return supplyGroupCode;
   }

   public void setSupplyGroupCode(String supplyGroupCode) {
      this.supplyGroupCode = supplyGroupCode;
   }

   public Meter keyRevisionNum(String keyRevisionNum) {
      this.keyRevisionNum = keyRevisionNum;
      return this;
   }

   /**
    * Key revision number of the meter.
    * 
    * @return keyRevisionNum
    **/
   @ApiModelProperty(value = "Key revision number of the meter.")
   @Pattern(regexp = "[0-9]{1}")
   public String getKeyRevisionNum() {
      return keyRevisionNum;
   }

   public void setKeyRevisionNum(String keyRevisionNum) {
      this.keyRevisionNum = keyRevisionNum;
   }

   public Meter tariffIndex(String tariffIndex) {
      this.tariffIndex = tariffIndex;
      return this;
   }

   /**
    * Code representing the tariff associated with this meter.
    * 
    * @return tariffIndex
    **/
   @ApiModelProperty(value = "Code representing the tariff associated with this meter.")
   @Pattern(regexp = "[0-9]{2}")
   public String getTariffIndex() {
      return tariffIndex;
   }

   public void setTariffIndex(String tariffIndex) {
      this.tariffIndex = tariffIndex;
   }

   public Meter tokenTechCode(String tokenTechCode) {
      this.tokenTechCode = tokenTechCode;
      return this;
   }

   /**
    * The means by which tokens are supplied for this meter (typically either numeric token or magnetic track).
    * 
    * @return tokenTechCode
    **/
   @ApiModelProperty(value = "The means by which tokens are supplied for this meter (typically either numeric token or magnetic track).")
   @Pattern(regexp = "[0-9]{2}")
   public String getTokenTechCode() {
      return tokenTechCode;
   }

   public void setTokenTechCode(String tokenTechCode) {
      this.tokenTechCode = tokenTechCode;
   }

   public Meter algorithmCode(String algorithmCode) {
      this.algorithmCode = algorithmCode;
      return this;
   }

   /**
    * Code used to identify token encryption algorithm used by the meter.
    * 
    * @return algorithmCode
    **/
   @ApiModelProperty(value = "Code used to identify token encryption algorithm used by the meter.")
   @Pattern(regexp = "[0-9]{2}")
   public String getAlgorithmCode() {
      return algorithmCode;
   }

   public void setAlgorithmCode(String algorithmCode) {
      this.algorithmCode = algorithmCode;
   }

   public Meter newSupplyGroupCode(String newSupplyGroupCode) {
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

   public Meter newKeyRevisionNumber(String newKeyRevisionNumber) {
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

   public Meter newTariffIndex(String newTariffIndex) {
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
      Meter meter = (Meter) o;
      return Objects.equals(this.meterId, meter.meterId) && Objects.equals(this.serviceType, meter.serviceType)
            && Objects.equals(this.supplyGroupCode, meter.supplyGroupCode)
            && Objects.equals(this.keyRevisionNum, meter.keyRevisionNum)
            && Objects.equals(this.tariffIndex, meter.tariffIndex)
            && Objects.equals(this.tokenTechCode, meter.tokenTechCode)
            && Objects.equals(this.algorithmCode, meter.algorithmCode)
            && Objects.equals(this.newSupplyGroupCode, meter.newSupplyGroupCode)
            && Objects.equals(this.newKeyRevisionNumber, meter.newKeyRevisionNumber)
            && Objects.equals(this.newTariffIndex, meter.newTariffIndex);
   }

   @Override
   public int hashCode() {
      return Objects.hash(
            meterId,
            serviceType,
            supplyGroupCode,
            keyRevisionNum,
            tariffIndex,
            tokenTechCode,
            algorithmCode,
            newSupplyGroupCode,
            newKeyRevisionNumber,
            newTariffIndex);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Meter {\n");

      sb.append("    meterId: ").append(toIndentedString(meterId)).append("\n");
      sb.append("    serviceType: ").append(toIndentedString(serviceType)).append("\n");
      sb.append("    supplyGroupCode: ").append(toIndentedString(supplyGroupCode)).append("\n");
      sb.append("    keyRevisionNum: ").append(toIndentedString(keyRevisionNum)).append("\n");
      sb.append("    tariffIndex: ").append(toIndentedString(tariffIndex)).append("\n");
      sb.append("    tokenTechCode: ").append(toIndentedString(tokenTechCode)).append("\n");
      sb.append("    algorithmCode: ").append(toIndentedString(algorithmCode)).append("\n");
      sb.append("    newSupplyGroupCode: ").append(toIndentedString(newSupplyGroupCode)).append("\n");
      sb.append("    newKeyRevisionNumber: ").append(toIndentedString(newKeyRevisionNumber)).append("\n");
      sb.append("    newTariffIndex: ").append(toIndentedString(newTariffIndex)).append("\n");
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
