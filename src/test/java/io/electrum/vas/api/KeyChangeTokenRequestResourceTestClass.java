package io.electrum.vas.api;

import io.electrum.prepaidutility.api.IKeyChangeTokenRequestsResource;
import io.electrum.prepaidutility.api.KeyChangeTokenRequestsResource;

import org.mockito.Mockito;

public class KeyChangeTokenRequestResourceTestClass extends KeyChangeTokenRequestsResource {
   // use a spied instance so that method calls can be interrogated by Mockito
   static IKeyChangeTokenRequestsResource interfaceImpl = Mockito.spy(new IKeyChangeTokenRequestResourceTestImpl());

   protected IKeyChangeTokenRequestsResource getResourceImplementation() {
      return interfaceImpl;
   }
}