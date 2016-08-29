---
title: Swagger
menu:
  main:
    weight: 84
    parent: Specification
---

The [swagger (Open API)](http://swagger.io) definition of the interface specification can be found [here](/specification/swagger/swagger.yaml), as well as below.

Many tools are available for processing swagger files, and using a code generation tool to create a boilerplate client or server can be an excellent starting point for development. We highly recommend looking at [swagger-codegen](https://github.com/swagger-api/swagger-codegen) for a generator in your preferred language when starting out.

### Swagger definition

```yaml
---
swagger: "2.0"
info:
  description: "The Electrum Prepaid Utility Service describes an interface for facilitating\
    \ the purchase of prepaid 
			tokens for utilities such as electricity and\
    \ water. One or more tokens for a requested value are issued by 
			an upstream\
    \ provider (typically a payments aggregator) against a specified meter number.\
    \ The tokens (each 
			being a sequence of usually 20 digits) are printed\
    \ on the customer receipt and are input manually on the 
			meter's keypad\
    \ for the value to be redeemed."
  version: "1.0.0"
  title: "iPrepaid Utility Service Interface"
  contact:
    name: "Electrum API"
    url: "http://io.electrum"
    email: "api@electrum.co.za"
  license:
    name: "Apache 2.0"
    url: "http://www.apache.org/licenses/LICENSE-2.0.html"
host: "sandbox.electrum.io"
basePath: "/prepaidutility/v1"
schemes:
- "https"
paths:
  /meterLookups/{lookupId}:
    post:
      summary: "Request information about a specified meter"
      description: "Request information about a specified meter, including customer\
        \ and utility details. This resource is used to verify that a meter number\
        \ is valid and registered with the correct details. It also confirms whether\
        \ the meter is recognised by a provider and that tokens can be issued against\
        \ it."
      operationId: "createMeterLookup"
      consumes:
      - "application/json"
      produces:
      - "application/json"
      parameters:
      - name: "lookupId"
        in: "path"
        description: "The randomly generated UUID of this request."
        required: true
        type: "string"
      - in: "body"
        name: "body"
        description: "A meter information lookup request."
        required: true
        schema:
          $ref: "#/definitions/MeterLookupRequest"
      responses:
        201:
          description: "Created"
          schema:
            $ref: "#/definitions/MeterLookupResponse"
        400:
          description: "Bad request"
          schema:
            $ref: "#/definitions/MeterLookupResponse"
        500:
          description: "Internal Server Error"
          schema:
            $ref: "#/definitions/MeterLookupResponse"
        503:
          description: "Service Unavailable"
          schema:
            $ref: "#/definitions/MeterLookupResponse"
        504:
          description: "Gateway Timeout"
          schema:
            $ref: "#/definitions/MeterLookupResponse"
      security:
      - httpBasic: []
  /tokenPurchases/{purchaseId}:
    post:
      summary: "Requests a token purchase for a specified meter."
      description: "Requests that the provider issue a token against the meter for\
        \ a given monetary value. In the case that the meter and/or utility supports\
        \ the issue of free tokens under a basic service support tariff scheme, then\
        \ any free tokens due will also be returned. If the requested amount is 0\
        \ and a free token is due to the meter, then only this free token will be\
        \ returned. A portion of the request amount may be used by the provider to\
        \ offset outstanding debt or service charges owed by the customer, in which\
        \ case the value of the token returned may be less than the request amount\
        \ (see interface documentation for further details)."
      operationId: "createTokenPurchaseRequest"
      consumes:
      - "application/json"
      produces:
      - "application/json"
      parameters:
      - name: "purchaseId"
        in: "path"
        description: "The randomly generated UUID of this request."
        required: true
        type: "string"
      - in: "body"
        name: "body"
        description: "A token purchase request."
        required: true
        schema:
          $ref: "#/definitions/PurchaseRequest"
      responses:
        201:
          description: "Created"
          schema:
            $ref: "#/definitions/PurchaseResponse"
        400:
          description: "Bad request"
          schema:
            $ref: "#/definitions/PurchaseResponse"
        500:
          description: "Internal Server Error"
          schema:
            $ref: "#/definitions/PurchaseResponse"
        503:
          description: "Service Unavailable"
          schema:
            $ref: "#/definitions/PurchaseResponse"
        504:
          description: "Gateway Timeout"
          schema:
            $ref: "#/definitions/PurchaseResponse"
  /tokenPurchases/{purchaseId}/confirmations/{confirmationId}:
    post:
      summary: "Confirms that a purchase has been completed successfully."
      description: "Confirms that a purchase has been completed successfully (i.e.\
        \ the tokens have been issued to the customer and payment has been received\
        \ by the merchant). It is typical that token providers do not support confirmations\
        \ (aka advices), but certain point-of-sale integrations may require support\
        \ for these. A confirmation request must be sent repeatedly until an HTTP\
        \ response code indicating a final state has been received (i.e. either 202\
        \ or 400)."
      operationId: "confirmTokenPurchase"
      consumes:
      - "application/json"
      produces:
      - "application/json"
      parameters:
      - name: "purchaseId"
        in: "path"
        description: "The randomly generated UUID of the original purchase request."
        required: true
        type: "string"
      - name: "confirmationId"
        in: "path"
        description: "The randomly generated UUID of this confirmation."
        required: true
        type: "string"
      - in: "body"
        name: "body"
        description: "A token purchase confirmation"
        required: true
        schema:
          $ref: "#/definitions/ConfirmationRequest"
      responses:
        202:
          description: "Accepted"
        400:
          description: "Bad request"
        500:
          description: "Internal Server Error"
        503:
          description: "Service Unavailable"
        504:
          description: "Gateway Timeout"
  /tokenPurchases/{purchaseId}/retries/{retryId}:
    post:
      summary: "Retry a previously submitted purchase request."
      description: "If no response was received to a purchase request due to a timeout\
        \ or temporary communications failure, PoS may retry the same purchase request\
        \ by calling this resource. The original purchase request will be resubmitted\
        \ to the provider. If the provider had received the original request, it will\
        \ respond by returning any tokens that were already issued. If not, then new\
        \ tokens will be issued as per a normal purchase."
      operationId: "retryPurchaseRequest"
      consumes:
      - "application/json"
      produces:
      - "application/json"
      parameters:
      - name: "purchaseId"
        in: "path"
        description: "The randomly generated UUID of the original purchase request."
        required: true
        type: "string"
      - name: "retryId"
        in: "path"
        description: "The randomly generated UUID of this retry request."
        required: true
        type: "string"
      - in: "body"
        name: "body"
        description: "A token purchase retry request."
        required: true
        schema:
          $ref: "#/definitions/PurchaseRequest"
      responses:
        202:
          description: "Accepted"
          schema:
            $ref: "#/definitions/PurchaseResponse"
        400:
          description: "Bad request"
          schema:
            $ref: "#/definitions/PurchaseResponse"
        500:
          description: "Internal Server Error"
          schema:
            $ref: "#/definitions/PurchaseResponse"
        503:
          description: "Service Unavailable"
          schema:
            $ref: "#/definitions/PurchaseResponse"
        504:
          description: "Gateway Timeout"
          schema:
            $ref: "#/definitions/PurchaseResponse"
  /tokenPurchases/{purchaseId}/reversals/{reversalId}:
    post:
      summary: "Notifies the provider that a purchase was not completed successfully."
      description: "Notifies that a purchase was not completed successfully. This\
        \ can occur if the original request timed out or if payment was unsuccessful.\
        \ Many providers, however, do not support reversals and once a token has been\
        \ issued the merchant becomes liable for the cost irrespective of payment\
        \ failure or timeout. The token may still be retrieved by a reprint request,\
        \ which merchants may use to help accommodate this scenario. A reversal request\
        \ must be sent repeatedly until an HTTP response code indicating a final state\
        \ has been received (i.e. either 202 or 400)."
      operationId: "reverseTokenPurchase"
      consumes:
      - "application/json"
      produces:
      - "application/json"
      parameters:
      - name: "purchaseId"
        in: "path"
        description: "The randomly generated UUID of the original purchase request."
        required: true
        type: "string"
      - name: "reversalId"
        in: "path"
        description: "The randomly generated UUID of this reversal."
        required: true
        type: "string"
      - in: "body"
        name: "body"
        description: "A token purchase reversal."
        required: true
        schema:
          $ref: "#/definitions/ReversalRequest"
      responses:
        202:
          description: "Accepted"
        400:
          description: "Bad request"
        500:
          description: "Internal Server Error"
        503:
          description: "Service Unavailable"
        504:
          description: "Gateway Timeout"
  /tokenReprints/{reprintId}:
    post:
      summary: "Requests a reprint of a token"
      description: "Requests a reprint of a token that was previously issued for a\
        \ specified meter. The request can be for either the last token issued for\
        \ that meter, or for a specific transaction reference, depending on what the\
        \ provider supports."
      operationId: "requestTokenReprint"
      consumes:
      - "application/json"
      produces:
      - "application/json"
      parameters:
      - name: "reprintId"
        in: "path"
        description: "The randomly generated UUID of this request."
        required: true
        type: "string"
      - in: "body"
        name: "body"
        description: "A token reprint request."
        required: true
        schema:
          $ref: "#/definitions/TokenReprintRequest"
      responses:
        200:
          description: "Success"
          schema:
            $ref: "#/definitions/PurchaseResponse"
        400:
          description: "Bad request"
          schema:
            $ref: "#/definitions/PurchaseResponse"
        500:
          description: "Internal Server Error"
          schema:
            $ref: "#/definitions/PurchaseResponse"
        503:
          description: "Service Unavailable"
          schema:
            $ref: "#/definitions/PurchaseResponse"
        504:
          description: "Gateway Timeout"
          schema:
            $ref: "#/definitions/PurchaseResponse"
securityDefinitions:
  httpBasic:
    description: "All requests require HTTP basic authentication, where user name\
      \ equals the value used in
                    MessageId.institutionId and\
      \ password has been agreed with Electrum."
    type: "basic"
definitions:
  Amount:
    type: "object"
    required:
    - "amount"
    - "currency"
    properties:
      amount:
        type: "integer"
        format: "int64"
        description: "Amount in minor denomination (e.g. cents)."
      currency:
        type: "string"
        description: "Three digit numeric ISO 4217 currency code (e.g. South African\
          \ Rand is encoded as 710)."
  ConfirmationRequest:
    type: "object"
    required:
    - "tenders"
    properties:
      tenders:
        type: "array"
        description: "Details of method(s) of payment and amount(s) tendered"
        items:
          $ref: "#/definitions/Tender"
  Customer:
    type: "object"
    properties:
      firstName:
        type: "string"
        description: "The customer's first name(s)"
        minLength: 0
        maxLength: 40
      lastName:
        type: "string"
        description: "The customer's last name"
        minLength: 0
        maxLength: 40
      address:
        type: "string"
        description: "The customer's address"
        minLength: 0
        maxLength: 80
    description: "A bill payment customer"
  DebtRecoveryCharge:
    type: "object"
    required:
    - "amount"
    - "balance"
    - "description"
    - "tax"
    properties:
      amount:
        description: "Amount charged for debt recovery, in minor denomination."
        $ref: "#/definitions/Amount"
      tax:
        description: "Tax levied on this charge."
        $ref: "#/definitions/Tax"
      description:
        type: "string"
        description: "Description of this debt recovery charge (e.g. municipal rates\
          \ arrears)."
      balance:
        description: "Remaining balance on this account."
        $ref: "#/definitions/Amount"
      receiptNum:
        type: "string"
        description: "Receipt number for this charge."
  LedgerAmount:
    type: "object"
    required:
    - "amount"
    - "currency"
    properties:
      amount:
        type: "integer"
        format: "int64"
        description: "Amount in minor denomination, e.g. R799.95 is encoded as 79995"
      currency:
        type: "string"
        description: "Three digit currency number from ISO 4217, e.g. South African\
          \ Rand is encoded as 710"
        pattern: "[0-9]{3}"
      ledgerIndicator:
        type: "string"
        description: "Indicates whether this amount is a debit or a credit. Only required\
          \ when the amount can be either a debit or a credit"
        enum:
        - "DEBIT"
        - "CREDIT"
    description: "An amount object only containing value and currency, and optionally\
      \ an indicator of DEBIT/CREDIT"
  Meter:
    type: "object"
    required:
    - "meterId"
    properties:
      meterId:
        type: "string"
        description: "Unique identifier for the meter (e.g. serial number)."
      serviceType:
        type: "string"
        description: "Type of service dispensed by this meter (e.g. electricity, water\
          \ or gas)."
      supplyGroupCode:
        type: "string"
        description: "Code used to identify a group of suppliers."
      keyRevisionNum:
        type: "string"
        description: "Key revision number of the meter."
      tariffIndex:
        type: "string"
        description: "Code representing the tariff associated with this meter."
      tokenTechCode:
        type: "string"
        description: "The means by which tokens are supplied for this meter (typically\
          \ either numeric token or magnetic track)."
      algorithmCode:
        type: "string"
        description: "Code used to identify token encryption algorithm used by the\
          \ meter."
      newSupplyGroupCode:
        type: "string"
        description: "New supply group code. Only relevant if this has been changed\
          \ by the utility and a key change token has been issued."
      newKeyRevisionNumber:
        type: "string"
        description: "New key revision number. Only relevant if this has been changed\
          \ by the utility and a key change token has been issued."
      newTariffIndex:
        type: "string"
        description: "New tariff index. Only relevant if this has been changed by\
          \ the utility and a key change token has been issued."
  MeterLookupRequest:
    type: "object"
    required:
    - "meterId"
    properties:
      meterId:
        type: "string"
        description: "Unique identifier (e.g. serial number) of the meter for which\
          \ information is requested."
  MeterLookupResponse:
    type: "object"
    required:
    - "meter"
    properties:
      meter:
        description: "Details of the meter."
        $ref: "#/definitions/Meter"
      customer:
        description: "Details of the person or organization to whom the meter belongs."
        $ref: "#/definitions/Customer"
      utility:
        description: "Details of the utility which manages this meter's account."
        $ref: "#/definitions/Utility"
      minAmount:
        description: "Minimum purchase amount that can be requested by the customer."
        $ref: "#/definitions/Amount"
      maxAmount:
        description: "Maximum purchase amount that can be requested by the customer."
        $ref: "#/definitions/Amount"
      bsstDue:
        type: "boolean"
        description: "Boolean flag indicating whether a free basic service support\
          \ token is owing on this meter. Not all meters support this and typically\
          \ only one free token is issued per calendar month. If the value of this\
          \ field is true, then a purchase request with an amount of 0 can be sent\
          \ and the response will contain the free token."
        default: false
  PurchaseRequest:
    type: "object"
    required:
    - "meterId"
    - "purchaseAmount"
    properties:
      meterId:
        type: "string"
        description: "Unique identifier (e.g. serial number) of the meter against\
          \ which token purchase is requested."
      purchaseAmount:
        description: "Monetary amount, in minor denomination, of the requested token\
          \ purchase."
        $ref: "#/definitions/Amount"
      track2Data:
        type: "string"
        description: "Track 2 data stored on the magnetic stripe of a card that is\
          \ supplied with certain meters. This data contains all meter details. It\
          \ can be used as an alternative means of input at PoS and may be required\
          \ by some provders."
      utilityType:
        type: "string"
        description: "Type of utility purchase being requested (e.g. electricity,\
          \ water, gas)."
      tenders:
        type: "array"
        description: "Details of method(s) of payment and amount(s) tendered. Only\
          \ present if the PoS implementation is for single-message pair transactions\
          \ (i.e. no confirmation request is sent)."
        items:
          $ref: "#/definitions/Tender"
  PurchaseResponse:
    type: "object"
    properties:
      meter:
        description: "Details of the meter."
        $ref: "#/definitions/Meter"
      customer:
        description: "Details of the person or organization to whom the meter belongs."
        $ref: "#/definitions/Customer"
      utility:
        description: "Details of the utility which manages this meter's account."
        $ref: "#/definitions/Utility"
      utilityType:
        type: "string"
        description: "Type of utility purchase being requested (e.g. electricity,\
          \ water, gas)."
      tokens:
        type: "array"
        description: "List of tokens issued for the purchase."
        items:
          $ref: "#/definitions/Token"
      debtRecoveryCharges:
        type: "array"
        description: "List of charges that have been levied in order to reclaim outstanding\
          \ debts associated with the meter."
        items:
          $ref: "#/definitions/DebtRecoveryCharge"
      serviceCharges:
        type: "array"
        description: "List of service charges levied against this meter."
        items:
          $ref: "#/definitions/ServiceCharge"
  ReversalRequest:
    type: "object"
    required:
    - "originalRequest"
    properties:
      originalRequest:
        description: "The purchase request for which this reversal has been generated."
        $ref: "#/definitions/PurchaseRequest"
  ServiceCharge:
    type: "object"
    required:
    - "amount"
    - "description"
    - "tax"
    properties:
      amount:
        description: "Amount charged for the service."
        $ref: "#/definitions/Amount"
      tax:
        description: "Tax levied on this charge."
        $ref: "#/definitions/Tax"
      description:
        type: "string"
        description: "Description of this service charge (e.g. connection fee)."
  TariffBlock:
    type: "object"
    required:
    - "rate"
    - "units"
    properties:
      units:
        type: "number"
        description: "Number of units in this tariff block."
      rate:
        type: "number"
        description: "Tariff rate for this block in minor denomination."
  Tax:
    type: "object"
    required:
    - "amount"
    - "description"
    properties:
      amount:
        description: "Amount of tax levied in minor denomination."
        $ref: "#/definitions/Amount"
      description:
        type: "string"
        description: "Description of the type of tax (e.g. VAT)."
      rate:
        type: "number"
        description: "Rate at which tax is levied, expressed as a percentage."
  Tender:
    type: "object"
    required:
    - "amount"
    - "tenderType"
    properties:
      accountType:
        type: "string"
        description: "The type of account"
        enum:
        - "DEFAULT"
        - "SAVINGS"
        - "CHEQUE"
        - "CREDIT"
        - "UNIVERSAL"
        - "ELECTRONIC_PURSE"
        - "STORED_VALUE"
      amount:
        description: "The tendered amount"
        $ref: "#/definitions/LedgerAmount"
      cardNumber:
        type: "string"
        description: "A PCI compliant masked card number, with at least the first\
          \ 6 digits in the clear. Only applicable to card based transactions"
        pattern: "[0-9]{6}[0-9*]{0,13}"
      reference:
        type: "string"
        description: "A free text reference"
        minLength: 0
        maxLength: 40
      tenderType:
        type: "string"
        description: "The type of tender used"
        enum:
        - "CASH"
        - "CHEQUE"
        - "CREDIT_CARD"
        - "DEBIT_CARD"
        - "WALLET"
        - "ROUNDING"
        - "OTHER"
    description: "Details of the Tender used by a customer towards a payment"
  Token:
    type: "object"
    required:
    - "amount"
    - "receiptNum"
    - "tariffCalc"
    - "tax"
    - "token"
    - "tokenType"
    - "units"
    properties:
      tokenType:
        type: "string"
        description: "Type of token, namely standard (STD), basic service support\
          \ tariff (BSST), refund (REFUND), key change (KC)."
        enum:
        - "STD"
        - "BSST"
        - "REFUND"
        - "KC"
      units:
        type: "number"
        description: "Number of units redeemable by this token."
      amount:
        description: "Monetary value of the token, exclusive of tax (value set to\
          \ 0 for free token)."
        $ref: "#/definitions/Amount"
      tax:
        description: "Tax component of this token purchase (value set to 0 for free\
          \ token)."
        $ref: "#/definitions/Tax"
      receiptNum:
        type: "string"
        description: "Receipt number issued for the transaction."
      token:
        type: "string"
        description: "Numeric sequence to be entered into the meter to redeem the\
          \ token's value."
      tariffCalc:
        type: "array"
        description: "List of tariff blocks determining how the overall tariff is\
          \ calculated."
        items:
          $ref: "#/definitions/TariffBlock"
  TokenReprintRequest:
    type: "object"
    required:
    - "meterId"
    properties:
      meterId:
        type: "string"
        description: "Unique identifier (e.g. serial number) of the meter for which\
          \ token reprint is requested."
      track2Data:
        type: "string"
        description: "Track 2 data stored on the magnetic stripe of a card that is\
          \ supplied with certain meters. This data contains all meter details. It\
          \ can be used as an alternative means of input at PoS and may be required\
          \ by some provders."
      originalRef:
        type: "string"
        description: "Reference or receipt number for the original token in the case\
          \ that a specific token is requested. If this field is not present, then\
          \ the last-issued token will be requested from the provider."
  Utility:
    type: "object"
    properties:
      name:
        type: "string"
        description: "Name of the utility."
      address:
        type: "string"
        description: "Physical address of the utility."
      vatRegNum:
        type: "string"
        description: "VAT registration number of the utility."
      clientId:
        type: "string"
        description: "Identifier assigned by the utility to the client connecting\
          \ to the utility's token issuing service."
      message:
        type: "string"
        description: "Message send by the utility to be displayed on the customer\
          \ receipt."
```
