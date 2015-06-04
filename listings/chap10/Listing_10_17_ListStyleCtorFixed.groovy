import groovy.transform.*

@TupleConstructor
class Author {
  String first
  String last
  int born
}

@TypeChecked
Author createAuthor(List params) {
  if (params.size() != 3) {
    throw new IllegalArgumentException('Incorrect number of arguments')
  }
  String first = params[0]                      //#A
  String last = params[1]                       //#A
  Integer age = (Integer) params[2]             //#B
  Author a = [first, last, age]                 //#C
  a
}

assert createAuthor(['Agatha', 'Christie', 1890]).born == 1890
//#A no need to cast as String on LHS
//#B Cast required
//#C Passes
