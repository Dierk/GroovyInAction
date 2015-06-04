package v02

import v02.model.Robot

def shell = new GroovyShell(this.class.classLoader)

// assumes script is run from parent directory
shell.evaluate 'v02/CommandScript.groovy' as File

// assumes script is on the classpath
def script = Robot.getResource("/v02/CommandScript.groovy")
shell.evaluate new File(script.toURI())
