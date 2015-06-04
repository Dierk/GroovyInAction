import static groovyx.gpars.GParsPool.withPool

withPool {
    def numbers = [1, 2, 3,  4,  5,  6]
    assert [1, 4, 9] == numbers.parallel
        .map    { it * it }
        .filter { it < 10 }
        .collection
}