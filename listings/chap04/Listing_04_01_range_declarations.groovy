assert (0..10).contains(0)                             //#A
assert (0..10).contains(5)                             //#A
assert (0..10).contains(10)                            //#A

assert (0..10).contains(-1) == false                   //#A
assert (0..10).contains(11) == false                   //#A

assert (0..<10).contains(9)                            //#B
assert (0..<10).contains(10) == false                  //#B

def a = 0..10                                          //#1
assert a instanceof Range                              //#1
assert a.contains(5)                                   //#1

a = new IntRange(0,10)                                 //#C
assert a.contains(5)                                   //#C

assert (0.0..1.0).contains(1.0)                        //#D
assert (0.0..1.0).containsWithinBounds(0.5)            //#D

def today     = new Date()                             //#2
def yesterday = today - 1                              //#2
assert (yesterday..today).size() == 2                  //#2

assert ('a'..'c').contains('b')                        //#3

def log = ''                                           //#E
for (element in 5..9){                                 //#E
    log += element                                     //#E
}                                                      //#E
assert log == '56789'                                  //#E

log = ''                                               //#F
for (element in 9..5){                                 //#F
    log += element                                     //#F
}                                                      //#F
assert log == '98765'                                  //#F

log = ''                                               //#4
(9..<5).each { element ->                              //#4
    log += element                                     //#4
}                                                      //#4
assert log == '9876'                                   //#4
//#A Inclusive ranges
//#B Half-exclusive ranges
//#1 References to ranges
//#C Explicit construction
//#D Bounds checking
//#2 Date ranges
//#3 String ranges
//#E for-in-range loop
//#F Loop with reverse range
//#4 Half-exclusive, reverse, each with closure
