package io.electrum.prepaidutility.api;

public class PrepaidUtilityApi {

   public static final String VERSION = "3";
   public static final String API_BASE_PATH = "/prepaidutility/v" + VERSION;

   public static class Headers {
      public static final String X_JWS_SIGNATURE = "x-jws-signature";
   }
}
