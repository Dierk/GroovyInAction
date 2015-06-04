import groovy.transform.*

@AutoExternalize
@ToString
class Composer {
    String name
    int born
    boolean married
}

def c = new Composer(name: 'Wolfgang Amadeus Mozart',
        born: 1756, married: true)

def baos = new ByteArrayOutputStream()
baos.withObjectOutputStream{ os -> os.writeObject(c) }
def bais = new ByteArrayInputStream(baos.toByteArray())
def loader = getClass().classLoader
def result
bais.withObjectInputStream(loader) {
    result = it.readObject().toString()
}
assert result == 'Composer(Wolfgang Amadeus Mozart, 1756, true)'
