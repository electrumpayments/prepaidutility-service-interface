---
title: Prepaid Utility Service Interface
type: index
---

[Electrum Payments](http://electrum.io) connects businesses so that they may transact with each other easily and robustly. This Prepaid Utility Service Interface documents the messaging interface used by Electrum to connect acquirers, processors, and issuers together for performing prepaid purchases of utilities such as electricity, water and gas.

Transactions involve a customer purchasing credit for an arbitrary monetary value to load onto a prepaid utility meter. The credit is issued in the form of a numeric token which is manually input on the meter's keypad to be redeemed. Such a purchase can take place at a retailer or merchant that supports this facility, and where the merchant has a connection with the token issuer that vends against that specific meter. The commercial arrangement is typically between the merchant and a payments aggregator, which in turn interfaces with multiple issuers. The Electrum Prepaid Utility Service is designed to provide an interface that connects merchants to aggregators via the Electrum switching platform. 
