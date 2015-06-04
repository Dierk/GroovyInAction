def binding = new Binding()                //#1
binding.mass = 22.3                        //#1
binding.velocity = 10.6                    //#1

def shell = new GroovyShell(binding)                       //#2
def expression = "mass * velocity ** 2 / 2"                //#2
assert shell.evaluate(expression) == 1252.814              //#2

binding.setVariable("mass", 25.4)                          //#3
assert shell.evaluate(expression) == 1426.972              //#3
//#1 Create and populate the binding
//#2 Evaluate the expression using the binding
//#3 Change the binding data and re-evaluate
