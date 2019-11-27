package io.electrum.prepaidutility;

import io.electrum.prepaidutility.model.Token;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ModelTests {

   @Test
   public void testTokenTypeEnumOrdinals() {
      // Setup expectations
      int std_ordinal = 0;
      int bsst_ordinal = 1;
      int refund_ordinal = 2;
      int kc_ordinal = 3;
      int pwrlmt_ordinal = 4;

      Assert.assertEquals(Token.TokenTypeEnum.STD.ordinal(), std_ordinal);
      Assert.assertEquals(Token.TokenTypeEnum.BSST.ordinal(), bsst_ordinal);
      Assert.assertEquals(Token.TokenTypeEnum.REFUND.ordinal(), refund_ordinal);
      Assert.assertEquals(Token.TokenTypeEnum.KC.ordinal(), kc_ordinal);
      Assert.assertEquals(Token.TokenTypeEnum.PWRLMT.ordinal(), pwrlmt_ordinal);
   }
}
