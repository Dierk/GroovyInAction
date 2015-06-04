def myMap = [a:1, b:2, c:3]

assert myMap instanceof LinkedHashMap
assert myMap.size() == 3
assert myMap['a']   == 1

def emptyMap = [:]
assert emptyMap.size() == 0

def explicitMap = new TreeMap()
explicitMap.putAll(myMap)
assert explicitMap['a'] == 1

def composed     = [x:'y', *:myMap]                    //#A
assert composed == [x:'y', a:1, b:2, c:3]
//#A Spread operator
