package io.electrum.vas.api;

import io.electrum.prepaidutility.api.FaultReportsResource;
import io.electrum.prepaidutility.api.IFaultReportsResource;

import org.mockito.Mockito;

public class FaultReportsResourceTestClass extends FaultReportsResource {
   // use a spied instance so that method calls can be interrogated by Mockito
   static IFaultReportsResource interfaceImpl = Mockito.spy(new IFaultReportsResourceTestImpl());

   protected IFaultReportsResource getResourceImplementation() {
      return interfaceImpl;
   }
}