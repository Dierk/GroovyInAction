import groovy.transform.Immutable

@Immutable class FixedBook {                           //#A
    String title
}

def gina   = new FixedBook('Groovy in Action')         //#B
def regina = new FixedBook(title:'Groovy in Action')   //#C

assert gina.title == 'Groovy in Action'
assert gina == regina                                  //#D

try {
    gina.title = "Oops!"                               //#E
    assert false, "should not reach here"
} catch (ReadOnlyPropertyException expected) {
    println "Expected Error: '$expected.message'"
}
//#A AST annotation
//#B Positional constructor
//#C Named-arg constructor
//#D Standard equals()
//#E Not allowed!
