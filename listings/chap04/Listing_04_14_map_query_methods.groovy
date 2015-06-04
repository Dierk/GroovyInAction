def myMap = [a:1, b:2, c:3]
def other = [b:2, c:3, a:1]

assert myMap == other                                  //#A

assert !myMap.isEmpty()                                //#B
assert myMap.size()     == 3                           //#B
assert myMap.containsKey('a')                          //#B
assert myMap.containsValue(1)                          //#B
assert myMap.entrySet() instanceof Collection          //#B

assert myMap.any   {entry -> entry.value > 2  }        //#1
assert myMap.every {entry -> entry.key   < 'd'}        //#1
assert myMap.keySet() == ['a','b','c'] as Set          //#C
assert myMap.values().toList() == [1, 2, 3]            //#D
//#A Call to equals
//#B JDK methods
//#1 GDK methods
//#C Set equals
//#D List equals
