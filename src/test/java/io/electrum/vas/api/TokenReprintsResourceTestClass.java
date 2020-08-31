package io.electrum.vas.api;

import io.electrum.prepaidutility.api.ITokenReprintsResource;
import io.electrum.prepaidutility.api.TokenReprintsResource;

import org.mockito.Mockito;

public class TokenReprintsResourceTestClass extends TokenReprintsResource {
   // use a spied instance so that method calls can be interrogated by Mockito
   static ITokenReprintsResource interfaceImpl = Mockito.spy(new ITokenReprintsResourceTestImpl());

   protected ITokenReprintsResource getResourceImplementation() {
      return interfaceImpl;
   }
}