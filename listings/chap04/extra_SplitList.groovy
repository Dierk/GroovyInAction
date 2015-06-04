def list = [0, 3, 2, 1]
def (small, big) = list.split { it < 2 }
assert small == [0, 1]
assert big   == [3, 2]

def group = list.groupBy { it % 2 }
assert group[0] == [0, 2]
assert group[1] == [3, 1]
