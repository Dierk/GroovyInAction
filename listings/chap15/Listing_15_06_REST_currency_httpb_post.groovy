@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.2')
import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.URLENC

def url = 'http://www.webservicex.net/CurrencyConvertor.asmx/'
def converter = new RESTClient(url)
def postBody = [FromCurrency: 'USD', ToCurrency: 'EUR']
converter.post(path: 'ConversionRate', body: postBody,
    requestContentType: URLENC) { resp, data ->
  assert resp.status == 200
  assert data.name() == 'double'
  println data.text()
}
// => http://www.webservicex.net/CurrencyConvertor.asmx/ConversionRate
// => <double xmlns="http://www.webserviceX.NET/">0.882</double>
// => 0.882
