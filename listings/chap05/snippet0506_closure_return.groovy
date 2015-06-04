assert [2, 4, 6] == [1, 2, 3].collect { it * 2 }

assert [2, 4, 6] == [1, 2, 3].collect { return it * 2 }

assert [1, 4, 3] == [1, 2, 3].collect {
  if (it % 2 == 0) return it * 2
  return it
}
