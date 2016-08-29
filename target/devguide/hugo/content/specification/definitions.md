---
title: Definitions
menu:
  main:
    weight: 83
    parent: Specification
---


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
