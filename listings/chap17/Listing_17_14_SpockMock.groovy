@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.Specification

class Listing_17_14_SpockMock extends Specification {
  def "buy ticket for a movie theater"() {
    given:
    def purchase = new Purchase("Lord of the Rings", 2)
    MovieTheater theater = Mock()                                 //#A
    theater.hasSeatsAvailable("Lord of the Rings", 2) >> true     //#B

    when:
    purchase.fill(theater)

    then:
    purchase.completed
    1 * theater.purchaseTicket("Lord of the Rings", 2)            //#C
  }
}
//#A Creation of mock theater
//#B Mock hasSeatsAvailable call returning true
//#C Assert purchaseTicket has been called 1 time
