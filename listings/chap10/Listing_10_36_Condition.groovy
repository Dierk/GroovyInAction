import static groovy.test.GroovyAssert.shouldFail

def e = shouldFail '''
import groovy.transform.TypeChecked

@TypeChecked
void leastUpperBoundOnConditional() {
    def o = new Date()                                //#1
    if (Math.random()) {                              //#A
        o = 'Hello'                                   //#2
    }
    o.time                                            //#B
}
//#1 Variable initialized with Date
//#A Random condition
//#2 Assign a String
//#B Try to call o.time
'''
assert e.message.contains('No such property: time for class: java.io.Serializable')
