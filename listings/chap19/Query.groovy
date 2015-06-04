class Query {
  static query(Closure c) {                              //#1
    def q = c.clone()                                    //#2
    q.resolveStrategy = Closure.DELEGATE_FIRST           //#2
    q.delegate = new Query()                             //#2
    q()                                                  //#2
  }

  def getProperty(String name) { name }                  //#3

  Query select(column)   { this }                        //#4
  Query from(table)      { this }                        //#4
  Query where(condition) { this }                        //#4
}
//#1 DSL entry point
//#2 Define delegate and resolution strategy
//#3 Trivial implementation of property resolution
//#4 Enable method chaining
