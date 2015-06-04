import groovy.transform.TypeChecked

class Address { String country }
class WishList { List<String> items }

def validate(@DelegatesTo.Target def o, @DelegatesTo Closure rule) { //#1
  rule.delegate = o
  rule()
}

@TypeChecked
void validateAll() {
  def a = new Address(country: 'Australia')
  validate(a) {                                           //#2
    if (country[0] == 'X')                                //#3
      println 'No countries start with that'
  }
  def wl = new WishList(items: ['iphone', 'iphone'])
  validate(wl) {                                          //#4
    if (items != items.toUnique())                        //#5
      println 'Some item appeared twice'
  }
}

validateAll()
//#1 Compiler will determine type
//#2 First param is Address
//#3 Address inferred so country will be found
//#4 First param is WishList
//#5 WishList inferred so items will be found
