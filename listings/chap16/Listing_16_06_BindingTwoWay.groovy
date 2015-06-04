def binding = new Binding(x: 6, y: 4)                       //#1
def shell = new GroovyShell(binding)
shell.evaluate('''
    xSquare = x * x                                         //#2
    yCube   = y * y * y                                     //#2
''')
assert binding.getVariable("xSquare") == 36                 //#3
assert binding.yCube == 64                                  //#4
//#1 Prepopulating the binding data
//#2 Setting binding data within the evaluated script
//#3 Method access to binding data
//#4 Groovy property access to binding data
