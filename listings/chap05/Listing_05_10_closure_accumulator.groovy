def foo(n) {
    return { n += it }
}

def accumulator = foo(1)
assert accumulator(2) == 3
assert accumulator(1) == 4