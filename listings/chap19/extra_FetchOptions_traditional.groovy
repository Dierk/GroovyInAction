
def options = FetchOptions.Builder.withLimit(10).offset(60).chunkSize(1000)
println options
