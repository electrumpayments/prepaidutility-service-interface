package io.electrum.prepaidutility.model;

import io.electrum.vas.model.BasicAdvice;
import io.swagger.annotations.ApiModel;

/**
 * Represents an advice message confirming successful change of a key
 */
@ApiModel(description = "Represents an advice message confirming successful change of a key.")
public class KeyChangeConfirmation extends BasicAdvice {

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("KeyChangeConfirmation{");
      sb.append("id='").append(id).append('\'');
      sb.append(", requestId='").append(requestId).append('\'');
      sb.append(", time=").append(time);
      sb.append(", thirdPartyIdentifiers=").append(thirdPartyIdentifiers);
      sb.append('}');
      return sb.toString();
   }
}
