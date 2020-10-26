package io.electrum.prepaidutility.model;

import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicReversal;
import io.swagger.annotations.ApiModel;

/**
 * Represents a request to reverse a previous key change request.
 * 
 * @since v3.12.0
 */
@ApiModel(description = "Represents a request to reverse a previous key change request.")
public class KeyChangeReversal extends BasicReversal {
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class KeyChangeReversal {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append('\n');
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append('\n');
      sb.append("    time: ").append(Utils.toIndentedString(time)).append('\n');
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append('\n');
      sb.append("    reversalReason=").append(Utils.toIndentedString(reversalReason)).append('\n');
      sb.append("    stan=").append(Utils.toIndentedString(stan)).append('\n');
      sb.append("    rrn=").append(Utils.toIndentedString(rrn)).append('\n');
      sb.append("    amounts=").append(Utils.toIndentedString(amounts)).append('\n');
      sb.append("}");
      return sb.toString();
   }

}
