def session = request.session
def guess   = params.guess
guess = guess ? guess.toInteger() : null
if (params.restart) guess = null

if (!session.goal || params.restart) {               //#A
    session.goal = (Math.random()*100).toInteger()   //#A
}                                                    //#A
def goal = session.goal

html.html{ head { title 'Think of a Number'  }             //#B
    body {
        h1 'Think of a Number'
        if (goal && guess) {
            div "Your guess $guess is "                    //#C
            switch (guess) {
                case goal        : div 'correct!'; break   //#D
                case {it < goal} : div 'too low' ; break   //#D
                case {it > goal} : div 'too high'; break   //#D
            }
        }
        p "What's your guess (0..100)?"
        form(action:'Listing_12_20_HiLowGame.groovy'){          //#E
            input(type:'text', name:'guess', '')
            button(type:'submit', 'Guess')
            button(type:'submit', name:'restart', value:'true',
                'New Game')
}   }   }
//#A Generate a number to guess, if necessary
//#B Start a builder to generate the HTML
//#C Use a GString as a simple template for text
//#D Classify the guess appropriately
//#E Display a form posting to the same page again
