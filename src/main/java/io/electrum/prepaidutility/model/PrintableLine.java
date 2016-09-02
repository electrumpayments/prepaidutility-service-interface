package io.electrum.prepaidutility.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A line of text to be printed on the till slip
 *
 */
@ApiModel(description = "A line of text to be printed on the till slip")
public class PrintableLine {

   private String text;
   private int fontWidthScaleFactor = 1;
   private int fontHeightScaleFactor = 1;

   public PrintableLine text(String text) {
      this.text = text;
      return this;
   }

   /**
    * Text contained on the line
    * 
    * @return text
    */
   @ApiModelProperty(required = true, value = "Text contained on the line")
   @NotNull
   public String getText() {
      return text;
   }

   public void setText(String text) {
      this.text = text;
   }

   public PrintableLine fontWidthScaleFactor(int fontWidthScaleFactor) {
      this.fontWidthScaleFactor = fontWidthScaleFactor;
      return this;
   }

   /**
    * Scale factor for font width
    * 
    * @return fontWidthScaleFactor
    */
   @ApiModelProperty(value = "Scale factor for font width")
   public int getFontWidthScaleFactor() {
      return fontWidthScaleFactor;
   }

   public void setFontWidthScaleFactor(int fontWidthScaleFactor) {
      this.fontWidthScaleFactor = fontWidthScaleFactor;
   }

   public PrintableLine fontHeightScaleFactor(int fontHeightScaleFactor) {
      this.fontHeightScaleFactor = fontHeightScaleFactor;
      return this;
   }

   /**
    * Scale factor for font height
    * 
    * @return fontHeightScaleFactor
    */
   @ApiModelProperty(value = "Scale factor for font height")
   public int getFontHeightScaleFactor() {
      return fontHeightScaleFactor;
   }

   public void setFontHeightScaleFactor(int fontHeightScaleFactor) {
      this.fontHeightScaleFactor = fontHeightScaleFactor;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      PrintableLine printableLine = (PrintableLine) o;
      return Objects.equals(this.text, printableLine.text)
            && Objects.equals(this.fontWidthScaleFactor, printableLine.fontWidthScaleFactor)
            && Objects.equals(this.fontHeightScaleFactor, printableLine.fontHeightScaleFactor);
   }

   @Override
   public int hashCode() {
      return Objects.hash(text, fontWidthScaleFactor, fontHeightScaleFactor);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PrintableLine {\n");

      sb.append("    text: ").append(Utils.toIndentedString(text)).append("\n");
      sb.append("    fontWidthScaleFactor: ").append(Utils.toIndentedString(fontWidthScaleFactor)).append("\n");
      sb.append("    fontHeightScaleFactor: ").append(Utils.toIndentedString(fontHeightScaleFactor)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
