---
title: "Getting Started"
menu:
  main:
    weight: 0
---

## Document overview

The Prepaid Utility Interface is intended to facilitate transactions between retailers on the one side and providers of prepaid services for utilities (such as electricity, water and gas) on the other. The service takes the form of an HTTP-based RESTful interface and is released under the Apache 2.0 license.

This service is aimed at two groups of users: a) a retailer wishing to develop a point-of-sale client application to access the Electrum Prepaid Utility Service, or b) a prepaid utility service provider or aggregator wishing to develop a server application to integrate directly with the Electrum service. If you fall into one of these categories, then this is the solution for you!

Basics of the connection protocol are described in [Protocol Basics](/protocol-basics); some specifics related to the transaction messaging are presented in [Advanced Topics](/advanced-topics); details of the business process behind prepaid utility transactions can be found under [Transaction Flows](/transaction-flows); jargon is demystified in the [Terminology](/terminology) section.

The full interface specification is found [here](/specification/introduction), including definitions of all resources, operations and data types.

## Supported languages

### Java
The Electrum implementation of the API is written in Java. If are planning a Java implementation, then simply include the [Prepaid Utility Interface](https://github.com/electrumpayments/prepaidutility-service-interface) Maven dependency to your project. Further instructions can be found in the project [README](https://github.com/electrumpayments/prepaidutility-service-interface).

### Other languages
Should you wish your implementation to be in a language other than Java, the interface is described as a [Swagger (OpenApi) document](/specification/swagger). This can be used in conjunction with the widely available [Swagger](http://swagger.io/) tooling to generate a project in your preferred language.  
