class Spy {
    static {
        def mc = new ExpandoMetaClass(Spy, false, true)             //#A
        mc.initialize()
        Spy.metaClass = mc
    }
    String name = "James"

    void methodMissing(String name, args) {
        if (name.startsWith('changeNameTo')) {
            println "Adding method $name"
            String newName = name.substring(12)
            def newMethod = { delegate.name = newName }             //#1
            Spy.metaClass."$name" = newMethod                       //#2
            newMethod()                                             //#B
        } else {
            throw new MissingMethodException(name, this.class, args)
        }
    }
}

def spy = new Spy()
assert "James" == spy.name
spy.changeNameToAustin()
assert "Austin" == spy.name
spy.changeNameToMaxwell()
assert "Maxwell" == spy.name
spy.changeNameToAustin()
//#1 If method not found, define new one
//#2 Cache method
//#A Create an ExpandoMetaClass for Spy class
//#B Call new method
