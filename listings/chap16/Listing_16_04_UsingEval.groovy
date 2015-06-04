assert "Hello" == Eval.me("'Hello'")
assert 1 == Eval.x  (1, "x")
assert 3 == Eval.xy (1, 2, "x+y")
assert 6 == Eval.xyz(1, 2, 3, "x+y+z")
