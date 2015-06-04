def absComp = [
    compare: { a,b -> a.abs() <=> b.abs() } 
]
def list = [-3, -1, 2]
list.sort(true, absComp as Comparator)
assert list == [-1, 2, -3]