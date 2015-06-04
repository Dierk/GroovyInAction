class Duck {
  def methodMissing(String name, args) {
    println "$name!"
  }
}

def duck = new Duck()
duck.quack()
