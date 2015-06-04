import groovy.transform.builder.Builder

@Builder
class Chemist {
  String first
  String last
  int born
}

def builder = Chemist.builder()                                 //#1
def c = builder.first("Marie").last("Curie").born(1867).build() //#2
assert c.first == "Marie"
assert c.last == "Curie"
assert c.born == 1867
//#1 Accessing a builder instance
//#2 Fluent API style instance creation
