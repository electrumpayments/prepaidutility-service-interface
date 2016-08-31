---
title: "Protocol Basics"
menu:
  main:
    weight: 10
---

The Prepaid Utility Service Interface is an HTTP-based protocol. A detailed description of the supported operations and definitions can be found in the [Specification](/specification/introduction) section.

## Security

All communication shall be secured by establishing an SSL encrypted transport. Basic HTTP authentication shall be used to authenticate clients with the service, and is required for all requests.

## Failures

The outcome of a request is determined by examining the HTTP status code of the response.

### Status type

Three outcomes for a transaction are possible and can be classed as follows: _successful_, _unknown_, and _failed_. HTTP status codes fall under one of the possible outcomes as indicated below.

HTTP Status Codes         | Status type
--------------------------|---------------------------------------------------------------------------------------------
200, 201, 202             | successful
500, 504, timeout         | unknown
400, 501, 503, all others | failed

A timeout occurs when the client has not received a response to a request after the agreed upon interval. Unless otherwise agreed, this interval shall be 60 seconds. Any response received after the timeout should be logged but otherwise ignored.

### ErrorDetail

In addition to the HTTP status code, non-successful response bodies shall contain an [ErrorDetail](/specification/definitions/#errordetail) object, if possible, to describe the failure in more detail. It should be noted though, that responses in some failure scenarios will contain an empty response body, and therefore no ErrorDetail object will be present.

