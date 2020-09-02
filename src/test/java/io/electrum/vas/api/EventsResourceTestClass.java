package io.electrum.vas.api;

import io.electrum.prepaidutility.api.EventsResource;
import io.electrum.prepaidutility.api.IEventsResource;
import org.mockito.Mockito;

public class EventsResourceTestClass extends EventsResource {
   // use a spied instance so that method calls can be interrogated by Mockito
   static IEventsResource interfaceImpl = Mockito.spy(new IEventsResourceTestImpl());

   protected IEventsResource getResourceImplementation() {
      return interfaceImpl;
   }
}