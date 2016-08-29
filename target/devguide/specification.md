

**Version** 1.0.0

The Electrum Prepaid Utility Service describes an interface for facilitating the purchase of prepaid 
			tokens for utilities such as electricity and water. One or more tokens for a requested value are issued by 
			an upstream provider (typically a payments aggregator) against a specified meter number. The tokens (each 
			being a sequence of usually 20 digits) are printed on the customer receipt and are input manually on the 
			meter&#x27;s keypad for the value to be redeemed.

Email [**Electrum API**](mailto:api@electrum.co.za)

Licensed under [**Apache 2.0**](http://www.apache.org/licenses/LICENSE-2.0.html)








# Security Definitions


### httpBasic




<table>
    <tr>
        <th>type</th>
        <td colspan="2">basic</td>
    </tr>

        <tr>
            <th>description</th>
            <td colspan="2">All requests require HTTP basic authentication, where user name equals the value used in
                    MessageId.institutionId and password has been agreed with Electrum.</td>
        </tr>

</table>





# Operations








## createMeterLookup



Request information about a specified meter

**POST /meterLookups/{lookupId}**

Request information about a specified meter, including customer and utility details. This resource is used to verify that a meter number is valid and registered with the correct details. It also confirms whether the meter is recognised by a provider and that tokens can be issued against it.




#### Security




* httpBasic




#### Request


**Content-Type:** application/json


Parameters
<table border="1">
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>

<tr>
    <th>lookupId</th>
    <td>path</td>
    <td>yes</td>
    <td>The randomly generated UUID of this request.</td>
    <td></td>
    <td>string </td>

</tr>

<tr>
    <th>body</th>
    <td>body</td>
    <td>yes</td>
    <td>A meter information lookup request.</td>
    <td></td>
    <td>[MeterLookupRequest](/specification/definitions/#meterlookuprequest)
</tr>


</table>



#### Response


**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 201    | Created | [MeterLookupResponse](/specification/definitions/#meterlookupresponse)|
| 400    | Bad request | [MeterLookupResponse](/specification/definitions/#meterlookupresponse)|
| 500    | Internal Server Error | [MeterLookupResponse](/specification/definitions/#meterlookupresponse)|
| 503    | Service Unavailable | [MeterLookupResponse](/specification/definitions/#meterlookupresponse)|
| 504    | Gateway Timeout | [MeterLookupResponse](/specification/definitions/#meterlookupresponse)|



















## createTokenPurchaseRequest



Requests a token purchase for a specified meter.

**POST /tokenPurchases/{purchaseId}**

Requests that the provider issue a token against the meter for a given monetary value. In the case that the meter and/or utility supports the issue of free tokens under a basic service support tariff scheme, then any free tokens due will also be returned. If the requested amount is 0 and a free token is due to the meter, then only this free token will be returned. A portion of the request amount may be used by the provider to offset outstanding debt or service charges owed by the customer, in which case the value of the token returned may be less than the request amount (see interface documentation for further details).







#### Request


**Content-Type:** application/json


Parameters
<table border="1">
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>

<tr>
    <th>purchaseId</th>
    <td>path</td>
    <td>yes</td>
    <td>The randomly generated UUID of this request.</td>
    <td></td>
    <td>string </td>

</tr>

<tr>
    <th>body</th>
    <td>body</td>
    <td>yes</td>
    <td>A token purchase request.</td>
    <td></td>
    <td>[PurchaseRequest](/specification/definitions/#purchaserequest)
</tr>


</table>



#### Response


**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 201    | Created | [PurchaseResponse](/specification/definitions/#purchaseresponse)|
| 400    | Bad request | [PurchaseResponse](/specification/definitions/#purchaseresponse)|
| 500    | Internal Server Error | [PurchaseResponse](/specification/definitions/#purchaseresponse)|
| 503    | Service Unavailable | [PurchaseResponse](/specification/definitions/#purchaseresponse)|
| 504    | Gateway Timeout | [PurchaseResponse](/specification/definitions/#purchaseresponse)|



















## confirmTokenPurchase



Confirms that a purchase has been completed successfully.

**POST /tokenPurchases/{purchaseId}/confirmations/{confirmationId}**

Confirms that a purchase has been completed successfully (i.e. the tokens have been issued to the customer and payment has been received by the merchant). It is typical that token providers do not support confirmations (aka advices), but certain point-of-sale integrations may require support for these. A confirmation request must be sent repeatedly until an HTTP response code indicating a final state has been received (i.e. either 202 or 400).







#### Request


**Content-Type:** application/json


Parameters
<table border="1">
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>

<tr>
    <th>purchaseId</th>
    <td>path</td>
    <td>yes</td>
    <td>The randomly generated UUID of the original purchase request.</td>
    <td></td>
    <td>string </td>

</tr>

<tr>
    <th>confirmationId</th>
    <td>path</td>
    <td>yes</td>
    <td>The randomly generated UUID of this confirmation.</td>
    <td></td>
    <td>string </td>

</tr>

<tr>
    <th>body</th>
    <td>body</td>
    <td>yes</td>
    <td>A token purchase confirmation</td>
    <td></td>
    <td>[ConfirmationRequest](/specification/definitions/#confirmationrequest)
</tr>


</table>



#### Response


**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 202    | Accepted | |
| 400    | Bad request | |
| 500    | Internal Server Error | |
| 503    | Service Unavailable | |
| 504    | Gateway Timeout | |



















## retryPurchaseRequest



Retry a previously submitted purchase request.

**POST /tokenPurchases/{purchaseId}/retries/{retryId}**

If no response was received to a purchase request due to a timeout or temporary communications failure, PoS may retry the same purchase request by calling this resource. The original purchase request will be resubmitted to the provider. If the provider had received the original request, it will respond by returning any tokens that were already issued. If not, then new tokens will be issued as per a normal purchase.







#### Request


**Content-Type:** application/json


Parameters
<table border="1">
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>

<tr>
    <th>purchaseId</th>
    <td>path</td>
    <td>yes</td>
    <td>The randomly generated UUID of the original purchase request.</td>
    <td></td>
    <td>string </td>

</tr>

<tr>
    <th>retryId</th>
    <td>path</td>
    <td>yes</td>
    <td>The randomly generated UUID of this retry request.</td>
    <td></td>
    <td>string </td>

</tr>

<tr>
    <th>body</th>
    <td>body</td>
    <td>yes</td>
    <td>A token purchase retry request.</td>
    <td></td>
    <td>[PurchaseRequest](/specification/definitions/#purchaserequest)
</tr>


</table>



#### Response


**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 202    | Accepted | [PurchaseResponse](/specification/definitions/#purchaseresponse)|
| 400    | Bad request | [PurchaseResponse](/specification/definitions/#purchaseresponse)|
| 500    | Internal Server Error | [PurchaseResponse](/specification/definitions/#purchaseresponse)|
| 503    | Service Unavailable | [PurchaseResponse](/specification/definitions/#purchaseresponse)|
| 504    | Gateway Timeout | [PurchaseResponse](/specification/definitions/#purchaseresponse)|



















## reverseTokenPurchase



Notifies the provider that a purchase was not completed successfully.

**POST /tokenPurchases/{purchaseId}/reversals/{reversalId}**

Notifies that a purchase was not completed successfully. This can occur if the original request timed out or if payment was unsuccessful. Many providers, however, do not support reversals and once a token has been issued the merchant becomes liable for the cost irrespective of payment failure or timeout. The token may still be retrieved by a reprint request, which merchants may use to help accommodate this scenario. A reversal request must be sent repeatedly until an HTTP response code indicating a final state has been received (i.e. either 202 or 400).







#### Request


**Content-Type:** application/json


Parameters
<table border="1">
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>

<tr>
    <th>purchaseId</th>
    <td>path</td>
    <td>yes</td>
    <td>The randomly generated UUID of the original purchase request.</td>
    <td></td>
    <td>string </td>

</tr>

<tr>
    <th>reversalId</th>
    <td>path</td>
    <td>yes</td>
    <td>The randomly generated UUID of this reversal.</td>
    <td></td>
    <td>string </td>

</tr>

<tr>
    <th>body</th>
    <td>body</td>
    <td>yes</td>
    <td>A token purchase reversal.</td>
    <td></td>
    <td>[ReversalRequest](/specification/definitions/#reversalrequest)
</tr>


</table>



#### Response


**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 202    | Accepted | |
| 400    | Bad request | |
| 500    | Internal Server Error | |
| 503    | Service Unavailable | |
| 504    | Gateway Timeout | |



















## requestTokenReprint



Requests a reprint of a token

**POST /tokenReprints/{reprintId}**

Requests a reprint of a token that was previously issued for a specified meter. The request can be for either the last token issued for that meter, or for a specific transaction reference, depending on what the provider supports.







#### Request


**Content-Type:** application/json


Parameters
<table border="1">
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>

<tr>
    <th>reprintId</th>
    <td>path</td>
    <td>yes</td>
    <td>The randomly generated UUID of this request.</td>
    <td></td>
    <td>string </td>

</tr>

<tr>
    <th>body</th>
    <td>body</td>
    <td>yes</td>
    <td>A token reprint request.</td>
    <td></td>
    <td>[TokenReprintRequest](/specification/definitions/#tokenreprintrequest)
</tr>


</table>



#### Response


**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Success | [PurchaseResponse](/specification/definitions/#purchaseresponse)|
| 400    | Bad request | [PurchaseResponse](/specification/definitions/#purchaseresponse)|
| 500    | Internal Server Error | [PurchaseResponse](/specification/definitions/#purchaseresponse)|
| 503    | Service Unavailable | [PurchaseResponse](/specification/definitions/#purchaseresponse)|
| 504    | Gateway Timeout | [PurchaseResponse](/specification/definitions/#purchaseresponse)|














# Definitions

## Amount

<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>amount</td>
    <td>integer</td>
    <td>required</td>
    <td></td>
    <td>format:<i>int64</i><br/></td>
    <td>Amount in minor denomination (e.g. cents).</td>
</tr>
<tr>
    <td>currency</td>
    <td>string</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Three digit numeric ISO 4217 currency code (e.g. South African Rand is encoded as 710).</td>
</tr>

</table>

## ConfirmationRequest

<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>tenders</td>
    <td>array[[Tender](#tender)]</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Details of method(s) of payment and amount(s) tendered</td>
</tr>

</table>

## Customer
A bill payment customer
<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>firstName</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td>maxLength:<i>40</i><br/></td>
    <td>The customer's first name(s)</td>
</tr>
<tr>
    <td>lastName</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td>maxLength:<i>40</i><br/></td>
    <td>The customer's last name</td>
</tr>
<tr>
    <td>address</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td>maxLength:<i>80</i><br/></td>
    <td>The customer's address</td>
</tr>

</table>

## DebtRecoveryCharge

<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>amount</td>
    <td>[Amount](#amount)</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Amount charged for debt recovery, in minor denomination.</td>
</tr>
<tr>
    <td>tax</td>
    <td>[Tax](#tax)</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Tax levied on this charge.</td>
</tr>
<tr>
    <td>description</td>
    <td>string</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Description of this debt recovery charge (e.g. municipal rates arrears).</td>
</tr>
<tr>
    <td>balance</td>
    <td>[Amount](#amount)</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Remaining balance on this account.</td>
</tr>
<tr>
    <td>receiptNum</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Receipt number for this charge.</td>
</tr>

</table>

## LedgerAmount
An amount object only containing value and currency, and optionally an indicator of DEBIT/CREDIT
<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>amount</td>
    <td>integer</td>
    <td>required</td>
    <td></td>
    <td>format:<i>int64</i><br/></td>
    <td>Amount in minor denomination, e.g. R799.95 is encoded as 79995</td>
</tr>
<tr>
    <td>currency</td>
    <td>string</td>
    <td>required</td>
    <td></td>
    <td>pattern:<i>[0-9]{3}</i><br/></td>
    <td>Three digit currency number from ISO 4217, e.g. South African Rand is encoded as 710</td>
</tr>
<tr>
    <td>ledgerIndicator</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td><i>[DEBIT, CREDIT]</i></td>
    <td>Indicates whether this amount is a debit or a credit. Only required when the amount can be either a debit or a credit</td>
</tr>

</table>

## Meter

<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>meterId</td>
    <td>string</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Unique identifier for the meter (e.g. serial number).</td>
</tr>
<tr>
    <td>serviceType</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Type of service dispensed by this meter (e.g. electricity, water or gas).</td>
</tr>
<tr>
    <td>supplyGroupCode</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Code used to identify a group of suppliers.</td>
</tr>
<tr>
    <td>keyRevisionNum</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Key revision number of the meter.</td>
</tr>
<tr>
    <td>tariffIndex</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Code representing the tariff associated with this meter.</td>
</tr>
<tr>
    <td>tokenTechCode</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>The means by which tokens are supplied for this meter (typically either numeric token or magnetic track).</td>
</tr>
<tr>
    <td>algorithmCode</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Code used to identify token encryption algorithm used by the meter.</td>
</tr>
<tr>
    <td>newSupplyGroupCode</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>New supply group code. Only relevant if this has been changed by the utility and a key change token has been issued.</td>
</tr>
<tr>
    <td>newKeyRevisionNumber</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>New key revision number. Only relevant if this has been changed by the utility and a key change token has been issued.</td>
</tr>
<tr>
    <td>newTariffIndex</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>New tariff index. Only relevant if this has been changed by the utility and a key change token has been issued.</td>
</tr>

</table>

## MeterLookupRequest

<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>meterId</td>
    <td>string</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Unique identifier (e.g. serial number) of the meter for which information is requested.</td>
</tr>

</table>

## MeterLookupResponse

<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>meter</td>
    <td>[Meter](#meter)</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Details of the meter.</td>
</tr>
<tr>
    <td>customer</td>
    <td>[Customer](#customer)</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Details of the person or organization to whom the meter belongs.</td>
</tr>
<tr>
    <td>utility</td>
    <td>[Utility](#utility)</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Details of the utility which manages this meter's account.</td>
</tr>
<tr>
    <td>minAmount</td>
    <td>[Amount](#amount)</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Minimum purchase amount that can be requested by the customer.</td>
</tr>
<tr>
    <td>maxAmount</td>
    <td>[Amount](#amount)</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Maximum purchase amount that can be requested by the customer.</td>
</tr>
<tr>
    <td>bsstDue</td>
    <td>boolean</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Boolean flag indicating whether a free basic service support token is owing on this meter. Not all meters support this and typically only one free token is issued per calendar month. If the value of this field is true, then a purchase request with an amount of 0 can be sent and the response will contain the free token.</td>
</tr>

</table>

## PurchaseRequest

<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>meterId</td>
    <td>string</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Unique identifier (e.g. serial number) of the meter against which token purchase is requested.</td>
</tr>
<tr>
    <td>purchaseAmount</td>
    <td>[Amount](#amount)</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Monetary amount, in minor denomination, of the requested token purchase.</td>
</tr>
<tr>
    <td>track2Data</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Track 2 data stored on the magnetic stripe of a card that is supplied with certain meters. This data contains all meter details. It can be used as an alternative means of input at PoS and may be required by some provders.</td>
</tr>
<tr>
    <td>utilityType</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Type of utility purchase being requested (e.g. electricity, water, gas).</td>
</tr>
<tr>
    <td>tenders</td>
    <td>array[[Tender](#tender)]</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Details of method(s) of payment and amount(s) tendered. Only present if the PoS implementation is for single-message pair transactions (i.e. no confirmation request is sent).</td>
</tr>

</table>

## PurchaseResponse

<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>meter</td>
    <td>[Meter](#meter)</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Details of the meter.</td>
</tr>
<tr>
    <td>customer</td>
    <td>[Customer](#customer)</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Details of the person or organization to whom the meter belongs.</td>
</tr>
<tr>
    <td>utility</td>
    <td>[Utility](#utility)</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Details of the utility which manages this meter's account.</td>
</tr>
<tr>
    <td>utilityType</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Type of utility purchase being requested (e.g. electricity, water, gas).</td>
</tr>
<tr>
    <td>tokens</td>
    <td>array[[Token](#token)]</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>List of tokens issued for the purchase.</td>
</tr>
<tr>
    <td>debtRecoveryCharges</td>
    <td>array[[DebtRecoveryCharge](#debtrecoverycharge)]</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>List of charges that have been levied in order to reclaim outstanding debts associated with the meter.</td>
</tr>
<tr>
    <td>serviceCharges</td>
    <td>array[[ServiceCharge](#servicecharge)]</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>List of service charges levied against this meter.</td>
</tr>

</table>

## ReversalRequest

<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>originalRequest</td>
    <td>[PurchaseRequest](#purchaserequest)</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>The purchase request for which this reversal has been generated.</td>
</tr>

</table>

## ServiceCharge

<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>amount</td>
    <td>[Amount](#amount)</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Amount charged for the service.</td>
</tr>
<tr>
    <td>tax</td>
    <td>[Tax](#tax)</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Tax levied on this charge.</td>
</tr>
<tr>
    <td>description</td>
    <td>string</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Description of this service charge (e.g. connection fee).</td>
</tr>

</table>

## TariffBlock

<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>units</td>
    <td>number</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Number of units in this tariff block.</td>
</tr>
<tr>
    <td>rate</td>
    <td>number</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Tariff rate for this block in minor denomination.</td>
</tr>

</table>

## Tax

<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>amount</td>
    <td>[Amount](#amount)</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Amount of tax levied in minor denomination.</td>
</tr>
<tr>
    <td>description</td>
    <td>string</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Description of the type of tax (e.g. VAT).</td>
</tr>
<tr>
    <td>rate</td>
    <td>number</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Rate at which tax is levied, expressed as a percentage.</td>
</tr>

</table>

## Tender
Details of the Tender used by a customer towards a payment
<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>accountType</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td><i>[DEFAULT, SAVINGS, CHEQUE, CREDIT, UNIVERSAL, ELECTRONIC_PURSE, STORED_VALUE]</i></td>
    <td>The type of account</td>
</tr>
<tr>
    <td>amount</td>
    <td>[LedgerAmount](#ledgeramount)</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>The tendered amount</td>
</tr>
<tr>
    <td>cardNumber</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td>pattern:<i>[0-9]{6}[0-9*]{0,13}</i><br/></td>
    <td>A PCI compliant masked card number, with at least the first 6 digits in the clear. Only applicable to card based transactions</td>
</tr>
<tr>
    <td>reference</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td>maxLength:<i>40</i><br/></td>
    <td>A free text reference</td>
</tr>
<tr>
    <td>tenderType</td>
    <td>string</td>
    <td>required</td>
    <td></td>
    <td><i>[CASH, CHEQUE, CREDIT_CARD, DEBIT_CARD, WALLET, ROUNDING, OTHER]</i></td>
    <td>The type of tender used</td>
</tr>

</table>

## Token

<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>tokenType</td>
    <td>string</td>
    <td>required</td>
    <td></td>
    <td><i>[STD, BSST, REFUND, KC]</i></td>
    <td>Type of token, namely standard (STD), basic service support tariff (BSST), refund (REFUND), key change (KC).</td>
</tr>
<tr>
    <td>units</td>
    <td>number</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Number of units redeemable by this token.</td>
</tr>
<tr>
    <td>amount</td>
    <td>[Amount](#amount)</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Monetary value of the token, exclusive of tax (value set to 0 for free token).</td>
</tr>
<tr>
    <td>tax</td>
    <td>[Tax](#tax)</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Tax component of this token purchase (value set to 0 for free token).</td>
</tr>
<tr>
    <td>receiptNum</td>
    <td>string</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Receipt number issued for the transaction.</td>
</tr>
<tr>
    <td>token</td>
    <td>string</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Numeric sequence to be entered into the meter to redeem the token's value.</td>
</tr>
<tr>
    <td>tariffCalc</td>
    <td>array[[TariffBlock](#tariffblock)]</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>List of tariff blocks determining how the overall tariff is calculated.</td>
</tr>

</table>

## TokenReprintRequest

<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>meterId</td>
    <td>string</td>
    <td>required</td>
    <td></td>
    <td></td>
    <td>Unique identifier (e.g. serial number) of the meter for which token reprint is requested.</td>
</tr>
<tr>
    <td>track2Data</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Track 2 data stored on the magnetic stripe of a card that is supplied with certain meters. This data contains all meter details. It can be used as an alternative means of input at PoS and may be required by some provders.</td>
</tr>
<tr>
    <td>originalRef</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Reference or receipt number for the original token in the case that a specific token is requested. If this field is not present, then the last-issued token will be requested from the provider.</td>
</tr>

</table>

## Utility

<table border="1">
<tr>
    <th>Name</th>
    <th>Type</th>
    <th>Required</th>
    <th>Default</th>
    <th>Restrictions</th>
    <th>Description</th>
</tr>
<tr>
    <td>name</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Name of the utility.</td>
</tr>
<tr>
    <td>address</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Physical address of the utility.</td>
</tr>
<tr>
    <td>vatRegNum</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>VAT registration number of the utility.</td>
</tr>
<tr>
    <td>clientId</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Identifier assigned by the utility to the client connecting to the utility's token issuing service.</td>
</tr>
<tr>
    <td>message</td>
    <td>string</td>
    <td>optional</td>
    <td></td>
    <td></td>
    <td>Message send by the utility to be displayed on the customer receipt.</td>
</tr>

</table>

