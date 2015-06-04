def shell = new GroovyShell()
def result = shell.evaluate("12 + 23")
assert result == 35
