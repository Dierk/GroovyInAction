class CalorieBuilder1 extends BuilderSupport {
  def calories = 0.0
  def name = 'root'
  def calorieDatabase = [
      crust    : [thin: 169, classic: 212, deepdish: 259, stuffed: 360],
      topping  : [pepperoni: 24, veggies: 10, cheese: 50],
      appetizer: [wings: 60, 'garlic-bread': 180]
  ]

  def createNode(name) {
    [name: name, calories: 0.0]
  }

  def createNode(name, value) {
    def result = createNode(name) + [value: value]
    findCalories(result, name, value)                      //#1
    result
  }

  def createNode(name, Map attributes) {
    createNode(name) + [*: attributes]
  }

  def createNode(name, Map attributes, value) {
    createNode(name, value) + [*: attributes]
  }

  void setParent(parent, child) {
    if (child.size && parent.size && child.size != parent.size) //#2
      throw new IllegalStateException("Conflicting sizes found")
    if (child.size) {
      child.scale = (child.size == 'large') ? 1.5 : 1.0
    }
  }

  void nodeCompleted(parentOrNull, node) {
    def parent = parentOrNull ?: this
    def qty = node.quantity ?: 1
    def scale = node.scale ?: 1.0
    findCalories(node, parent.name, node.name)             //#3
    parent.calories += node.calories * qty * scale
  }

  private void findCalories(Map map, name, value) {
    if (calorieDatabase.containsKey(name)) {
      map.calories = calorieDatabase[name][value].toInteger()
    }
  }

  }

def lunch = new CalorieBuilder1()

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
//#1 Handle cases like crust('thin')
//#2 Check consistency between child and parent
//#3 Handle cases like appetizer { wings() }
