package io.electrum.prepaidutility.model;

import io.electrum.vas.model.BasicReversal;
import io.swagger.annotations.ApiModel;

/**
 * Represents a request to reverse a previous key change request.
 */
@ApiModel(description = "Represents a request to reverse a previous key change request.")
public class KeyChangeReversal extends BasicReversal {
   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("KeyChangeReversal{");
      sb.append("reversalReason=").append(reversalReason);
      sb.append(", id='").append(id).append('\'');
      sb.append(", requestId='").append(requestId).append('\'');
      sb.append(", time=").append(time);
      sb.append(", thirdPartyIdentifiers=").append(thirdPartyIdentifiers);
      sb.append('}');
      return sb.toString();
   }
}
