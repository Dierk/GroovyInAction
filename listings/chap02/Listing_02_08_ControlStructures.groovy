if (false) assert false                                //#A

if (null)                                              //#B
{                                                      //#C
    assert false
}
else
{
    assert true
}

def i = 0                                              //#D
while (i < 10) {                                       //#D
    i++                                                //#D
}                                                      //#D
assert i == 10                                         //#D

def clinks = 0                                         //#E
for (remainingGuests in 0..9) {                        //#E
    clinks += remainingGuests                          //#E
}                                                      //#E
assert clinks == (10*9)/2                              //#E

def list = [0, 1, 2, 3]                                //#F
for (j in list) {                                      //#F
    assert j == list[j]                                //#F
}                                                      //#F

list.each() { item ->                                  //#G
    assert item == list[item]                          //#G
}                                                      //#G

switch(3)  {                                           //#H
    case 1 : assert false; break                       //#H
    case 3 : assert true;  break                       //#H
    default: assert false                              //#H
}                                                      //#H
//#A The if as one-liner
//#B Null is false
//#C Blocks may start on new line
//#D Classic while
//#E The for in range
//#F The for in list
//#G The each method with a closure
//#H Class switch
