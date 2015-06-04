import groovy.transform.ToString

@ToString(includeNames = true, ignoreNulls = true)
class Sleuth {
  String firstName, lastName
}

def nancy = new Sleuth(firstName: 'Nancy', lastName: 'Drew')
assert nancy.toString() == 'Sleuth(firstName:Nancy, lastName:Drew)'
nancy.lastName = null
assert nancy.toString() == 'Sleuth(firstName:Nancy)'
