---
title: "Transaction Flows"
menu:
  main:
    weight: 30
---

# Overview of prepaid utility purchases
_Note: The description and examples presented here are for electricity purchases, as this represents most prevalent type of prepaid utility transaction. The same principles apply for other services (e.g. gas and water), with just minor differences in the values of certain message fields._

### Token purchase and free tokens
The scenario for a prepaid electricity (PPE) purchase is that a customer has a meter installed at their home or work premises that dispenses electricity as long as there is credit available on the meter. To load credit onto the meter, the customer purchases a token from a merchant and manually inputs the token into the meter's keypad. The token is purchased for a specified monetary value and the service provider calculates the corresponding number of units (e.g. kWh) that are redeemable by the token. Note that a token is issued against a meter's unique serial number and can therefore only be redeemed on that specific meter.

In addition to the purchased amount, most customers are entitled to a monthly free allocation of electricity which, if due, will be supplied as part of the same transaction, but as a separate token. Tokens are typically formatted as a numeric string of length 20 and are printed on the receipt given to the customer at the point of sale. Note that meters are not able to communicate remotely and so it is not possible to deliver tokens directly to a meter via electronic means.

### Debt recovery and service charges
Where the electricity is issued by a municipality and the customer has an outstanding debt with that municipality, then part of the purchase value can be used to offset the debt. The value of the token returned is reduced accordingly. Similarly, any service charges due by the customer may also be deducted from the purchase. The specification defines data types that represent these charges.

### Service requests
Certain non-financial service functions are also supported by the specification. These include fault reporting and requests for the encryption key for a meter, should the key have been changed by the provider.

# Messaging protocols
### Single-message pair
In single pair messaging, a purchase request/response pair contains all the information necessary for the transaction to be finalised. In this case, the request should contain details confirming that payment was successfully tendered at POS. This is required for reconciliation and settlement between the merchant and electricity provider.

If the POS does not receive a response to a purchase request because of a connection timeout, this poses a problem if the request had in fact been received and processed by the provider and if the provider does not support reversals (i.e. the provider cannot cancel the transaction). There are ways through which a merchant can account for this which are discussed the Transaction sequence examples section.

### Dual-message pair
In dual pair messaging, a financial request/response pair is followed by a confirmation or advice message. The confirmation contains details of the payment tendered at POS which are used for reconciliation and settlement.

A transaction is only considered final once the provider has acknowledged receipt of a positive confirmation sent by the merchant. This implies that a request can be reversed (either through a timeout or POS-generated void) before it has been finalised and thus have no financial impact. This is most often not an appropriate procedure for PPE given the way in which tokens are issued and delivered. More on this below.

### Which messaging protocol to implement?
The specification supports both single- and dual-message pair transaction processing. However, PPE transactions typically operate as single-message pair and some providers don't support confirmation or reversal messages. The reason for this is that once a token has been issued by the provider, it (in most cases, at least) cannot be revoked. This is because the issuer cannot routinely verify whether or not the token has in fact been redeemed on the meter. The merchant is hence deemed liable for the cost of the token. The good news for merchants (and consumers) is that mechanisms exist to mitigate this risk through the use of various message types defined in the specification. Example scenarios are presented in the following section.

# Transaction sequence examples
### Meter lookup
The [createMeterLookup](/specification/operations/#createMeterLookup) operation allows for information about a specific meter to be queried. The client posts a request with a [MeterLookupRequest](/specification/definitions/#MeterLookupRequest) in the message body containing the relevant meter identifier. A successful response will contain in its body a [MeterLookupResponse](/specification/definitions/#MeterLookupResponse) supplying the information registered against this meter.

This operation can be utilised as a stand-alone information query, but it is more commonly used by the merchant as a validation check prior to proceeding with a purchase request.

### Successful token purchase
The recommended sequence for implementing a token purchase is to first post a [createMeterLookup](/specification/operations/#createMeterLookup) request. If this operation returns a successful response and the details contained in the response are deemed to be correct by the customer, then a [createPurchaseRequest](/specification/operations/#createPurchaseRequest) call can be made. In the case of a single-message pair transaction where payment is received at POS prior to the request being generated, no confirmation is sent, but where dual-message pair is used, the purchase request is followed by a [confirmTokenPurchase](/specification/operations/#confirmTokenPurchase) call.
##### Single-message pair

##### Dual-message pair

### Request timeout, followed by retry
Should the POS time out while awaiting a response to a purchase request, the recommended approach is to retry the original purchase request via the [retryPurchaseRequest](specification/definitions/#retryPurchaseRequest) operation. This will resend the original request and the expected response will contain a [PurchaseResponse](specification/definitions/#PurchaseResponse) body. It is possible to submit multiple retries for the same transaction until a response is received.

### Reprint request (if supported by POS)
1 pair (reprint request)
