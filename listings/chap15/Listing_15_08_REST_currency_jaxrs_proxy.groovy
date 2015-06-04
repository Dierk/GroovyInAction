@Grab('org.jboss.resteasy:resteasy-client:3.0.10.Final')
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.client.ClientBuilder

interface CurrencyConvertor {
  @GET
  @Path("ConversionRate")
  @Produces("application/xml")
  String convert(@QueryParam("FromCurrency") String from,
                 @QueryParam("ToCurrency") String to)
}

def client = ClientBuilder.newClient()
def base = "http://www.webservicex.net/CurrencyConvertor.asmx"
def proxy = client.target(base).proxy(CurrencyConvertor)
def response = proxy.convert("USD", "EUR")
def root = new XmlSlurper().parseText(response)
assert root.name() == 'double'
println root.text()

// => 0.882
