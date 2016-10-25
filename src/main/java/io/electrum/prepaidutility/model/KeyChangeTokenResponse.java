package io.electrum.prepaidutility.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.electrum.vas.Utils;
import io.electrum.vas.model.SlipData;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a response to a key change token request
 *
 */
@ApiModel(description = "Represents a response to a key change token request")
@JsonInclude(Include.NON_NULL)
public class KeyChangeTokenResponse extends Transaction {

   private Meter meter = null;
   private List<Token> tokens = new ArrayList<Token>();
   private SlipData slipData = null;

   /**
    * Details of the meter.
    **/
   public KeyChangeTokenResponse meter(Meter meter) {
      this.meter = meter;
      return this;
   }

   @ApiModelProperty(required = true, value = "Details of the meter.")
   @NotNull
   public Meter getMeter() {
      return meter;
   }

   public void setMeter(Meter meter) {
      this.meter = meter;
   }

   /**
    * List of tokens issued for the key change.
    **/
   public KeyChangeTokenResponse tokens(List<Token> tokens) {
      this.tokens = tokens;
      return this;
   }

   public KeyChangeTokenResponse addTokensItem(Token tokensItem) {
      this.tokens.add(tokensItem);
      return this;
   }

   @ApiModelProperty(value = "List of tokens issued for the key change.")
   public List<Token> getTokens() {
      return tokens;
   }

   public void setTokens(List<Token> tokens) {
      this.tokens = tokens;
   }

   /**
    * A ready-to-print till slip. This is supplied by some providers either in addition to or in place of individual
    * message elements. Where present, it must be used by POS to print the slip.
    */
   public KeyChangeTokenResponse slipData(SlipData slipData) {
      this.slipData = slipData;
      return this;
   }

   @ApiModelProperty(value = "A ready-to-print till slip. This is supplied by some providers either in addition to or in place of individual message elements. Where present, it must be used by POS to print the slip.")
   public SlipData getSlipData() {
      return slipData;
   }

   public void setSlipData(SlipData slipData) {
      this.slipData = slipData;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PurchaseResponse {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    meter: ").append(Utils.toIndentedString(meter)).append("\n");
      sb.append("    tokens: ").append(Utils.toIndentedString(tokens)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
