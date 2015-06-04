def binding = new Binding(multiply: { a, b -> a * b })       //#A
def shell = new GroovyShell(binding)
def value = shell.evaluate('''
    multiply(5, 6)                                           //#B
''')
assert value == 30
//#A Create closure within the binding
//#B Call the closure like a normal method
