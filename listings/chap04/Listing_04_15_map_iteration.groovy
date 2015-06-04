def myMap = [a:1, b:2, c:3]

def store = ''
myMap.each { entry ->                                  //#A
    store += entry.key                                 //#A
    store += entry.value                               //#A
}                                                      //#A
assert store == 'a1b2c3'

store = ''
myMap.each { key, value ->                             //#B
    store += key                                       //#B
    store += value                                     //#B
}                                                      //#B
assert store == 'a1b2c3'

store = ''
for (key in myMap.keySet()) {                          //#C
    store += key                                       //#C
}                                                      //#C
assert store == 'abc'

store = ''
for (value in myMap.values()) {                        //#D
    store += value                                     //#D
}                                                      //#D
assert store == '123'
//#A Iterate over entries
//#B Iterate over keys/values
//#C Iterate over just the keys
//#D Iterate over just the values
