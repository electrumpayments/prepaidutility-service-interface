---
title: "Advanced Topics"
menu:
  main:
    weight: 20
---

## Transaction identifiers

Transaction identifiers (unique values generated per transaction) are assigned to transactions by the client. This ensures that all transactions can be easily identified even if no response is received and a reversal is generated.

To prevent duplicate transactions where many originating institutions use the same service, it is very important that these id's are generated correctly by clients. If you are developing a client implementation, please take note to generate id's as random UUID's, as defined for a variant 4 UUID by [RFC 4122](https://tools.ietf.org/html/rfc4122).

Conversely, if you are developing a service implementation, take care to verify that a request does not contain an id that already exists in the system, and decline all such requests with a status code of 400 and an [ErrorType](/specification/definitions/#errordetail) of DUPLICATE_RECORD.

## Store-and-forward

To ensure that loss of transactional data is minimized, it is required that clients store advice (confirmation or reversal) messages (see [Transaction flows](/transaction-flows)) in persistent storage and queue them until a _final_ status type is received. A final response is one of either the _successful_ or _failed_ status types. If no response is received, or a response with an _unknown_ status type is received, advice messages must be queued and the message at the head of queue repeated on an interval until a final status type is received. For high throughput systems it is acceptable to send several advice messages in parallel, and as such, advices may be received out of order at the server.

The above applies to the following operations:

* confirmTokenPurchase
* reverseTokenPurchase

Note that not all implementations of this service will support these operations. Refer to [Transaction flows](/transaction-flows) for more details.
