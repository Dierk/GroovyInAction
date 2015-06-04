def table = [
    [0, 1],
    [2, 3]
]
table = table.collectNested { item -> item + 1 }
assert table == [
    [1, 2],
    [3, 4]
]
assert table.transpose() == [
    [1, 3],
    [2, 4]
]
assert table.combinations() == [
    [1, 3], [2, 3], [1, 4], [2, 4]
]