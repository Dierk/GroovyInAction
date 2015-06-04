//@Grab('org.codehaus.groovy:groovy-xml:2.2.0')
import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory

def doc = DOMBuilder.parse(new FileReader('data/plan.xml'))
def plan = doc.documentElement

use(DOMCategory) {
  assert plan.name() == 'plan'                                  //|#1
  assert plan.week[0].name() == 'week'                          //|#1
  assert plan.week[0].'@capacity' == '8'                        // #2
  assert plan.week.task[0].name() == 'task'
  assert plan.week.task[0].text() == 'easy'                     // #3

  // bonus material below here for comparative purposes with later examples
  assert plan.week.task.size() == 5
  assert plan.week.task.'@done'*.toInteger().sum() == 6
  assert plan.week[1].task.every{ it.'@done' == '0' }

// For legacy reasons, text nodes are regarded as children by
// DOMCategory which yields slightly different code than for XmlParser
// and XmlSlurper when using breadthFirst() and children() though
// depthFirst() avoids these differences as it was introduced later
  def elementNames = { it.nodeName.startsWith('#') ? [] : [it.name] }
  assert plan.breadthFirst().iterator().collectMany(elementNames).join('->') ==
      'plan->week->week->task->task->task->task->task'
  assert plan.depthFirst()*.name().join('->') ==
      'plan->week->task->task->task->week->task->task'
  assert plan.'**'*.name().join('->') ==
      'plan->week->task->task->task->week->task->task'
}
