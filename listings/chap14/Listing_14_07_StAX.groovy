// requires stax.jar and stax-api.jar for Java 1.5
import javax.xml.stream.*

def input = 'file:data/plan.xml'.toURL()
def underway = []
def upcoming = []

def eachStartElement(inputStream, Closure yield) {
    def token = XMLInputFactory.newInstance()
        .createXMLStreamReader(inputStream)               //#1
    try {
        while (token.hasNext()) {                         //#2
            if (token.startElement) yield token
            token.next()
        }
    } finally {
        token?.close()
        inputStream?.close()
    }
}

class XMLStreamCategory {                                 //|#3
    static Object get(XMLStreamReader self, String key) { //|#3
        return self.getAttributeValue(null, key)          //|#3
    }                                                     //|#3
}                                                         //|#3

use (XMLStreamCategory) {
    eachStartElement(input.openStream()) { element ->
        if (element.name.toString() != 'task') return
        switch (element.done) {
            case '0' :
                upcoming << element.title
                break
            case { it != element.total } :
                underway << element.title
        }
    }
}

assert underway == [
    'use in current project'
]
assert upcoming == [
    're-read DB chapter',
    'use DB/XML combination'
]
