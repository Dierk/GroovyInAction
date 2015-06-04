def mult  = { x, y -> return x * y }
def twoTimes = mult.curry(2)
assert twoTimes(5) == 10

def fourTimes  = twoTimes >> twoTimes
def eightTimes = twoTimes << fourTimes

assert eightTimes(1) == twoTimes(fourTimes(1))