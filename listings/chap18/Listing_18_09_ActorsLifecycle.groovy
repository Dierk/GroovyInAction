import static groovyx.gpars.actor.Actors.*

def stopper = reactor { stop() }
stopper.metaClass.afterStop = { inbox -> println inbox }
stopper.send()