package io.electrum.prepaidutility.model;

import java.util.UUID;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.electrum.vas.Utils;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a token purchase request
 */
@ApiModel(description = "Represents a token purchase request")
@JsonInclude(Include.NON_NULL)
public class PurchaseRequest extends Transaction {

   private Meter meter = null;
   private LedgerAmount purchaseAmount = null;
   private String utilityType = null;
   private Integer slipWidth = null;
   private boolean retry = false;
   private UUID originalId = null;
   private DateTime originalTime = null;

   public PurchaseRequest meterId(Meter meter) {
      this.meter = meter;
      return this;
   }

   /**
    * Details of the meter for which a purchase is requested. The object must include at least a value for meterId.
    * 
    * @return meter
    **/
   @ApiModelProperty(required = true, value = "Details of the meter for which a purchase is requested. The object must include at least a value for meterId.")
   @NotNull
   @Pattern(regexp = "[a-zA-Z0-9]{0,20}")
   public Meter getMeter() {
      return meter;
   }

   public void setMeter(Meter meter) {
      this.meter = meter;
   }

   public PurchaseRequest purchaseAmount(LedgerAmount purchaseAmount) {
      this.purchaseAmount = purchaseAmount;
      return this;
   }

   /**
    * Monetary amount, in minor denomination, of the requested token purchase.
    * 
    * @return purchaseAmount
    **/
   @ApiModelProperty(required = true, value = "Monetary amount, in minor denomination, of the requested token purchase.")
   @NotNull
   public LedgerAmount getPurchaseAmount() {
      return purchaseAmount;
   }

   public void setPurchaseAmount(LedgerAmount purchaseAmount) {
      this.purchaseAmount = purchaseAmount;
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

   public PurchaseRequest slipWidth(Integer slipWidth) {
      this.slipWidth = slipWidth;
      return this;
   }

   /**
    * Width of the slip on which POS prints the transaction receipt.
    * 
    * @return slipWidth
    */
   @ApiModelProperty(value = "Width of the slip on which POS prints the transaction receipt.")
   @Min(21)
   @Max(80)
   public Integer getSlipWidth() {
      return slipWidth;
   }

   public void setSlipWidth(Integer slipWidth) {
      this.slipWidth = slipWidth;
   }

   public PurchaseRequest retry(boolean retry) {
      this.retry = retry;
      return this;
   }

   /**
    * Boolean indicating if this request represents a retry of a previous transaction.
    * 
    * @return isRetry
    */
   @ApiModelProperty(value = "Boolean indicating if this request represents a retry of a previous transaction.")
   public boolean isRetry() {
      return retry;
   }

   public void setRetry(boolean retry) {
      this.retry = retry;
   }

   public PurchaseRequest originalId(UUID originalId) {
      this.originalId = originalId;
      return this;
   }

   /**
    * UUID of the original request. Only used if this request is a retry of a previous transaction.
    * 
    * @return originalId
    */
   @ApiModelProperty(value = "UUID of the original request. Only used if this request is a retry of a previous transaction.")
   public UUID getOriginalId() {
      return originalId;
   }

   public void setOriginalId(UUID originalId) {
      this.originalId = originalId;
   }

   public PurchaseRequest originalTime(DateTime originalTime) {
      this.originalTime = originalTime;
      return this;
   }

   /**
    * Time of the original request. Only used if this request is a retry of a previous transaction.
    * 
    * @return
    */
   @ApiModelProperty(value = "Time of the original request. Only used if this request is a retry of a previous transaction.")
   public DateTime getOriginalTime() {
      return originalTime;
   }

   public void setOriginalTime(DateTime originalTime) {
      this.originalTime = originalTime;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PurchaseRequest {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    meterId: ").append(Utils.toIndentedString(meter)).append("\n");
      sb.append("    purchaseAmount: ").append(Utils.toIndentedString(purchaseAmount)).append("\n");
      sb.append("    utilityType: ").append(Utils.toIndentedString(utilityType)).append("\n");
      sb.append("    slipWidth: ").append(Utils.toIndentedString(slipWidth)).append("\n");
      sb.append("    retry: ").append(Utils.toIndentedString(retry)).append("\n");
      sb.append("    originalId: ").append(Utils.toIndentedString(originalId)).append("\n");
      sb.append("    originalTime: ").append(Utils.toIndentedString(originalTime)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
