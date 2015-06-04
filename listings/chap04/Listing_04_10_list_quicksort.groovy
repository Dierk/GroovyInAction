def quickSort(list) {
  if (list.size() < 2) return list
  def pivot  = list[list.size().intdiv(2)]
  def left   = list.findAll { item -> item <  pivot }      //#1
  def middle = list.findAll { item -> item == pivot }      //#1
  def right  = list.findAll { item -> item >  pivot }      //#1
  return quickSort(left) + middle + quickSort(right)       //#A
}

assert quickSort([])                 == []
assert quickSort([1])                == [1]
assert quickSort([1,2])              == [1,2]
assert quickSort([2,1])              == [1,2]
assert quickSort([3,1,2])            == [1,2,3]
assert quickSort([3,1,2,2])          == [1,2,2,3]
assert quickSort([1.0f,'a',10,null]) == [null,1.0f,10,'a'] //#2
assert quickSort('bca')              == 'abc'.toList()     //#3
//#1 Classify by pivot
//#A Recursive calls
//#2 Ducktyped items
//#3 Ducktyped structure
