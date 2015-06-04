class CalorieBuilder3 {
  def calorieDatabase = [
      crust    : [thin: 169, classic: 212, deepdish: 259, stuffed: 360],
      topping  : [pepperoni: 24, veggies: 10, cheese: 50],
      appetizer: [wings: 60, 'garlic-bread': 180]
  ]
  def parent = new Stack()
  def getCalories() { parent.peek().calories }

  CalorieBuilder3() {
    parent.push([calories:0.0])
  }

  def invokeMethod(String methodName, args) {
    def current = [name: methodName, calories:0.0]
    if (args && args[0] instanceof Map) {
      current << args[0]
    }
    countCalories(current, parent.peek().name, methodName)
    if (args && args[0] instanceof String) {
      countCalories(current, methodName, args[0])
    }
    if (args && args.size() > 1 && args[1] instanceof String) {
      countCalories(current, methodName, args[1])
    }
    current.scale = current.size == 'large' ? 1.5 : 1.0

    if (args && args[-1] instanceof Closure) {
      parent.push(current)
      Closure nested = args[-1]
      nested.delegate = this
      nested.call()
      parent.pop()
    }
    def qty = current.quantity ?: 1
    def scale = current.scale ?: 1.0
    parent.peek().calories += current.calories * qty * scale
  }

  private void countCalories(Map current, String key, String value) {
    if (calorieDatabase.containsKey(key)) {
      current.calories = calorieDatabase[key][value].toInteger()
    }
  }
}

def lunch = new CalorieBuilder3()

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
