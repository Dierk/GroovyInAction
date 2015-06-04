import static groovy.test.GroovyAssert.shouldFail

def e = shouldFail '''
@groovy.transform.TypeChecked
class Repeat {
    static void repeat(int n, String message) {
        n.times{ println message }
    }
    static void validateAll(String... args) {
        repeat('Hello', 4)
    }
}
'''
println e.message
assert e.message.contains(
    'Cannot find matching method Repeat#repeat(java.lang.String, int)')
