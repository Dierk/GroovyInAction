enum Month {
    Jan, Feb, Mar, Apr, May, Jun,
    Jul, Aug, Sep, Oct, Nov, Dec
}
def noClams   = Month.May .. Month.Aug
def thisMonth = Month.Aug

boolean iWarnedYou  = false
if (thisMonth in noClams) {                            //#1
    println "Don't eat clams this month,"
    println "it has no 'r' in its name!"
    iWarnedYou = true
}
assert iWarnedYou
//#1 'in' operator