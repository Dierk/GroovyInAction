//@Grab('org.codehaus.groovy:groovy-xml:2.2.0')
def plan = new XmlSlurper().parse(new File('data/plan.xml'))

assert plan.week.task.size() == 5
assert plan.week.task.@done*.toInteger().sum() == 6
assert plan.week[1].task.every{ it.@done == '0' }
assert plan.breadthFirst()*.name().join('->') ==
    'plan->week->week->task->task->task->task->task'
assert plan.depthFirst()*.name().join('->') ==
    'plan->week->task->task->task->week->task->task'
assert plan.depthFirst()*.name() == plan.'**'*.name()

// bonus material below here for comparison with other listings
assert plan.name() == 'plan'
assert plan.children().size() == 2

def firstWeek = plan.children().find { it.name() == 'week' }
def firstTask = firstWeek.task[0]
assert firstTask.name() == 'task'
assert firstTask.text() == 'easy'
assert firstTask.'@title' == 'read XML chapter'
