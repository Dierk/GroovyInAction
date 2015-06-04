List x = [1, null, null, 2]

assert [1, 2] == x.findAll { it != null }
assert [1, 2] == x.grep { it }

assert [1, 2] == x - [null]

x.removeAll([null])
assert [1, 2] == x