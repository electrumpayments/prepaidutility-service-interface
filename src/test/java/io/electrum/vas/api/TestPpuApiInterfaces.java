package io.electrum.vas.api;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestPpuApiInterfaces {

   @Test(description = "Ensures that, when overloaded interface methods are called, each overloaded method calls back to the original method.", dataProvider = "existingBaseImplementationMethodsDatProvider")
   public void ensureInterfaceMethodBackwardsCompatibility(Class<?> interfaceImpl, String methodName) throws Exception {
      TestResourceInterfaces.ensureInterfaceMethodBackwardsCompatibility(interfaceImpl, methodName);
   }

   @DataProvider(name = "existingBaseImplementationMethodsDatProvider")
   public Object[][] existingBaseImplementationMethodsDatProvider() {
      return new Object[][] {
            // the following methods all have implementations which must be used by default when overloading these
            // methods
            //@formatter:off
           {IEventsResourceTestImpl.class,"notifyTokenPurchase"},
           {IFaultReportsResourceTestImpl.class,"createFaultReport"},
           {IKeyChangeTokenRequestResourceTestImpl.class,"createKeyChangeTokenRequest"},
           {IKeyChangeTokenRequestResourceTestImpl.class,"createKeyChangeConfirmationRequest"},
           {IKeyChangeTokenRequestResourceTestImpl.class,"createKeyChangeReversalRequest"},
           {IMeterLookupsResourceTestImpl.class,"createMeterLookup"},
           {ITokenPurchasesResourceTestImpl.class,"confirmTokenPurchase"},
           {ITokenPurchasesResourceTestImpl.class,"createTokenPurchaseRequest"},
           {ITokenPurchasesResourceTestImpl.class,"retryPurchaseRequest"},
           {ITokenPurchasesResourceTestImpl.class,"reverseTokenPurchase"},
           {ITokenReprintsResourceTestImpl.class,"requestTokenReprint"},
           //@formatter:on
      };
   }
}