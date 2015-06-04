import groovy.transform.TupleConstructor

@TupleConstructor
class Purchase {
  def name, number, completed = false

  def fill(theater) {
    if (theater.hasSeatsAvailable(name, number)) {
      theater.purchaseTicket(name, number)
      completed = true
    }
  }
}
