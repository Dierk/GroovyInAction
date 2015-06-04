try {
    input = new File('no such file')
    assert input.exists()
    assert input.canRead()
    println input.text
} catch (AssertionError error) {
    assert "\n" + error.message == '''
assert input.exists()
       |     |
       |     false
       no such file'''
}