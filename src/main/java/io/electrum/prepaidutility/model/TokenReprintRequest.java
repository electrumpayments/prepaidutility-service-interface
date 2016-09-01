package io.electrum.prepaidutility.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a request for a token reprint
 */
@ApiModel(description = "Represents a request for a token reprint")
@JsonInclude(Include.NON_NULL)
public class TokenReprintRequest extends Transaction {

   private String meterId = null;
   private String track2Data = null;
   private String originalRef = null;

   public TokenReprintRequest meterId(String meterId) {
      this.meterId = meterId;
      return this;
   }

   /**
    * Unique identifier (e.g. serial number) of the meter for which token reprint is requested.
    * 
    * @return meterId
    **/
   @ApiModelProperty(required = true, value = "Unique identifier (e.g. serial number) of the meter for which token reprint is requested.")
   @NotNull
   public String getMeterId() {
      return meterId;
   }

   public void setMeterId(String meterId) {
      this.meterId = meterId;
   }

   public TokenReprintRequest track2Data(String track2Data) {
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

   public TokenReprintRequest originalRef(String originalRef) {
      this.originalRef = originalRef;
      return this;
   }

   /**
    * Reference or receipt number for the original token in the case that a specific token is requested. If this field
    * is not present, then the last-issued token will be requested from the provider.
    * 
    * @return originalRef
    **/
   @ApiModelProperty(value = "Reference or receipt number for the original token in the case that a specific token is requested. If this field is not present, then the last-issued token will be requested from the provider.")
   public String getOriginalRef() {
      return originalRef;
   }

   public void setOriginalRef(String originalRef) {
      this.originalRef = originalRef;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      TokenReprintRequest tokenReprintRequest = (TokenReprintRequest) o;
      return Objects.equals(this.meterId, tokenReprintRequest.meterId)
            && Objects.equals(this.track2Data, tokenReprintRequest.track2Data)
            && Objects.equals(this.originalRef, tokenReprintRequest.originalRef);
   }

   @Override
   public int hashCode() {
      return Objects.hash(meterId, track2Data, originalRef);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class TokenReprintRequest {\n");

      sb.append("    meterId: ").append(toIndentedString(meterId)).append("\n");
      sb.append("    track2Data: ").append(toIndentedString(track2Data)).append("\n");
      sb.append("    originalRef: ").append(toIndentedString(originalRef)).append("\n");
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
