@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.2')
import groovyx.net.http.RESTClient

def url = 'http://www.webservicex.net/CurrencyConvertor.asmx/'
def converter = new RESTClient(url)
def params = [FromCurrency: 'USD', ToCurrency: 'EUR']
converter.get(path: 'ConversionRate', query: params) { resp, data ->
  assert resp.status == 200
  assert data.name() == 'double'
  println data.text()
}
// => http://www.webservicex.net/CurrencyConvertor.asmx/ConversionRate?FromCurrency=USD&ToCurrency=EUR
// => <double xmlns="http://www.webserviceX.NET/">0.882</double>
// => 0.882
