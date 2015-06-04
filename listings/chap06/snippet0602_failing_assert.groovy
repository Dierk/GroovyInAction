def a = 1
try {
    assert a == 2
} catch (AssertionError error) {
    assert "\n" + error.message =='''
assert a == 2
       | |
       1 false'''
}