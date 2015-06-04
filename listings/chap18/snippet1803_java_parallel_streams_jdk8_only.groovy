// Groovy with Java 8
def numbers = [1, 2, 3,  4,  5,  6]
assert [1, 4, 9] == numbers.parallelStream()
    .map    { it * it }
    .filter { it < 10 }
    .collect()
