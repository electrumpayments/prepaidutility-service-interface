---
title: Operations
menu:
  main:
    weight: 82
    parent: Specification
---









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
