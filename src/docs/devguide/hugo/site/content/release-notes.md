This page describes changes to the Prepaid Utility Service Interface implemented across different releases of the interface.

## v3.3.1

Released 9 October 2017

- Update Swagger Jersey 2 JAX-RS version to v1.5.16.
- Remove included SLF4J library.

## v3.3.0
Released 9 Aug 2017

* Additional annotations for cascading model validation

## v3.2.0
Released 24 July 2017

* Added `INVALID_MERCHANT` error type

## v3.1.0
Released 5 Jul 2017

* Added `TRANSACTION_DECLINED` error type

## v3.0.0
Released 1 Mar 2017

### Breaking changes
* Removed `PurchaseRequestRetry` object from operations. This has been replaced with the conventional `PurchaseRequest` object for the `retryPurchaseRequest` operation.
* Removed `PurchaseRequestRetry` object definition

## v2.1.0

Released 24 Nov 2016

* Added `purchaseTotal` and `taxTotal` fields to `PurchaseResponse` model
* Added HTTP 501 status to resources
* Tax fields in `TaxableAmount` model are no longer mandatory  

## v2.0.0
Released 25 Oct 2016

### Breaking changes
* Introduced `PurchaseRequestRetry` model to be used in place of `PurchaseRequest` for request retries
* Introduced `SlipData` model to be used in place of `PrintableSlip`
* Removed `slipWdth` from requests as this is now contained in `SlipData`
* Introduced `ConfirmationAdvice` and `ReversalAdvice` models as wrappers for `TenderAdvice` and `BasicReversal`, respectively
* Refactored `ErrorDetail` model

### Non-breaking changes
* Added `msisdn` and `tenders` fields to `PurchaseRequest` model
* Added `BasicAdviceResponse` body to `reverseTokenPurchase` and `confirmTokenPurchase` operations
* Added `LOYALTY_CARD` and `GIFT_CARD` tender types


## v1.1.2
Released 19 Sep 2016

* Bug fix to JSON validator

## v1.1.1
Released 15 Sep 2016

* Bug fix to `TaxableAmount` getter methods

## v1.1.0
Released 12 Sep 2016

* Removed requirement for containing the original request in a reversal request

## v1.0.1
Released 12 Sep 2016

* Fixed incorrect method signatures in interface classes

## v1.0.0
Released 7 Sep 2016

* Initial release
