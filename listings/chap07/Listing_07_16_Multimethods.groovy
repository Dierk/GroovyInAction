def oracle(Object o) { return 'object' }
def oracle(String o) { return 'string' }

Object x = 1
Object y = 'foo'

assert 'object' == oracle(x)
assert 'string' == oracle(y)                           //#A
//#A This would return object in Java
