import static groovy.test.GroovyAssert.shouldFail

def e = shouldFail '''
import groovy.transform.TypeChecked

@TypeChecked
void notAllowed() {
    def var = "String"
    def cl = { var = new Date() }
    cl()
    var = var.toUpperCase()
}
'''
assert e.message.contains(
    'A closure shared variable [var] has been assigned with ')
