import groovy.transform.TypeChecked

@TypeChecked                                                  //#A
class Sleuth {
  String firstName
  String lastName

  String getFullName() { "$firstName $lastName" }
}

assert new Sleuth(firstName: 'Nancy',
                   lastName: 'Drew').fullName == 'Nancy Drew'
//#A Class annotation