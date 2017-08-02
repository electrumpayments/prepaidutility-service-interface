package io.electrum.prepaidutility.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Customer;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data required to report a fault related to a specific meter
 *
 */
@ApiModel(description = "Data required to report a fault related to a specific meter")
public class FaultReportRequest extends Transaction {
   /**
    * Type of fault that is being reported. Allowed values are set according to Eskom specification.
    */
   public enum FaultType {
      SERIOUS_BOX_DAMAGE("SeriousBoxDamage"),
      FIRE_WATER_DAMAGE("FireWaterDamage"),
      METER_DEAD("MeterDead"),
      KEEPS_TRIPPING("KeepsTripping"),
      NO_TRIP("NoTrip"),
      DISPLAY_LIGHTS_BUTTONS("DisplayLightsButtons"),
      NETWORK_FAULT_REPORT("NetworkFaultReport"),
      INCORRECT_SGC("IncorrectSGC"),
      INCORRECT_TI("IncorrectTI"),
      CONVERTED_FRM_CONVENTIONAL("ConvertedFrmConventional"),
      METER_CHANGED_OUT("MeterChangedOut"),
      NEW_INSTALLATION("NewInstallation");

      private String value;

      FaultType(String value) {
         this.value = value;
      }

      @Override
      public String toString() {
         return String.valueOf(value);
      }
   }

   private Meter meter = null;
   private Customer customer = null;
   private String contactNumber = null;
   private FaultType faultType = null;

   public FaultReportRequest meter(Meter meter) {
      this.meter = meter;
      return this;
   }

   /**
    * Details of the meter for which fault is logged. The object must include at least a value for meterId.
    * 
    * @return meter
    **/
   @ApiModelProperty(required = true, value = "Details of the meter for which fault is logged. The object must include at least a value for meterId.")
   @NotNull
   public Meter getMeter() {
      return meter;
   }

   public void setMeter(Meter meter) {
      this.meter = meter;
   }

   public Customer customer(Customer customer) {
      this.customer = customer;
      return customer;
   }

   /**
    * Details of the person or organization to whom the meter belongs.
    * 
    * @return customer
    **/
   @ApiModelProperty(value = "Details of the person or organization to whom the meter belongs.")
   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   public String contactNumber(String contactNumber) {
      this.contactNumber = contactNumber;
      return contactNumber;
   }

   /**
    * Contact telephone number of the person reporting the fault
    * 
    * @return contactNumber
    */
   @ApiModelProperty(required = true, value = "Contact telephone number of the person reporting the fault")
   @NotNull
   @Length(max = 20)
   public String getContactNumber() {
      return contactNumber;
   }

   public void setContactNumber(String contactNumber) {
      this.contactNumber = contactNumber;
   }

   public FaultType faultType(FaultType faultType) {
      this.faultType = faultType;
      return faultType;
   }

   /**
    * Type of fault that is being reported
    * 
    * @return faultType
    */
   @ApiModelProperty(required = true, value = "Type of fault that is being reported")
   @NotNull
   public FaultType getFaultType() {
      return faultType;
   }

   public void setFaultType(FaultType faultType) {
      this.faultType = faultType;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class FaultReportRequest {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    meter: ").append(Utils.toIndentedString(meter)).append("\n");
      sb.append("    customer: ").append(Utils.toIndentedString(customer)).append("\n");
      sb.append("    contactNumber: ").append(Utils.toIndentedString(contactNumber)).append("\n");
      sb.append("    faultType: ").append(Utils.toIndentedString(faultType)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
