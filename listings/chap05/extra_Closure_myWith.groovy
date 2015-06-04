def with(Closure doit) {  // fake implementation
    doit.delegate = list
    doit()
}