import static groovyx.gpars.GParsPool.withPool

withPool {
    def numbers = [1, 2, 3,  4,  5,  6].makeConcurrent()
    def squares = [1, 4, 9]
    assert squares == numbers.collect{ it * it }.grep{ it < 10 }
}