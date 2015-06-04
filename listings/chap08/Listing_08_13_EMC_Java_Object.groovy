def myJava = new String()

myJava.metaClass.myProp = "MyJava prop"
myJava.metaClass.test = {-> myProp }

try {
    new String().test()             //#1
    assert false, "should throw MME"
} catch(mme) { }

assert myJava.test() == "MyJava prop"