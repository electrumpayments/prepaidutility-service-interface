---
title: "Advanced Topics"
menu:
  main:
    weight: 20
---

## Transaction id's

Transaction identifiers (unique values generated per transaction) are assigned to transactions by the client. This ensures that all transactions can be easily identified even if no 
response is received and a reversal is generated.

To prevent duplicate transactions where many originating institutions use the same service, it is very important that these id's are generated correctly by clients. 
If you are developing a client implementation, please take note to generate id's as random UUID's, as defined for a variant 4 UUID by [RFC 4122](https://tools.ietf.org/html/rfc4122).

Conversely, if you are developing a service implementation, take care to verify that a request does not contain an id that already exists in the system, and decline all such requests with a 
status code of 400 and an [ErrorType](/specification/definitions/#errordetail) of DUPLICATE_RECORD.

## LinkData

It is sometimes useful for service implementations to have clients send data present in the request message again in the [confirmation](/transaction-flows/#payments). The linkData field is used for this purpose, and is a free-form object that may contain any data.

The use of linkData is optional for service implementations.

Client implementations should ensure that if linkData is present the linkData field present in the request response is placed into the matching advice request unaltered.
