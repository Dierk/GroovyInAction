import groovy.transform.ToString

@ToString
class Car {
  String make
  String model
}

@Newify
def car = Car.new(make: 'Porsche', model: '911')

assert car.toString() == 'Car(Porsche, 911)'
