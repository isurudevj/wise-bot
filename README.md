# wise-bot

Wise bot is a multi-currency payout automation bot using `https://wise.com/` apis.
For more details about the apis, refer to `https://api-docs.transferwise.com/`.

## Set Up Guide

### Prerequisites

1. Create Sandbox account https://sandbox.transferwise.tech/
2. Set following two environment variables.
    
```shell
    WISE_API_URL
    WISE_API_TOKEN
```

### Guide

1. Executing payouts

```shell
https://api-docs.transferwise.com/#payouts-guide-create-quote
```

2. Wise postman api documentation 

```shell
https://github.com/transferwise/public-api-postman-collection/blob/master/all-endpoints/TW-API.postman_collection.json
```