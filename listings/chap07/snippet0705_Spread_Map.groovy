def map = [a:1,b:2]
assert [a:1, b:2, c:3] == [c:3, *:map]