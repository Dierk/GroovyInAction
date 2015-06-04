import groovy.transform.TypeChecked

interface Flying {
  void fly()
}

class Bird implements Flying {
  void fly() { println "I'm flying!" }
}

class Canary extends Bird {
  void sing() { println "Tweet!" }
}

@TypeChecked
void main() {
  def o = new Bird()
  o.fly()                        //#1
  o = new Canary()
  o.fly()                        //#2
  o.sing()                       //#2
//  o = new Bird()
//  o.sing()                //#A
}

main()
//#1 a bird can fly
//#2 a canary can fly too and also sing
//#A Would fail compilation
