def newline = "\n"

assert newline.toString() == "\n"

/* due to module security, this info is no longer available
   updated in 4.0.8
assert newline.dump() ==
    '''<java.lang.String@a value=
 hash=10>'''
 */

println "WARN: update String.dump() usage!"
// TODO: update String.dump() usage

assert newline.inspect() == /'\n'/
