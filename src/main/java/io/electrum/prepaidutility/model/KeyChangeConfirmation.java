package io.electrum.prepaidutility.model;

import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicAdvice;
import io.swagger.annotations.ApiModel;

/**
 * Represents an advice message confirming successful change of a key
 * 
 * @since v3.12.0
 */
@ApiModel(description = "Represents an advice message confirming successful change of a key.")
public class KeyChangeConfirmation extends BasicAdvice {

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class KeyChangeConfirmation {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append('\n');
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append('\n');
      sb.append("    time: ").append(Utils.toIndentedString(time)).append('\n');
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append('\n');
      sb.append("    stan: ").append(Utils.toIndentedString(stan));
      sb.append("    rrn: ").append(Utils.toIndentedString(rrn));
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append('\n');
      sb.append("}");
      return sb.toString();
   }
}
