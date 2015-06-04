
// normal use
def    g1 =  "1 + 1 equals ${1 + 1}"
assert g1 == '1 + 1 equals 2'
assert g1 instanceof CharSequence
assert g1 instanceof GString

def x = 10

def    g2 =  "$x"   // reference
assert g2 == "10"

def    g3 =  "${x}" // expression
assert g3 == "10"

// lazy evaluation with a writeable closure!
def g4 = "${ -> x}" // closure
x = 20              // value change after definition
assert g4 == "20"   // lazy evaluation!
