import groovy.transform.TypeChecked

class Actor {
  String firstName, lastName

  @TypeChecked
  String getFullName() { "$firstName $lastName" }         //#1

  void makePeace() {
    new AntBuilder().echo('Peace was never an option')    //#2
  }
}

def magneto = new Actor(firstName: 'Ian', lastName: 'McKellen')
assert magneto.fullName == 'Ian McKellen'
magneto.makePeace()
//#1 Checked
//#2 Dynamic features allowed
