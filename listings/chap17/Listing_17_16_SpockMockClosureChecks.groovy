@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.Specification

class Listing_17_16_SpockMockClosureChecks extends Specification {
  def "on couples night tickets are sold in pairs"() {
    given:
    def purchase = new Purchase("Lord of the Rings", 2)
    MovieTheater theater = Mock()
    theater.hasSeatsAvailable("Lord of the Rings", 2) >> true

    when:
    purchase.fill(theater)

    then:
    1 * theater.purchaseTicket(_, { it % 2 == 0 })            //#1
  }
}
//#1 Closure argument checking

