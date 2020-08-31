package io.electrum.vas.api;

import io.electrum.prepaidutility.api.IMeterLookupsResource;
import io.electrum.prepaidutility.api.MeterLookupsResource;

import org.mockito.Mockito;

public class MeterLookupsResourceTestClass extends MeterLookupsResource {
   // use a spied instance so that method calls can be interrogated by Mockito
   static IMeterLookupsResource interfaceImpl = Mockito.spy(new IMeterLookupsResourceTestImpl());

   protected IMeterLookupsResource getResourceImplementation() {
      return interfaceImpl;
   }
}