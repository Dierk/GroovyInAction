import static groovy.test.GroovyAssert.shouldFail

@Singleton class Zeus { }

assert Zeus.instance
def ex = shouldFail(RuntimeException) { new Zeus() }
assert ex.message ==
        "Can't instantiate singleton Zeus. Use Zeus.instance"
