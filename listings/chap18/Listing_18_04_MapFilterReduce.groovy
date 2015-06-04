import static groovyx.gpars.GParsPool.withPool

withPool {
    assert 55 == [0, 1, 2, 3, 4].parallel
        .map    { it + 1  }
        .map    { it ** 2 }
        .reduce { a, b -> a + b }
}