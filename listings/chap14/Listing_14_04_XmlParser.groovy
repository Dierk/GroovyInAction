//@Grab('org.codehaus.groovy:groovy-xml:2.2.0')
def plan = new XmlParser().parse(new File('data/plan.xml'))    // #1

assert plan.name() == 'plan'
assert plan.week[0].name() == 'week'
def firstTask = plan.week[0].task[0]                           // #2
assert firstTask.name() == 'task'
assert firstTask.text() == 'easy'
assert firstTask.@title == 'read XML chapter'

// bonus examples below here for comparison with other listings
assert plan.children().size() == 2
//def firstWeek = plan.children().find { it.name() == 'week' }
//def firstWeek = plan.week[0]
assert firstTask.'@title' == 'read XML chapter'
assert plan.week.task.size() == 5
assert plan.week.task.@done*.toInteger().sum() == 6
assert plan.week[1].task.every{ it.@done == '0' }

assert plan.breadthFirst()*.name().join('->') ==
    'plan->week->week->task->task->task->task->task'
assert plan.depthFirst()*.name().join('->') ==
    'plan->week->task->task->task->week->task->task'
assert plan.'**'*.name().join('->') ==
    'plan->week->task->task->task->week->task->task'
