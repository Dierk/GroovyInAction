class CalorieBuilder2 extends FactoryBuilderSupport {
  def calories = 0.0
  def factory = new CalorieBeanFactory(getClass().classLoader)

  protected void postInstantiate(name, Map attrs, node) {
    super.postInstantiate(name, attrs, node)
    attrs.each { k, v -> node[k] = v }
  }

  protected Factory resolveFactory(name, Map attrs, value) {
    return factory
  }

  void setParent(parent, child) {
    if (child.hasProperty("size")) {
      child.scale = child.size == 'large' ? 1.5 : 1.0
    }
  }

  void nodeCompleted(parentOrNull, node) {
    def parent = parentOrNull ?: this
    def qty = node.quantity ?: 1
    def scale = node.scale ?: 1.0
    parent.calories += node.calories * qty * scale
  }
}

class CalorieBeanFactory extends AbstractFactory {
  private ClassLoader loader

  CalorieBeanFactory(ClassLoader loader) {
    this.loader = loader
  }

  def newInstance(FactoryBuilderSupport fbs, name, value, Map attrs) {
    def className = name[0].toUpperCase() +
        name[1..-1].replaceAll(/-(.)/) { it[1].toUpperCase() }
    def clazz = loader.loadClass(className)
    return value ? clazz.newInstance(value: value) : clazz.newInstance()
  }
}

class Countable {
  int quantity
  def scale
  def calories = 0.0
}

class Count extends Countable {}

class Pizza extends Countable {
  def size
}

abstract class CountableGroup extends Countable {
  String value

  abstract getCalorieDB()

  def getCalories() { calorieDB[value] }
}

class Crust extends CountableGroup {
  def calorieDB = [thin: 169, classic: 212, deepdish: 259, stuffed: 360]
}

class Topping extends CountableGroup {
  def calorieDB = [pepperoni: 24, veggies: 10, cheese: 50]
}

class Appetizer extends Countable {}

class Wings extends Countable {
  def calories = 60
}

class GarlicBread extends Countable {
  def calories = 180
}

def lunch = new CalorieBuilder2()

lunch.count {
  pizza(size: 'large') {
    crust('thin')
    topping('pepperoni')
    topping('veggies')
  }
  appetizer {
    wings(quantity: 2)
    'garlic-bread'()
  }
}

assert lunch.calories == 604.5
