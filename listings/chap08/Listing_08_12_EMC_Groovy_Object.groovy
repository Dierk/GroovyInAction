class MyGroovy2 { }

def myGroovy = new MyGroovy2()

myGroovy.metaClass.myProp = "MyGroovy prop"
myGroovy.metaClass.test = {-> myProp }

try {
    new MyGroovy2().test()          //#1
    assert false, "should throw MME"
} catch(mme) { }

assert myGroovy.test() == "MyGroovy prop"