final class FetchOptions {                           //#2
  private int limit, offset, chunkSize, prefetchSize

  private FetchOptions() {}                          //#3

  FetchOptions limit(int lim) {
    this.limit = lim
    return this                                      //#1
  }

  FetchOptions offset(int offs) {
    this.offset = offs
    return this
  }

  FetchOptions chunkSize(int cs) {
    this.chunkSize = cs
    return this
  }

  FetchOptions prefetchSize(int ps) {
    this.prefetchSize = ps
    return this
  }

  static final class Builder {                       //#5
    private Builder() {}                             //#6
    static FetchOptions withDefaults() {             //#4
      new FetchOptions()                             //#4
    }

    static FetchOptions withLimit(int lim) {         //#7
      new FetchOptions().limit(lim)
    }

    static FetchOptions withOffset(int offs) {
      new FetchOptions().offset(offs)
    }

    static FetchOptions withChunkSize(int cs) {
      new FetchOptions().chunkSize(cs)
    }

    static FetchOptions withPrefetchSize(int ps) {
      new FetchOptions().prefetchSize(ps)
    }
  }
}
//#1 Enable chaining
//#2 Non-extensible class
//#3 Private constructor
//#4 Default factory method
//#5 Non-extensible class
//#6 Private constructor
//#7 One of several specialized factory methods
