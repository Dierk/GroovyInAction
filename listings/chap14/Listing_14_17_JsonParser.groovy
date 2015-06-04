//@Grab('org.codehaus.groovy:groovy-json:2.2.0')
import groovy.json.JsonSlurper

// add .newReader() to the file in Groovy versions prior to 2.2.0
def plan = new JsonSlurper().parse(new File('data/plan.json'))
assert plan.weeks[0].tasks[0].status == 'easy'
assert plan.weeks[1].capacity == 8
assert plan.weeks[1].tasks[0].title == 're-read DB chapter'
