import groovy.transform.Canonical

@Canonical
class Country {
  String name
}

@Canonical
class City {
  String name
  String zipCode
  Country country
}

@Newify([City, Country])
def paris = City('Paris', '75000', Country('France'))

assert paris.toString() == 'City(Paris, 75000, Country(France))'
