package io.electrum.prepaidutility.model;

import io.electrum.vas.Utils;
import io.electrum.vas.model.TenderAdvice;
import io.swagger.annotations.ApiModel;

/**
 * Represents an advice message confirming successful completion of a transaction.
 */
@ApiModel(description = "Represents an advice message confirming successful completion of a transaction.")
public class ConfirmationAdvice extends TenderAdvice {

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ConfirmationAdvice {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    tenders: ").append(Utils.toIndentedString(tenders)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
