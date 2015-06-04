def list = []
def expected = [1, 2]

list.with {
    add 1
    add 2
    assert delegate == expected
}