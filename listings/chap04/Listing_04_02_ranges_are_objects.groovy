def result = ''                                        //#A
(5..9).each { element ->                               //#A
    result += element                                  //#A
}                                                      //#A
assert result == '56789'                               //#A

assert 5 in 0..10                                      //#1
assert (0..10).isCase(5)                               //#1
                                                       //#1
def age = 36                                           //#1
switch(age){                                           //#1
    case 16..20 : insuranceRate = 0.05 ; break         //#1
    case 21..50 : insuranceRate = 0.06 ; break         //#1
    case 51..65 : insuranceRate = 0.07 ; break         //#1
    default: throw new IllegalArgumentException()      //#1
}                                                      //#1
assert insuranceRate == 0.06                           //#1
                                                  
def ages = [20, 36, 42, 56]                            //#2
def midage = 21..50                                    //#2
assert ages.grep(midage) == [36, 42]                   //#2
//#A Iterating over a range
//#1 Ranges for classification
//#2 Filtering with ranges
