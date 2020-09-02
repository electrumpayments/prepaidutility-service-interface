package io.electrum.vas.api;

import io.electrum.prepaidutility.api.ITokenPurchasesResource;
import io.electrum.prepaidutility.api.TokenPurchasesResource;

import org.mockito.Mockito;

public class TokenPurchasesResourceTestClass extends TokenPurchasesResource {
   // use a spied instance so that method calls can be interrogated by Mockito
   static ITokenPurchasesResource interfaceImpl = Mockito.spy(new ITokenPurchasesResourceTestImpl());

   protected ITokenPurchasesResource getResourceImplementation() {
      return interfaceImpl;
   }
}