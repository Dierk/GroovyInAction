import static groovy.test.GroovyAssert.shouldFail

void oneDimensional() {
    java.awt.Dimension d = [100]              //#A
}

shouldFail(ClassCastException) {
    oneDimensional()
}
//#A Two parameters required! Runtime error here!
