trait HasId { //#1
  long id
}
trait HasVersion {
  long version
}
trait Persistent {
  boolean save() { println "saving ${this.dump()}" }
}
trait Entity implements Persistent, HasId, HasVersion { //#2
  boolean save() {
    version++
    Persistent.super.save() //#3
  }
}

class Publication implements Entity { //#4
  String title
}

class Book extends Publication {
  String isbn
}

Entity gina = new Book(id:1, version:1, title:"gina", isbn:"111111")
gina.save()
assert gina.version == 2
//#1 Defining a trait with state
//#2 Traits can use subtyping
//#3 Use specific methods
//#4 Implementing the trait
