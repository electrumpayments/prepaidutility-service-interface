---
title: Introduction
menu:
  main:
    weight: 81
    parent: Specification
---



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
