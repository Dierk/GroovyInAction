import groovyx.gpars.agent.Agent

def guard = new Agent<String>()

guard { updateValue 'GPars' }
guard { updateValue(it + ' is groovy!') }

assert "GPars is groovy!" == guard.val