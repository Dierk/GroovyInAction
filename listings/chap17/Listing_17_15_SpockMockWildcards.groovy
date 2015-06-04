@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.Specification

class Listing_17_15_SpockMockWildcards extends Specification {
  def "cannot buy a ticket when the movie is sold out"() {
    given:
    def purchase = new Purchase("Lord of the rings", 2)
    MovieTheater theater = Mock()

    when:
    theater.hasSeatsAvailable(_, _) >> false               //#A
    purchase.fill(theater)

    then:
    !purchase.completed
    0 * theater.purchaseTicket(_, _)                       //#B
  }
}
//#A Mock hasSeatsAvailable call, any args, return false
//#B The purchaseTicket method has not been called


