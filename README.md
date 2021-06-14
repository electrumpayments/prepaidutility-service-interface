# Prepaid Utility Service Interface  

The Prepaid Utility Service Interface documents the messaging interface used by Electrum to connect acquirers, processors, and issuers together for performing prepaid utility transactions.

You can find documentation for this project [here](https://electrumpayments.github.io/prepaidutility-service-interface-docs/).

## Java projects

To include the service interface into your maven project, include the below dependency.

```xml
<dependency>
    <groupId>io.electrum</groupId>
    <artifactId>prepaidutility-service-interface</artifactId>
    <version>3.14.0</version>
</dependency>
<dependency>
   <groupId>io.electrum</groupId>
   <artifactId>service-interface-base</artifactId>
   <version>3.32.0-RC1</version>
   <scope>provided</scope>
 </dependency>
```

Alternatively, you can download the jar from [Bintray](https://bintray.com/electrumpayments/java-open-source/prepaidutility-service-interface).

## Other languages

The interface is also available as a Swagger (OpenApi) definition, which can be used to generate starter projects in many languages. See more info [here](https://electrumpayments.github.io/prepaidutility-service-interface-docs/specification/swagger/).
