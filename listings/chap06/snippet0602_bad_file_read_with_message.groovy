try {
    input = new File('/no such file')
    assert input.exists(), "cannot find: $input.canonicalPath"
    assert input.canRead()
    println input.text
} catch (AssertionError error) {
    def root = new File('/').canonicalPath
    assert error.message ==
        'cannot find: ' + root + 'no such file. ' +
        'Expression: input.exists()'
}
