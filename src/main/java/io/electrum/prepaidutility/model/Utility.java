package io.electrum.prepaidutility.model;

import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a utility with whom a meter is registered
 */
@ApiModel(description = "Represents a utility with whom a meter is registered")
@JsonInclude(Include.NON_NULL)
public class Utility {

   private String name = null;
   private String address = null;
   private String vatRegNum = null;
   private String clientId = null;
   private String message = null;

   public Utility name(String name) {
      this.name = name;
      return this;
   }

   /**
    * Name of the utility.
    * 
    * @return name
    **/
   @ApiModelProperty(value = "Name of the utility.")
   @Length(max = 40)
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Utility address(String address) {
      this.address = address;
      return this;
   }

   /**
    * Physical address of the utility.
    * 
    * @return address
    **/
   @ApiModelProperty(value = "Physical address of the utility.")
   @Length(max = 80)
   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public Utility vatRegNum(String vatRegNum) {
      this.vatRegNum = vatRegNum;
      return this;
   }

   /**
    * VAT registration number of the utility.
    * 
    * @return vatRegNum
    **/
   @ApiModelProperty(value = "VAT registration number of the utility.")
   @Length(max = 10)
   public String getVatRegNum() {
      return vatRegNum;
   }

   public void setVatRegNum(String vatRegNum) {
      this.vatRegNum = vatRegNum;
   }

   public Utility clientId(String clientId) {
      this.clientId = clientId;
      return this;
   }

   /**
    * Identifier assigned by the utility to the client connecting to the utility's token issuing service.
    * 
    * @return clientId
    **/
   @ApiModelProperty(value = "Identifier assigned by the utility to the client connecting to the utility's token issuing service.")
   @Length(max = 20)
   public String getClientId() {
      return clientId;
   }

   public void setClientId(String clientId) {
      this.clientId = clientId;
   }

   public Utility message(String message) {
      this.message = message;
      return this;
   }

   /**
    * Message send by the utility to be displayed on the customer receipt.
    * 
    * @return message
    **/
   @ApiModelProperty(value = "Message send by the utility to be displayed on the customer receipt.")
   @Length(max = 80)
   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Utility utility = (Utility) o;
      return Objects.equals(this.name, utility.name) && Objects.equals(this.address, utility.address)
            && Objects.equals(this.vatRegNum, utility.vatRegNum) && Objects.equals(this.clientId, utility.clientId)
            && Objects.equals(this.message, utility.message);
   }

   @Override
   public int hashCode() {
      return Objects.hash(name, address, vatRegNum, clientId, message);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Utility {\n");

      sb.append("    name: ").append(toIndentedString(name)).append("\n");
      sb.append("    address: ").append(toIndentedString(address)).append("\n");
      sb.append("    vatRegNum: ").append(toIndentedString(vatRegNum)).append("\n");
      sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
      sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
