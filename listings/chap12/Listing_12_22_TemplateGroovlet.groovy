def session = request.session
def guess   = params.guess
guess = guess ? guess.toInteger() : null
if (params.restart) guess = null

if (!session.goal || params.restart) {
  session.goal = (Math.random()*100).toInteger()
}

def engine   = new groovy.text.SimpleTemplateEngine()      //#1
def source   = getClass().classLoader.                     //#1
    getResource('Number.template.html')                    //#1
def template = engine.createTemplate(source)               //#1
out << template.make(guess: guess, goal: session.goal)     //#1
//#1 Template rendering code
