class MyClass {
    def first = 1                   // read-write property
    def getSecond() { first * 2 }   // read-only property
    public third = 3                // public field
    def myMethod() { }              // public method
}

def obj = new MyClass()

assert obj.hasProperty('first')                 //|#1
assert obj.respondsTo('myMethod')               //|#2

def keys = ['first', 'second', 'class']
assert obj.properties.keySet() == new HashSet(keys)

assert 1 == obj.properties['first']             //|#3
assert 1 == obj.properties.first                //|#3

assert 1 == obj.first                           //|#4
assert 1 == obj['first']    // getAt('first')   //|#4

def one = 'first'
def two = 'second'
obj[one] = obj[two]         // putAt(one)       //#5
assert obj.dump() =~ 'first=2'                  //#6
//#1 Property check
//#2 Method check
//#3 Properties map
//#4 Direct access
//#5 Dynamic assignment
//#6 Field introspection
