def x = 1

if (x == 2) {                                          //#1
    assert false
}
/*******************
if (x =  2) {                                          //#2
   println x
}
********************/
if ((x = 3)) {                                         //#3
    println x 
}
assert x == 3

def store = []
while (x = x - 1) {                                    //#4
    store << x
}
assert store == [2, 1]

while (x =  2) {                                       //#5
    println x
    break
}
//#1 Normal comparison
//#2 Not allowed; compiler error
//#3 Assign and test in nested expression
//#4 Deliberate assign and test in while
//#5 Ouch—this will print 2
