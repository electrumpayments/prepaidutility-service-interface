package io.electrum.prepaidutility.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * MeterLookupRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-26T07:31:58.129Z")
public class MeterLookupRequest {
   private String meterId = null;

   public MeterLookupRequest meterId(String meterId) {
      this.meterId = meterId;
      return this;
   }

   /**
    * Unique identifier (e.g. serial number) of the meter for which information is requested.
    * 
    * @return meterId
    **/
   @ApiModelProperty(required = true, value = "Unique identifier (e.g. serial number) of the meter for which information is requested.")
   public String getMeterId() {
      return meterId;
   }

   public void setMeterId(String meterId) {
      this.meterId = meterId;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      MeterLookupRequest meterLookupRequest = (MeterLookupRequest) o;
      return Objects.equals(this.meterId, meterLookupRequest.meterId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(meterId);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MeterLookupRequest {\n");

      sb.append("    meterId: ").append(toIndentedString(meterId)).append("\n");
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
