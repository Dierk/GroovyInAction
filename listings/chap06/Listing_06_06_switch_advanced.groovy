switch (10) {
    case 0          : assert false ; break
    case 0..9       : assert false ; break
    case [8,9,11]   : assert false ; break
    case Float      : assert false ; break                   //#1
    case {it%3 == 0}: assert false ; break                   //#2
    case ~/../      : assert true  ; break                   //#3
    default         : assert false ; break
}
//#1 Type case
//#2 Closure case
//#3 Regular expression case
