import static groovy.test.GroovyAssert.shouldFail

def e = shouldFail '''
import groovy.transform.*

@TupleConstructor
class Author {
    String first
    String last
    int born
}

@TypeChecked
Author createAuthor(List params) {
    Author a = params                //#A
    a
}
createAuthor(['Agatha', 'Christie', 1890])
'''
assert e.message.contains('Cannot assign value of type java.util.List' +
    ' to variable of type Author')
//#A Compile-time error!
