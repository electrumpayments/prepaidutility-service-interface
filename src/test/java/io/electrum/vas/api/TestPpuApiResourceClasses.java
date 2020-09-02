package io.electrum.vas.api;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestPpuApiResourceClasses {

   @Test(description = "Ensure that methods in the resource classes which define operations will ultimately call back to the original interface method.", dataProvider = "resourceInterfaceMethodsDataProvider")
   public void ensureResourceOperationMethodBackwardsCompatibility(
         Class<?> resourceClass,
         String operationMethodName,
         Class<?> interfaceClass,
         String interfaceMethodName)
         throws Exception {
      TestResourceClasses.ensureResourceOperationMethodBackwardsCompatibility(
            resourceClass,
            operationMethodName,
            interfaceClass,
            interfaceMethodName);
   }

   @DataProvider(name = "resourceInterfaceMethodsDataProvider")
   public Object[][] resourceInterfaceMethodsDataProvider() {
      return new Object[][] {
            //@formatter:off
            {EventsResourceTestClass.class, "notifyTokenPurchase", IEventsResourceTestImpl.class, "notifyTokenPurchase"},
            {FaultReportsResourceTestClass.class,"createFaultReport", IFaultReportsResourceTestImpl.class,"createFaultReport"},
            {KeyChangeTokenRequestResourceTestClass.class,"createKeyChangeTokenRequest", IKeyChangeTokenRequestResourceTestImpl.class,"createKeyChangeTokenRequest"},
            {MeterLookupsResourceTestClass.class,"createMeterLookup", IMeterLookupsResourceTestImpl.class,"createMeterLookup"},
            {TokenPurchasesResourceTestClass.class,"confirmTokenPurchase", ITokenPurchasesResourceTestImpl.class,"confirmTokenPurchase"},
            {TokenPurchasesResourceTestClass.class,"createTokenPurchaseRequest", ITokenPurchasesResourceTestImpl.class,"createTokenPurchaseRequest"},
            {TokenPurchasesResourceTestClass.class,"retryPurchaseRequest", ITokenPurchasesResourceTestImpl.class,"retryPurchaseRequest"},
            {TokenPurchasesResourceTestClass.class,"reverseTokenPurchase", ITokenPurchasesResourceTestImpl.class,"reverseTokenPurchase"},
            {TokenReprintsResourceTestClass.class,"requestTokenReprint", ITokenReprintsResourceTestImpl.class,"requestTokenReprint"},
            //@formatter:on
      };
   }
}
