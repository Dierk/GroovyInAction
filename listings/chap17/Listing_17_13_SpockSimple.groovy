@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.Specification

class GivenWhenThenSpec extends Specification {

  def "test adding a new item to a set"() {
    given:
    def items = [4, 6, 3, 2] as Set

    when:
    items << 1

    then:
    items.size() == 5
  }
}
