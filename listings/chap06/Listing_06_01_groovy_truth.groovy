assert true                                            //#A
assert !false                                          //#A

assert ('a' =~ /./)                                    //#B
assert !('a' =~ /b/)                                   //#B

assert [1]                                             //#C
assert ![]                                             //#C

Iterator iter = [1].iterator()
assert iter                                            //#D
iter.next()                                            //#D
assert !iter                                           //#D

assert ['a':1]                                         //#E
assert ![:]                                            //#E

assert 'a'                                             //#F
assert !''                                             //#F

assert 1                                               //#G
assert 1.1                                             //#G
assert 1.2f                                            //#G
assert 1.3g                                            //#G
assert 2L                                              //#G
assert 3G                                              //#G
assert !0                                              //#G

assert ! null                                          //#H
assert new Object()                                    //#H

class AlwaysFalse {
    boolean asBoolean() { false }                      //#I
}
assert ! new AlwaysFalse()                             //#J
//#A Boolean values are trivial
//#B Matchers must match
//#C Collections must be nonempty
//#D Iterators must have next element
//#E Maps must be nonempty
//#F Strings must be nonempty
//#G Numbers (any type) must be nonzero
//#H Objects must be non-null
//#I Custom truth
//#J Calls asBoolean()
