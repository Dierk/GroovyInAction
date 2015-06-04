class FetchOptionsBuilder {
    static FetchOptions fetchOptions(Closure c) {
        def opts = FetchOptions.Builder.withDefaults()
        opts.with c
        return opts
    }
}
