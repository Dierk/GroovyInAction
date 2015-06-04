def binding = new Binding(distance: 11400, time: 5 * 60)  //#1

def shell = new GroovyShell(binding)        //#2
shell.evaluate '''
    speed = distance / time                 //#3
'''

assert binding.distance == 11400            //#4
assert binding.time == 5 * 60               //#4
assert binding.speed == 38                  //#5
//#1 Create and populate binding
//#2 Pass binding to GroovyShell
//#3 Calculation only involving binding variables
//#4 Input variables unchanged
//#5 Result also in binding
