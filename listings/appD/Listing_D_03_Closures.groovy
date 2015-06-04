def add  = { x, y -> x + y }
def mult = { x, y -> x * y }
assert add(1,3)  == 4
assert mult(1,3) == 3
def min = { x, y -> [x,y].min() }
def max = { x, y -> [x,y].max() }
def atLeastTen = max.curry(10)
assert atLeastTen(5)  == 10
assert atLeastTen(15) == 15
def pairWise(list, Closure invoke) {
    if (list.size() < 2) return []
    def next = invoke(list[0],list[1])
    return [next] + pairWise(list[1..-1], invoke)
}
assert pairWise(1..5, add)  == [3, 5, 7, 9]
assert pairWise(1..5, mult) == [2, 6, 12, 20]
assert pairWise(1..5, min)  == [1, 2, 3, 4]
assert pairWise(1..5, max)  == [2, 3, 4, 5]
assert 'cbaxabc' == ['a','b','c'].inject('x') {
        result, item -> item + result + item
}
assert [1,2,3].grep{ it<3 } == [1,2]
assert [1,2,3].any{ it%2 == 0 }
assert [1,2,3].every{ it<4 }
assert (1..9).collect{it}.join()   == '123456789'
assert (1..4).collect{it*2}.join() == '2468'