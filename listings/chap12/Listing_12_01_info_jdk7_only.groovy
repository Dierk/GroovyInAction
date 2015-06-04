def newline = "\n"

assert newline.toString() == "\n"

assert newline.dump() ==
    '''<java.lang.String@a value=
 hash=10 hash32=0>'''

assert newline.inspect() == /'\n'/
