package io.electrum.prepaidutility.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * Utility
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-26T07:31:58.129Z")
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
