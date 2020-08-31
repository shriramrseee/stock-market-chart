# stock-market-chart
A Spring+Angular app for Stock Market charts

## Run Instructions

First run `com.stock.eurekaserver.EurekaServerApplication` to start the Eureka server.

Then run the class `com.stock.chart.core.ChartCoreApplication` to start the microservice. The service will listen in port 8081.

## A sample request

POST `http://localhost:8081/contact/add`

```
{
    "city": "Blr",
    "email": "abc@xyz.com",
    "phone": "9012356788",
    "state": "KA",
    "zip": "560025"
}
```
