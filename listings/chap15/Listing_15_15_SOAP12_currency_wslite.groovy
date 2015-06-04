@Grab('com.github.groovy-wslite:groovy-wslite:1.1.0')
import wslite.soap.*

def url = 'http://www.webserviceX.NET/CurrencyConvertor.asmx?WSDL'
def client = new SOAPClient(url)
def response = client.send {
  version SOAPVersion.V1_2
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
