@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

import static Converter.celsius

class Listing_17_17_SpockDataDriven extends Specification {
  @Unroll
//  def "test temperature scenarios"() {
    def "Scenario #scenario: #tempFºF should convert to #tempCºC"() {
    expect:
    celsius(tempF) == tempC

    where:
    scenario                  | tempF || tempC
    'Freezing'                |    32 ||     0
    'Garden party conditions' |    68 ||    20
    'Beach conditions'        |    95 ||    35
    'Boiling'                 |   212 ||   100
  }
}
