---
title: "Transaction Flows"
menu:
  main:
    weight: 30
---

## Overview of prepaid utility purchases
_Note: The description and examples presented here are for electricity purchases, as this represents most prevalent type of prepaid utility transaction. The same principles apply for other services (e.g. gas and water), with just minor differences in the values of certain message fields._

### Token purchase and free tokens
The scenario for a prepaid electricity (PPE) purchase is that a customer has a meter installed at their home or work premises that dispenses electricity as long as there is credit available on the meter. To load credit onto the meter, the customer purchases a token from a merchant and manually inputs the token into the meter's keypad. The token is purchased for a specified monetary value and the service provider calculates the corresponding number of units (e.g. kWh) that are redeemable by the token. A token is issued against a meter's unique serial number and can therefore only be redeemed on that specific meter.

In addition to the purchased amount, most customers are entitled to a monthly free allocation of electricity which, if due, will be supplied as part of the same transaction, but as a separate token. Tokens are typically formatted as a numeric string of length 20 and are printed on the receipt given to the customer at the point of sale. Note that meters are not able to communicate remotely and so it is not possible to deliver tokens directly to a meter via electronic means.

### Debt recovery and service charges
Where the electricity is issued by a municipality and the customer has an outstanding debt with that municipality, then part of the purchase value can be used to offset the debt. The value of the token returned is reduced accordingly. Similarly, any service charges due by the customer may also be deducted from the purchase. The specification defines [data types](/specification/definitions) that represent these charges.

### Service requests
Certain non-financial service functions are also supported by the specification. These include fault reporting and requests for the encryption key for a meter, should the key have been changed by the provider.

## Messaging protocols
### Single message pair
In single-pair messaging, a purchase request/response pair contains all the information necessary for the transaction to be finalised. In this case, the request should contain details confirming that payment was successfully tendered at POS. This is required for reconciliation and settlement between the merchant and electricity provider.

### Dual message pair
In dual-pair messaging, a financial request/response pair is followed by a confirmation (or advice) message. The confirmation contains details of the payment tendered at POS which are used for reconciliation and settlement. A transaction is only considered final once the provider has acknowledged receipt of a positive confirmation sent by the merchant. This implies that a request can be reversed (either through a timeout reversal or POS-generated void) before it has been finalised and thus have no financial impact.

The confirmation or reversal advice is a "must deliver" message and so needs to be repeatedly sent until receipt has been acknowledged from upstream.

### Which messaging logic is supported?
Most PPE issuers do not support confirmation or reversal messages (i.e. they operate on a single message pair basis). The reason for this is that once a token has been issued, it usually can't be revoked, and the merchant becomes liable for its cost. This essentially renders a confirmation meaningless and a reversal not possible, as from the perspective of the token issuer the transaction is complete. Despite this, it is still possible for a client implementation to employ dual-pair messaging and for the server to include business rules for the handling of confirmations or reversals in the case that an upstream provider does not support these. This is the preferred scenario, as it can account for upstream implementations of either protocol. Hence, this specification only supports dual-pair messaging.

## Transaction sequence examples
### Meter lookup
The [createMeterLookup](/specification/operations/#createmeterlookup) operation allows for information about a specific meter to be queried. The client posts a request with a [MeterLookupRequest](/specification/definitions/#meterlookuprequest) in the message body containing the relevant meter identifier. A successful response will contain in its body a [MeterLookupResponse](/specification/definitions/#meterlookupresponse) supplying the information registered against this meter.

This operation can be utilised as a stand-alone information query, but it is more commonly used by the merchant as a validation check prior to proceeding with a purchase request.

![Successful meter lookup](/images/sequence-meter-lookup.png "Successful meter lookup")

### Successful token purchase
The recommended sequence for implementing a token purchase is to first post a [createMeterLookup](/specification/operations/#createmeterlookup) request. If this operation returns a successful response and the details contained in the response are deemed to be correct by the customer, then a [createTokenPurchaseRequest](/specification/operations/#createtokenpurchaserequest) call can be made. The purchase request is followed by a [confirmTokenPurchase](/specification/operations/#confirmtokenpurchase) call to finalise the transaction, which is immediately acknowledged by the server. If the upstream provider supports confirmations, then the server places the message in a [store-and-forward](/advanced-topics/#store-and-forward) queue for delivery.

The following diagrams represent different scenarios for successful purchases.

### _Confirmations supported by 3rd party_

![Successful token purchase - Dual message pair](/images/sequence_successful-purchase-dual.png "Successful token purchase - Dual message pair")

### _Confirmations not supported by 3rd party_

![Successful token purchase - Dual message pair 2](/images/sequence_successful-purchase-dual-2.png "Successful token purchase - Dual message pair 2")

### Unsuccessful token purchase
Should a token purchase fail at POS (e.g. if the customer is unable to make payment), the transaction can be voided via the [reverseTokenPurchase](/specification/operations/#reversetokenpurchase) operation. The reserver acknowledges receipt of the reversal immediately and places the message in a [store-and-forward](/advanced-topics/#store-and-forward) queue for delivery. If a provider does not support reversals, then they will respond to the server with an error message to this effect. The merchant and provider need to ensure that there is a process for handling this scenario from a reconciliation and settlement point of view.

### _Reversals supported by 3rd party_

![Unsuccessful token purchase - Reversal supported](/images/sequence_unsuccessful-purchase-reversal-supported.png "Unsuccessful token purchase - Reversal supported")

### _Reversals not supported by 3rd party_

![Unsuccessful token purchase - Reversal not supported](/images/sequence_unsuccessful-purchase-reversal-not-supported.png "Unsuccessful token purchase - Reversal not supported")

### Request timeout, followed by retry
Should the transaction time out before a response to a purchase request is received, the recommended approach is to retry the original purchase request via the [retryPurchaseRequest](/specification/operations/#retrypurchaserequest) operation. This consumes a [PurchaseRequest](/specification/definitions/#purchaserequest) message which is linked to the original request by the original purchaseId specified in the resource path. The expected response will contain a [PurchaseResponse](/specification/definitions/#purchaseresponse) body. It is possible to submit multiple retries for the same transaction until a response is received.

![Purchase request timeout with retry](/images/sequence_purchase-timeout-retry.png "Purchase request timeout with retry")

### Reprint request
Some POS environments may wish to implement support for token reprints. This is a stand-alone transaction whereby the customer requests a reprint of a previously-issued token. Usually this will be the last-issued token for that customer on the provider's system, but some providers allow for specific token reprints based on a transaction reference.

![Token Reprint Request](/images/sequence_reprint-request.png "Token Reprint Request")
