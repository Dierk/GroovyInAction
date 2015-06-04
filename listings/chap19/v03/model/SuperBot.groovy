package v03.model

class SuperBot extends Robot {
  def move(Direction dir) {
    [by: { Distance dist ->
      [at: { Speed s ->
        println "robot moved $dir by $dist at $s"
      }]
    }]
  }

  def deploy(Direction dir) {
    [arm: { -> println "deploy $dir arm" }()]
  }
}
