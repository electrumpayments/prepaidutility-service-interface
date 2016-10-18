package io.electrum.prepaidutility.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents an additional data element defined by a pair of {@link String} variables denoting the name of the field and its value.
 */
@ApiModel(description = "Represents an additional data element defined by a pair of String variables denoting the name of the field and its value.")
@JsonInclude(Include.NON_NULL)
public class AdditionalDataElement {

   private String name = null;
   private String value = null;
   
   /**
    * Name of the additional data element.
    */
   public AdditionalDataElement name(String name) {
      this.name = name;
      return this;
   }
   
   @ApiModelProperty(required = true, value = "Name of the additional data element.")
   @NotNull
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   /**
    * Value of the additional data element.
    */
   public AdditionalDataElement value(String value) {
      this.value = value;
      return this;
   }
   
   @ApiModelProperty(required = true, value = "Value of the additional data element.")
   @NotNull
   public String getValue() {
      return value;
   }
   
   public void setValue(String value) {
      this.value = value;
   }
}
