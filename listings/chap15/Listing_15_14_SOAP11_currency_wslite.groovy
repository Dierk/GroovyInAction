@Grab('com.github.groovy-wslite:groovy-wslite:1.1.0')
import wslite.soap.SOAPClient

def url = 'http://www.webservicex.net/CurrencyConvertor.asmx?WSDL'
def client = new SOAPClient(url)
def action = "http://www.webserviceX.NET/ConversionRate"
def response = client.send(SOAPAction: action) {
  body {
    ConversionRate(xmlns: 'http://www.webserviceX.NET/') {
      FromCurrency('USD')
      ToCurrency('EUR')
    }
  }
}
assert response.httpResponse.statusCode == 200
println response.ConversionRateResponse.ConversionRateResult
// => 0.882
