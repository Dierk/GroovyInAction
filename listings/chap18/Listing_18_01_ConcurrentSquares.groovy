import static groovyx.gpars.GParsPool.withPool

def numbers = [1, 2, 3,  4,  5,  6]
def squares = [1, 4, 9, 16, 25, 36]

withPool {
   assert squares == numbers.collectParallel  { it * it }
}