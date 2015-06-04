def monthly = "amount*(rate/12) / (1-(1+rate/12)**-numberOfMonths)"

def shell = new GroovyShell()
def script = shell.parse(monthly)                         //#A

script.binding.amount = 154000                            //#B
script.rate = 3.75/100                                    //#C
script.numberOfMonths = 240

assert script.run() == 913.0480050387338

script.binding = new Binding(amount: 185000,              //|#D
                              rate: 3.50/100,             //|#D
                              numberOfMonths: 300)        //|#D

assert script.run() == 926.1536089487843
//#A Parse formula into reusable script
//#B Access binding variable
//#C Access binding variable using shorthand
//#D Create new binding
