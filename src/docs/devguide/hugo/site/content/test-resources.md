## Overview
The Prepaid Utility Service Interface has a set of tools to assist developers with building client or server implementations of the interface. These take the form of a test server and a [Postman](https://www.getpostman.com) client test pack. Details of these are provided below.

## Test server

A server implementation of the Prepaid Utility Service Interface is accessible via the base url https://ppu-test-server.herokuapp.com/prepaidutility/v2. (Following this link will return a `404` error, but all the RESTful operations described in the specification are supported by the server).


> __IMPORTANT__: The test server is intended to be used as a development tool for testing the basic functionality of a client implementation of the service. It does not interface with any upstream provider and cannot be used for quality assurance or user-acceptance testing of an end-to-end solution.

The server backend consists of a set of mock responses which correspond to predefined test scenarios. The scenario is determined by the `meterId` of the request message. The table below provides a list of configured `meterId` values and their corresponding response message scenarios.

### Test case meter IDs
meterId | Response message scenario | Request amount (in Rand) | Notes
------- | ------------------------- | ------------------------ | -----
TST001  | 1 standard token | 100 |
TST002  | 1 free token | 0 |
TST003  | 1 standard token + 1 free token | 100 |
TST004  | 1 standard token with tariff calculation | 100 |
TST005  | 1 standard token + 1 refund token | 50 |
TST006  | 2 key change tokens + 1 standard token | 100 |
TST007  | 1 standard token + 1 debt recovery + 1 service charge | 200 |
TST008  | 1 standard token + 2 debt recovery charges | 200 |
TST009  | 1 standard token + 2 service charges | 200 |
TST010  | printable slip | 100 |
TST011  | 1 standard token | 100 | `PurchaseRequest` will time out; subsequent `RetryRequest` will be approved

A `MeterLookupRequest` for any of the allowed `meterId`s will return a valid `MeterLookupResponse`. Any other values for `meterId` will return an HTTP status code `400` with an error type `UNKNOWN_CUSTOMER_ACCOUNT`.

All `meterId`s, with the exception of `TST011`, can be used for standard `PurchaseRequest` test cases.

A `PurchaseRequest` with `meterId` of `TST011` will result in a timeout response (HTTP status `504`). A subsequent `RetryRequest` will be approved.

Requests of type `FaultReport` and `KeyChangeTokenRequest` will receive valid responses for all valid `meterId`s.

## Postman test pack

A set of example test cases that can be run with the Postman API testing client is available [here](https://github.com/electrumpayments/prepaidutility-test-server/tree/master/test/postman). This is primarily intended to test a server implementation of the REST interface, but can also be used as a reference when developing a client.
The test scenarios consist of either a single request message, or sequence of requests with various assertions that check the validity of the corresponding responses.

### Quick start guide
- Install the [Postman](https://www.getpostman.com/) client app and familiarize yourself with how to use it.
- Import the test pack [collection](https://github.com/electrumpayments/prepaidutility-test-server/blob/master/test/postman/PrepaidUtilityTestPack.postman_collection_v2.json) into Postman.

![Import collection](/images/postman-import.png)

- Import the test [environment](https://github.com/electrumpayments/prepaidutility-test-server/blob/master/test/postman/PPUherokutest.postman_environment.json) into Postman. Click "Manage environments" in the environment settings menu and select "Import" in the window that is opened. This can be updated from within Postman to reflect your specific environment (e.g. host url). Make sure to select the imported environment from the drop down menu.

![Import environment](/images/postman-environment.png)

- Run tests!

### Collection runner
Multiple tests can be run in one go using the Postman Collection Runner. To open this, select "Run" in the collection menu.

![Run collection](/images/postman-run-collection.png)

This will open a new window where you can select which folder of the collection to run. You can also select data files to set values for message variables. The data files provided with the test pack are used to set the `meterId` in the request messages so that all scenarios can be iterated over in a single run. For example, select the "Lookup-purchase-confirm" folder, load the [test_meterIds-purchases.csv](https://github.com/electrumpayments/prepaidutility-test-server/blob/master/test/postman/test_meterIds-purchases.csv) data file using the "Choose Files" button, set the iteration field to 10 (this is the number of meter IDs in the data file) and click "Start Test".

![Collection runner](/images/postman-collection-runner.png)

This will iterate over `meterId`s in the data file and execute the test cases.

### Command line utility
[Newman](https://www.npmjs.com/package/newman) is a command line utility for Postman, which can be used to easily execute a test suite as a batch process. The test pack contains a bash script [run_newman.sh](https://github.com/electrumpayments/prepaidutility-test-server/blob/master/test/postman/run_newman.sh) which will execute the full set of test cases.

Happy testing!
