//@Grab('org.codehaus.groovy:groovy-templates:2.2.0')
import groovy.text.SimpleTemplateEngine as STE
import groovy.xml.Namespace

def file     = new File('data/conv.templ.xml')                 //#A
def template = new STE().createTemplate(file)
def params   = [from:'USD', to:'EUR']
def request  = template.make(params).toString().getBytes('UTF-8')

def url  = 'http://www.webservicex.net/CurrencyConvertor.asmx'
def conn = new URL(url).openConnection()
def reqProps = [
  'Content-Type': 'text/xml; charset=UTF-8',                   //#|B
  'SOAPAction'  : 'http://www.webserviceX.NET/ConversionRate', //#|B
  'Accept'      : 'application/soap+xml, text/*'               //#|B
]
reqProps.each { key,value -> conn.addRequestProperty(key,value) }

conn.requestMethod = 'POST'
conn.doOutput      = true
conn.outputStream << new ByteArrayInputStream(request)          //#C
if (conn.responseCode != conn.HTTP_OK) {
   println "Error - HTTP:${conn.responseCode}"
   return
}

def resp   = new XmlParser().parse(conn.inputStream)            //#D
def serv   = new Namespace('http://www.webserviceX.NET/')
def result = serv.ConversionRateResult                          //#E

print   "Current USD to EUR conversion rate: "
println resp.depthFirst().find{result == it.name()}.text()
// Current USD to EUR conversion rate: 0.882
//#A Templated envelope of SOAP request
//#B Request headers to use every time
//#C Send the request
//#D Parse the response
//#E Extract the result
