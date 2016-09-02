package io.electrum.prepaidutility.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Contains all data required to print a till slip.
 * 
 * Each line to be printed is represented by a {@link PrintableLine} object containing text as it should appear on the
 * slip. Lines must be printed in the order of increasing index in the collection.
 *
 */
@ApiModel(description = "Contains all data required to print a till slip. Each line to be printed is represented by a {@link PrintableLine} object containing text as it should appear on the slip. Lines must be printed in the order of increasing index in the collection.")
public class PrintableSlip {

   private List<PrintableLine> lines = new ArrayList<PrintableLine>();

   public PrintableSlip lines(List<PrintableLine> lines) {
      this.lines = lines;
      return this;
   }

   public PrintableSlip addLineItem(PrintableLine lineItem) {
      this.lines.add(lineItem);
      return this;
   }

   /**
    * A line of text to print on the slip. Also specifies certain text formatting options.
    * 
    * @return lines
    */
   @ApiModelProperty(required = true, value = "A line of text to print on the slip. Also specifies certain text formatting options.")
   @NotNull
   public List<PrintableLine> getLines() {
      return lines;
   }

   public void setLines(List<PrintableLine> lines) {
      this.lines = lines;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      PrintableSlip printableSlip = (PrintableSlip) o;
      return Objects.equals(this.lines, printableSlip.lines);
   }

   @Override
   public int hashCode() {
      return Objects.hash(lines);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PrintableSlip {\n");

      sb.append("    lines: ").append(Utils.toIndentedString(lines)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
