# StockService

Enter cmd into the base project directory containing the README.md file

Compile the project:
> mvn compile

Test the project:
> mvn test

Package the project:
> mvn package

Run the packaged jar:
> java -jar target\StockApi-0.1.0.jar

# NOTE: 
The project is madeup of RestFul web services hence to use the services you need to use proper REST Client 
e.g. Advanced REST Client for Chrome.

# Create Stock

To Create a stock item 'abc' with initial price 4.5:

> PUT http://localhost:8080/stock/abc/

> REQUEST BODY:
{
  "value" : 4.5
}

RESPONSE:

> 200 OK: if valid

> 200 OK: if valid and no value is provided. Default value 0.0 will be used

> 409 CONFLICT: the stock is already present

# Get Stock

To get a stock item 'abc':

> GET http://localhost:8080/stock/abc/

RESPONSE:
> 200 OK: if valid

> 404 NOT_FOUND: the stock is absent

# Modify Stock

To modify a stock item 'abc' with new value '9.9':

> POST http://localhost:8080/stock/abc/

> REQUEST BODY:
{
  "value" : 9.9
}

RESPONSE:

> 200 OK: if valid, the value will be changed

> 404 NOT_FOUND: the stock is absent

# Get Stats of a Stock

To get stats on a stock item 'abc':

> GET http://localhost:8080/stock/abc/stats

RESPONSE:

> 200 OK: if valid, the value will be changed

> 404 NOT_FOUND: the stock is absent
