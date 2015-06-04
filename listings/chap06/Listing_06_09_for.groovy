def store = ''                                         //#1
for (String s in 'a'..'c') store += s                  //#1
assert store == 'abc'                                  //#1

store = ''                                             //#2
for (i in [1, 2, 3]) {                                 //#2
    store += i                                         //#2
}                                                      //#2
assert store == '123'                                  //#2

def myString = 'Old school Java'                       //#3
store = ''                                             //#3
for (int i=0; i < myString.size(); i++) {              //#3
    store += myString[i]                               //#3
}                                                      //#3
assert store == myString                               //#3

myString = 'Java range index'                          //#4
store = ''                                             //#4
for (int i : 0 ..< myString.size()) {                  //#4
    store += myString[i]                               //#4
}                                                      //#4
assert store == myString                               //#4

myString = 'Groovy range index'                        //#5
store = ''                                             //#5
for (i in 0 ..< myString.size()) {                     //#5
    store += myString[i]                               //#5
}                                                      //#5
assert store == myString                               //#5

myString = 'Java string Iterable'                      //#6
store = ''                                             //#6
for (String s : myString) {                            //#6
    store += s                                         //#6
}                                                      //#6
assert store == myString                               //#6

myString = 'Groovy iterator'                           //#7
store = ''                                             //#7
for (s in myString) {                                  //#7
    store += s                                         //#7
}                                                      //#7
assert store == myString                               //#7
//#1 Explicit typing, over string range, no braces
//#2 Implicit typing, over list as collection, braces
//#3 Explicit typing, Java-style traditional for loop, braces
//#4 Explicit typing, Java-style iterable index, braces
//#5 Implicit typing, over half-exclusive IntRange, braces
//#6 Explicit typing, Java-style iterable value, braces
//#7 Implicit typing, over string as collection, braces
