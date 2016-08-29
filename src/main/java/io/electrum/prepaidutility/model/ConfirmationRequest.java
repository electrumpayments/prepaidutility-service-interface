package io.electrum.prepaidutility.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.electrum.vas.model.Tender;
import io.swagger.annotations.ApiModelProperty;

/**
 * ConfirmationRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-26T07:31:58.129Z")
public class ConfirmationRequest {
   private List<Tender> tenders = new ArrayList<Tender>();

   public ConfirmationRequest tenders(List<Tender> tenders) {
      this.tenders = tenders;
      return this;
   }

   public ConfirmationRequest addTendersItem(Tender tendersItem) {
      this.tenders.add(tendersItem);
      return this;
   }

   /**
    * Details of method(s) of payment and amount(s) tendered
    * 
    * @return tenders
    **/
   @ApiModelProperty(required = true, value = "Details of method(s) of payment and amount(s) tendered")
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
      ConfirmationRequest confirmationRequest = (ConfirmationRequest) o;
      return Objects.equals(this.tenders, confirmationRequest.tenders);
   }

   @Override
   public int hashCode() {
      return Objects.hash(tenders);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ConfirmationRequest {\n");

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
