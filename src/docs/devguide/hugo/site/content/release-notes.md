This page describes changes to the Prepaid Utility Service Interface implemented across different releases of the interface.

## v3.12.1
Released 03 November 2020

- corrected the `RELATIVE_PATH` path of the `trialTokenPurchaseRequest` operation.

## v3.12.0
Released 30 October 2020

- Added a new operation, `trialTokenPurchaseRequest`, which mimics a conventional `createTokenPurchaseRequest` operation with the following exceptions:
    - Tokens may or may not be returned. If they are returned, they will be invalid tokens.
    - Has no financial impact.
- Added a new `ErrorType` called `NO_FREE_UNITS_DUE`. 
- Added two new operations to advise the outcome of key change transactions:
     - A `confirmKeyChange` operation which carries a `KeyChangeConfirmation` model to indicate a previous key change request is confirmed.


## v3.11.0
Released 18 September 2020

- Added the following new `RequestType` values:
    - `NOTIFY_TOKEN_PURCHASE`

## v3.10.0
Released 2 September 2020

- Corrected repetition of API base path.
  - *Note* This is breaking change to the API but is not treated as such. Previously the API defined paths to operations
    as `/prepaidutility/v3/prepaidutility/v3/{operation}` when they should have been of the more simple form 
    `/prepaidutility/v3/{operation}`. Changing the API base path in this manner would typically be a breaking change and 
    would be reflected as such by bumping the major version number in the URL from `v3` to `v4`. However, all known 
    projects depending on the Prepaid Utility Service Interface are already implemented using the simpler base path of 
    `/prepaidutility/v3/{operation}`. Thus, the decision was made to transparently fix the base path repetition bug as a 
    minor version update as this was deemed to be a less disruptive change to all known projects.
- Added a new `events` resource that has a `notifyTokenPurchase` operation which should be invoked for informational 
  purposes when a successful token purchase has taken place.

## v3.9.0
Released 13 August 2020

- Added an `amounts` field to `PurchaseResponse`. This can be used for any additional amounts which don't
  traditionally fit into dedicated amount fields.
- Added an `arrearsAmount` `LedgerAmount` to `MeterLookupResponse` for handling customer debt payments & outstanding debt
  balance enquiries.
- Incorporated new interfaces from `service-interface-base`. This change affects the Java implementation of the API
  only and does not further change the public definition of the API. The Java implementation has been updated as follows: 
    - The following classes now implement the `HasAmounts` interface defined in the base API:
        - `PurchaseResponse`
    - The following classes now implement the `HasPaymentMethods` interface defined in the base API:
        - `PurchaseRequest`

## v3.8.0
Released 12 March 2020

- Added the following new `ErrorType` values:
    - `UTILITY_INVALID`
    - `SYSTEM_MALFUNCTION`
    - `METER_KEY_INVALID`
    - `AMOUNT_TOO_LOW`
    - `AMOUNT_TOO_HIGH`
- Updated jetty version from `v9.2.14.v20151106` to `v9.4.17.v20190418`.

## 3.7.0
Released 27 November 2019

- Added `PWRLMT` as a Token Type enumeration. "Power Limit" tokens are tokens which allow a municipality to communicate an
*instantaneous* load limit to a consumer's Prepaid Electricity Meter. For example, a "Power Limit" of 1kW means that, if a
consumer's load is above 1kW, the meter will cut off their supply for a predefined amount of time, and then reset. If the load
continues to exceed this instantaneous limit, this cycle will repeat.
- Update the java version to OpenJDK 11 with Java 8 Source compatibility 

## 3.6.0
Released 04 October 2019

- Added `httpBasic` authorisation to all the `TokenPurchases` and `TokenReprint` resources in the API. Previously, `httpBasic` authorisation was omitted from the API documentation for these resources, even though it is required. The affected operations are:
    - `createTokenPurchaseRequest`
    - `confirmTokenPurchase`
    - `retryPurchaseRequest`
    - `reverseTokenPurchase`
    - `requestTokenReprint`

## 3.5.2
Released 04 September 2018

- Made various path related constants available.
- Update base service interface version to v3.12.1.
    - Added in new base interface.
    - Added in new JsonUtil class
    - `BasicAdviceResponse` has been depricated and now extends `BasicAdvice`
- Added the vatInvoiceNumber field to the PurchaseResponse

## v3.5.1
Released 18 May 2018

* Added `INVALID_AN32_TOKEN` error type
* Added `DO_NOT_HONOR` error type
* Added `INVALID_MSISDN` error type
* Added `INVALID_LOYALTY_CARD` error type

## v3.5.0

Released 15 May 2018

- Added field `paymentMethods` to `PurchaseRequest`
- Update base service interface version to v3.9.0.
    - Added `PaymentMethod` model with subtypes `An32TokenPayment` and `LoyaltyCardPayment`
    - Changed `PaymentMethodType.TOKEN` to `PaymentMethodType.AN_32_TOKEN` 
    - Added `amount` field to `PaymentMethod`
    - Added EncryptedPin model object

## v3.4.0

Released 8 November 2017

- Update base service interface version to v3.4.0.
  - Added optional `barcode` field to `SlipLine` which represents a barcode on a till slip.

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
