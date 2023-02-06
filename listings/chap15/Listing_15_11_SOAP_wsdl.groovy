//@Grab('org.codehaus.groovy:groovy-xml:2.2.0')
import groovy.xml.Namespace

def url  = 'http://www.webservicex.net/CurrencyConvertor.asmx?WSDL'
def wsdl = new Namespace('http://schemas.xmlsoap.org/wsdl/','wsdl')
def doc  = new groovy.xml.XmlParser().parse(url)

println doc[wsdl.portType][wsdl.operation].'@name'

// -> [ConversionRate, ConversionRate, ConversionRate]
