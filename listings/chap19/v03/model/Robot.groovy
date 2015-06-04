package v03.model

class Robot {
  def move(Direction dir) {
    println "robot moved $dir"
  }

  def move(Direction dir, Distance d) {
    println "robot moved $dir by $d"
  }

  def move(Map m, Direction dir) {
    println "robot moved $dir by $m.by at ${m.at ?: '1 km/h'}"
  }
}
