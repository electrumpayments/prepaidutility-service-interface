package io.electrum.prepaidutility.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data associated with a prepaid utility meter
 */
@ApiModel(description = "Data associated with a prepaid utility meter")
@JsonInclude(Include.NON_NULL)
public class Meter {

   private String meterId = null;
   private String track2Data = null;
   private String serviceType = null;
   private String supplyGroupCode = null;
   private String keyRevisionNum = null;
   private String tariffIndex = null;
   private String tokenTechCode = null;
   private String algorithmCode = null;
   private KeyChangeData keyChangeData = null;

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
   @NotNull
   @Pattern(regexp = "[a-zA-Z0-9]{0,20}")
   public String getMeterId() {
      return meterId;
   }

   public void setMeterId(String meterId) {
      this.meterId = meterId;
   }

   public Meter track2Data(String track2Data) {
      this.track2Data = track2Data;
      return this;
   }

   /**
    * Track 2 data stored on the magnetic stripe of a card that is supplied with certain meters. This data contains all
    * meter details. It can be used as an alternative means of input at PoS and may be required by some providers.
    * 
    * @return track2Data
    **/
   @ApiModelProperty(value = "Track 2 data stored on the magnetic stripe of a card that is supplied with certain meters. This data contains all meter details. It can be used as an alternative means of input at PoS and may be required by some providers.")
   @Pattern(regexp = "[a-zA-Z0-9=]{34}")
   public String getTrack2Data() {
      return track2Data;
   }

   public void setTrack2Data(String track2Data) {
      this.track2Data = track2Data;
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

   public Meter keyChangeData(KeyChangeData keyChangeData) {
      this.keyChangeData = keyChangeData;
      return this;
   }

   /**
    * Represents new meter data in the case that these these have been updated.
    * 
    * @return keyChangeData
    **/
   @ApiModelProperty(value = "Represents new meter data in the case that these these have been updated.")
   @Valid
   public KeyChangeData getKeyChangeData() {
      return keyChangeData;
   }

   public void setKeyChangeData(KeyChangeData keyChangeData) {
      this.keyChangeData = keyChangeData;
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
            && Objects.equals(this.track2Data, meter.track2Data)
            && Objects.equals(this.supplyGroupCode, meter.supplyGroupCode)
            && Objects.equals(this.keyRevisionNum, meter.keyRevisionNum)
            && Objects.equals(this.tariffIndex, meter.tariffIndex)
            && Objects.equals(this.tokenTechCode, meter.tokenTechCode)
            && Objects.equals(this.algorithmCode, meter.algorithmCode)
            && Objects.equals(this.keyChangeData, meter.keyChangeData);
   }

   @Override
   public int hashCode() {
      return Objects.hash(
            meterId,
            track2Data,
            serviceType,
            supplyGroupCode,
            keyRevisionNum,
            tariffIndex,
            tokenTechCode,
            algorithmCode,
            keyChangeData);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Meter {\n");

      sb.append("    meterId: ").append(Utils.toIndentedString(meterId)).append('\n');
      sb.append("    track2Data: ").append(Utils.toIndentedString(track2Data)).append('\n');
      sb.append("    serviceType: ").append(Utils.toIndentedString(serviceType)).append('\n');
      sb.append("    supplyGroupCode: ").append(Utils.toIndentedString(supplyGroupCode)).append('\n');
      sb.append("    keyRevisionNum: ").append(Utils.toIndentedString(keyRevisionNum)).append('\n');
      sb.append("    tariffIndex: ").append(Utils.toIndentedString(tariffIndex)).append('\n');
      sb.append("    tokenTechCode: ").append(Utils.toIndentedString(tokenTechCode)).append('\n');
      sb.append("    algorithmCode: ").append(Utils.toIndentedString(algorithmCode)).append('\n');
      sb.append("    keyChangeData: ").append(Utils.toIndentedString(keyChangeData)).append('\n');
      sb.append('}');
      return sb.toString();
   }
}
