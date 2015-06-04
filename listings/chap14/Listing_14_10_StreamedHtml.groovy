//@Grab('org.codehaus.groovy:groovy-xml:2.2.0')
import groovy.xml.StreamingMarkupBuilder

def taskStatus(task) {                                       //#1
  switch (task.@done.toInteger()) {
    case 0: return 'scheduled'
    case 1..<task.@total.toInteger(): return 'in progress'
    default: return 'finished'
  }
}

def weekStatus(week) {                                       //#2
  if (week.task.every { taskStatus(it) == 'finished' })
    return 'finished'
  if (week.task.any { taskStatus(it) == 'in progress' })
    return 'in progress'
  return 'scheduled'
}

def plan = new XmlSlurper().parse(new File('data/plan.xml')) //#3

Closure markup = {                                           //#4
  html {
    head {
      title('Current Groovy progress')
      link(rel: 'stylesheet',
          type: 'text/css',
          href: 'style.css')
    }
    body {
      plan.week.eachWithIndex { week, i ->
        h1("Week No. $i: ${owner.weekStatus(week)}")
        dl {
          week.task.each { task ->
            def status = owner.taskStatus(task)
            dt(class: status, task.@title)
            dd("(${task.@done}/${task.@total}): $status")
} } } } } }

def heater = new StreamingMarkupBuilder().bind(markup)       //#5
def outfile = new File('data/StreamedGroovyPlans.html')
outfile.withWriter{ it << heater }                           //#6
