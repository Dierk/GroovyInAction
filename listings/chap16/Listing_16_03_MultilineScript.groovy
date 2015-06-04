def shell = new GroovyShell()
def kineticEnergy = shell.evaluate('''
    def mass = 22.3
    def velocity = 10.6
    mass * velocity**2 / 2
''')
assert kineticEnergy == 1252.814
