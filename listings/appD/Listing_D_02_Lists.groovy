assert [1,2,3,4]       == (1..4)
assert [1,2,3] + [1]   == [1,2,3,1]
assert [1,2,3] << 1    == [1,2,3,1]
assert [1,2,3,1] - [1] == [2,3]
assert [1,2,3] * 2     == [1,2,3,1,2,3]
assert [1,[2,3]].flatten() == [1,2,3]
assert [1,2,3].reverse()   == [3,2,1]
assert [1,2,3].disjoint([4,5,6])
assert [1,2,3].intersect([4,3,1]) == [3,1]
assert [1,2,3].collect{ it+3 }    == [4,5,6]
assert [1,2,3,1].unique().size()  == 3
assert [1,2,3,1].count(1) == 2
assert [1,2,3,4].min()    == 1
assert [1,2,3,4].max()    == 4
assert [1,2,3,4].sum()    == 10
assert [4,2,1,3].sort()   == [1,2,3,4]
assert [4,2,1,3].findAll{ it%2 == 0 } == [4,2]
def animals = ['cat','kangaroo','koala','dog']
assert animals[2] == 'koala'
def kanimals = animals[1..2]
assert animals.findAll{ it =~ /k.*/ } == kanimals
assert animals.find{ it =~ /k.*/ }    == kanimals[0]
assert animals.grep(~/k.*/)           == kanimals

// parallel assignment as swap
def a = 1, b = 2
(a, b)   = [b, a]
assert a == 2
assert b == 1

// lesser known methods

assert animals.sort    { it.size() } == ['cat', 'dog', 'koala', 'kangaroo']
assert animals.max     { it.size() } == 'kangaroo'
assert animals.groupBy { it.size() } == [ 3:['cat','dog'], 5:['koala'], 8:['kangaroo'] ]

assert [1,2,3].permutations().toList() == [
    [1, 2, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2], [2, 1, 3], [1, 3, 2]
]
assert (1..10).collate(3)  == [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10]]

def matrix = [
    ['a', 'b'],
    [ 1 ,  2 ]
]
assert matrix.transpose()    == [ ['a', 1], ['b', 2] ]
assert matrix.combinations() == [ ['a', 1], ['b', 1], ['a', 2], ['b', 2] ]

