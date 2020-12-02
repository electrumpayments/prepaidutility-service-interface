package io.electrum.prepaidutility;

import io.electrum.prepaidutility.model.ErrorDetail;
import io.electrum.prepaidutility.model.Token;
import io.electrum.vas.JsonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ModelTest {

   @Test
   public void testTokenTypeEnumOrdinals() {
      // Setup expectations
      int std_ordinal = 0;
      int bsst_ordinal = 1;
      int refund_ordinal = 2;
      int kc_ordinal = 3;
      int pwrlmt_ordinal = 4;

      Assert.assertEquals(Token.TokenTypeEnum.values().length, 5);
      Assert.assertEquals(Token.TokenTypeEnum.STD.ordinal(), std_ordinal);
      Assert.assertEquals(Token.TokenTypeEnum.BSST.ordinal(), bsst_ordinal);
      Assert.assertEquals(Token.TokenTypeEnum.REFUND.ordinal(), refund_ordinal);
      Assert.assertEquals(Token.TokenTypeEnum.KC.ordinal(), kc_ordinal);
      Assert.assertEquals(Token.TokenTypeEnum.PWRLMT.ordinal(), pwrlmt_ordinal);
   }

   @Test(description = "Test we can deserialise what we serialised and get back to where we started.", dataProvider = "serialiseDeserialiseObjectDataProvider")
   public void testSerialiseDeserialiseObject(Object testObject) throws IOException {
      Assert.assertEquals(JsonUtil.deserialize(JsonUtil.serialize(testObject), testObject.getClass()), testObject);
   }

   @DataProvider(name = "serialiseDeserialiseObjectDataProvider")
   public Iterator<Object[]> serialiseDeserialiseObjectDataProvider() {
      List<Object> objectsToCheck = new ArrayList<>();

      // Add ErrorDetails
      Arrays.stream(ErrorDetail.RequestType.values()).forEach(r -> {
         Arrays.stream(ErrorDetail.ErrorType.values()).forEach(e -> {
            objectsToCheck.add(new ErrorDetail().requestType(r).errorType(e).id(UUID.randomUUID().toString()));
         });
      });

      return objectsToCheck.stream().map(o -> new Object[] { o }).iterator();
   }

   @Test
   public void testErrorDetail_ErrorTypeEnumOrdinals() {
      Assert.assertEquals(ErrorDetail.ErrorType.values().length, 26);
      Assert.assertEquals(ErrorDetail.ErrorType.DUPLICATE_RECORD.ordinal(), 0);
      Assert.assertEquals(ErrorDetail.ErrorType.FORMAT_ERROR.ordinal(), 1);
      Assert.assertEquals(ErrorDetail.ErrorType.FUNCTION_NOT_SUPPORTED.ordinal(), 2);
      Assert.assertEquals(ErrorDetail.ErrorType.GENERAL_ERROR.ordinal(), 3);
      Assert.assertEquals(ErrorDetail.ErrorType.INVALID_AMOUNT.ordinal(), 4);
      Assert.assertEquals(ErrorDetail.ErrorType.ROUTING_ERROR.ordinal(), 5);
      Assert.assertEquals(ErrorDetail.ErrorType.TRANSACTION_NOT_SUPPORTED.ordinal(), 6);
      Assert.assertEquals(ErrorDetail.ErrorType.UNABLE_TO_LOCATE_RECORD.ordinal(), 7);
      Assert.assertEquals(ErrorDetail.ErrorType.UPSTREAM_UNAVAILABLE.ordinal(), 8);
      Assert.assertEquals(ErrorDetail.ErrorType.UNKNOWN_METER_ID.ordinal(), 9);
      Assert.assertEquals(ErrorDetail.ErrorType.TRANSACTION_DECLINED.ordinal(), 10);
      Assert.assertEquals(ErrorDetail.ErrorType.INVALID_MERCHANT.ordinal(), 11);
      Assert.assertEquals(ErrorDetail.ErrorType.INVALID_AN32_TOKEN.ordinal(), 12);
      Assert.assertEquals(ErrorDetail.ErrorType.DO_NOT_HONOR.ordinal(), 13);
      Assert.assertEquals(ErrorDetail.ErrorType.INVALID_MSISDN.ordinal(), 14);
      Assert.assertEquals(ErrorDetail.ErrorType.INVALID_LOYALTY_CARD.ordinal(), 15);
      Assert.assertEquals(ErrorDetail.ErrorType.UTILITY_INVALID.ordinal(), 16);
      Assert.assertEquals(ErrorDetail.ErrorType.SYSTEM_MALFUNCTION.ordinal(), 17);
      Assert.assertEquals(ErrorDetail.ErrorType.METER_KEY_INVALID.ordinal(), 18);
      Assert.assertEquals(ErrorDetail.ErrorType.AMOUNT_TOO_LOW.ordinal(), 19);
      Assert.assertEquals(ErrorDetail.ErrorType.AMOUNT_TOO_HIGH.ordinal(), 20);
      Assert.assertEquals(ErrorDetail.ErrorType.NO_FREE_UNITS_DUE.ordinal(), 21);
      Assert.assertEquals(ErrorDetail.ErrorType.INSUFFICIENT_FUNDS.ordinal(), 22);
      Assert.assertEquals(ErrorDetail.ErrorType.LIMIT_EXCEEDED.ordinal(), 23);
      Assert.assertEquals(ErrorDetail.ErrorType.METER_ID_BLOCKED.ordinal(), 24);
      Assert.assertEquals(ErrorDetail.ErrorType.OUTCOME_UNKNOWN.ordinal(), 25);
   }

   @Test
   public void testErrorDetail_RequestTypeEnumOrdinals() {
      Assert.assertEquals(ErrorDetail.RequestType.values().length, 10);
      Assert.assertEquals(ErrorDetail.RequestType.METER_LOOKUP_REQUEST.ordinal(), 0);
      Assert.assertEquals(ErrorDetail.RequestType.TOKEN_PURCHASE_REQUEST.ordinal(), 1);
      Assert.assertEquals(ErrorDetail.RequestType.TOKEN_PURCHASE_RETRY_REQUEST.ordinal(), 2);
      Assert.assertEquals(ErrorDetail.RequestType.TOKEN_REPRINT_REQUEST.ordinal(), 3);
      Assert.assertEquals(ErrorDetail.RequestType.FAULT_REPORT_REQUEST.ordinal(), 4);
      Assert.assertEquals(ErrorDetail.RequestType.KEY_CHANGE_TOKEN_REQUEST.ordinal(), 5);
      Assert.assertEquals(ErrorDetail.RequestType.CONFIRMATION_ADVICE.ordinal(), 6);
      Assert.assertEquals(ErrorDetail.RequestType.REVERSAL_ADVICE.ordinal(), 7);
      Assert.assertEquals(ErrorDetail.RequestType.NOTIFY_TOKEN_PURCHASE.ordinal(), 8);
      Assert.assertEquals(ErrorDetail.RequestType.TOKEN_PURCHASE_TRIAL_REQUEST.ordinal(), 9);
   }
}
