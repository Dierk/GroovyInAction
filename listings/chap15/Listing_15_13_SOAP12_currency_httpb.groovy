@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.2')
import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.XML

def base = 'http://www.webserviceX.NET/CurrencyConvertor.asmx'
def soapEnv = 'http://www.w3.org/2003/05/soap-envelope'
def contentType = 'application/soap+xml; charset=UTF-8'
new RESTClient(base).with {
  parser.'application/soap+xml' = parser.'application/xml'          //#1
  headers = ['Content-Type': contentType]                           //#2
  post(requestContentType: XML, body: {
    'soap:Envelope'('xmlns:soap': soapEnv) {
      'soap:Body' {
        ConversionRate(xmlns: 'http://www.webserviceX.NET/') {
          FromCurrency('USD')
          ToCurrency('EUR')
        }
      }
    }
  }) { resp, data ->
    assert resp.status == 200
    println data.text()
  }
}
//#1 register a SOAP response parser
//#2 Content-Type expected by SOAP server

// xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://www.w3.org/2003/05/soap-envelope"
// => http://www.webservicex.net/CurrencyConvertor.asmx/ConversionRate
// => <double xmlns="http://www.webserviceX.NET/">0.882</double>
// => 0.882
/*
<soap:Envelope
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns:xsd="http://www.w3.org/2001/XMLSchema"
  xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <ConversionRate xmlns="http://www.webserviceX.NET/">
      <FromCurrency>${from}</FromCurrency>
      <ToCurrency>${to}</ToCurrency>
    </ConversionRate>
  </soap:Body>
</soap:Envelope>
*/