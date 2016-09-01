package io.electrum.prepaidutility.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.electrum.vas.model.Tender;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a token purchase request
 */
@ApiModel(description = "Represents a token purchase request")
@JsonInclude(Include.NON_NULL)
public class PurchaseRequest extends Transaction {

   private String meterId = null;
   private Amount purchaseAmount = null;
   private String track2Data = null;
   private String utilityType = null;
   private List<Tender> tenders = new ArrayList<Tender>();

   public PurchaseRequest meterId(String meterId) {
      this.meterId = meterId;
      return this;
   }

   /**
    * Unique identifier (e.g. serial number) of the meter against which token purchase is requested.
    * 
    * @return meterId
    **/
   @ApiModelProperty(required = true, value = "Unique identifier (e.g. serial number) of the meter against which token purchase is requested.")
   @Pattern(regexp = "[a-zA-Z0-9]{0,20}")
   public String getMeterId() {
      return meterId;
   }

   public void setMeterId(String meterId) {
      this.meterId = meterId;
   }

   public PurchaseRequest purchaseAmount(Amount purchaseAmount) {
      this.purchaseAmount = purchaseAmount;
      return this;
   }

   /**
    * Monetary amount, in minor denomination, of the requested token purchase.
    * 
    * @return purchaseAmount
    **/
   @ApiModelProperty(required = true, value = "Monetary amount, in minor denomination, of the requested token purchase.")
   public Amount getPurchaseAmount() {
      return purchaseAmount;
   }

   public void setPurchaseAmount(Amount purchaseAmount) {
      this.purchaseAmount = purchaseAmount;
   }

   public PurchaseRequest track2Data(String track2Data) {
      this.track2Data = track2Data;
      return this;
   }

   /**
    * Track 2 data stored on the magnetic stripe of a card that is supplied with certain meters. This data contains all
    * meter details. It can be used as an alternative means of input at PoS and may be required by some provders.
    * 
    * @return track2Data
    **/
   @ApiModelProperty(value = "Track 2 data stored on the magnetic stripe of a card that is supplied with certain meters. This data contains all meter details. It can be used as an alternative means of input at PoS and may be required by some provders.")
   public String getTrack2Data() {
      return track2Data;
   }

   public void setTrack2Data(String track2Data) {
      this.track2Data = track2Data;
   }

   public PurchaseRequest utilityType(String utilityType) {
      this.utilityType = utilityType;
      return this;
   }

   /**
    * Type of utility purchase being requested (e.g. electricity, water, gas).
    * 
    * @return utilityType
    **/
   @ApiModelProperty(value = "Type of utility purchase being requested (e.g. electricity, water, gas).")
   public String getUtilityType() {
      return utilityType;
   }

   public void setUtilityType(String utilityType) {
      this.utilityType = utilityType;
   }

   public PurchaseRequest tenders(List<Tender> tenders) {
      this.tenders = tenders;
      return this;
   }

   public PurchaseRequest addTendersItem(Tender tendersItem) {
      this.tenders.add(tendersItem);
      return this;
   }

   /**
    * Details of method(s) of payment and amount(s) tendered. Only present if the PoS implementation is for
    * single-message pair transactions (i.e. no confirmation request is sent).
    * 
    * @return tenders
    **/
   @ApiModelProperty(value = "Details of method(s) of payment and amount(s) tendered. Only present if the PoS implementation is for single-message pair transactions (i.e. no confirmation request is sent).")
   public List<Tender> getTenders() {
      return tenders;
   }

   public void setTenders(List<Tender> tenders) {
      this.tenders = tenders;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      PurchaseRequest purchaseRequest = (PurchaseRequest) o;
      return Objects.equals(this.meterId, purchaseRequest.meterId)
            && Objects.equals(this.purchaseAmount, purchaseRequest.purchaseAmount)
            && Objects.equals(this.track2Data, purchaseRequest.track2Data)
            && Objects.equals(this.utilityType, purchaseRequest.utilityType)
            && Objects.equals(this.tenders, purchaseRequest.tenders);
   }

   @Override
   public int hashCode() {
      return Objects.hash(meterId, purchaseAmount, track2Data, utilityType, tenders);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PurchaseRequest {\n");

      sb.append("    meterId: ").append(toIndentedString(meterId)).append("\n");
      sb.append("    purchaseAmount: ").append(toIndentedString(purchaseAmount)).append("\n");
      sb.append("    track2Data: ").append(toIndentedString(track2Data)).append("\n");
      sb.append("    utilityType: ").append(toIndentedString(utilityType)).append("\n");
      sb.append("    tenders: ").append(toIndentedString(tenders)).append("\n");
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
