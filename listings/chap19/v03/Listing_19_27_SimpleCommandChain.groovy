package v03

import v03.model.*
import v03.integration.*
import static v03.model.Direction.right

// listing 19.27
def move(Direction dir) {
    [by: { Distance dist ->
        [at: { Speed speed ->
            println "robot moved $dir by $dist at $speed"
        }]
    }]
}
// end

use(DistanceCategory) {
    def h = Duration.hour
    // listing 19.28
    def map1 = move(right)
    def byClosure = map1['by']
    def map2 = byClosure(3.meters)
    def atClosure = map2['at']
    atClosure(5.km / h)
    // end
    move right by 3.meters at 5.km/h
}