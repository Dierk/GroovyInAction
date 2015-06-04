import static groovyx.gpars.actor.Actors.*

def manual = reactor { message ->
    switch (message) {                          //#1
        case Number: reply 'number'; break
        case String: reply 'string'; break
    }
}

def auto = messageHandler {
    when { String message -> reply 'string' }   //#2
    when { Number message -> reply 'number' }
}
//#1 Self-made dispatch
//#2 Groovy method dispatch
