//@Grab('org.codehaus.groovy:groovy-xml:2.2.0')
import groovy.xml.MarkupBuilder

void numberfy(Node node) {                           //#1
  def atts = node.attributes()
  atts.keySet().grep(['capacity', 'total', 'done']).each {
    atts[it] = atts[it].toInteger()
  }
  node.each { if (it instanceof Node) numberfy(it) }
}

void taskStatus(task) {                              //#2
  def atts = task.attributes()
  switch (atts.done) {
    case 0: atts.status = 'scheduled'; break
    case 1..<atts.total: atts.status = 'in progress'; break
    default: atts.status = 'finished';
  }
}

void weekStatus(week) {                              //#3
  week.task.each { taskStatus(it) }
  def atts = week.attributes()
  atts.status = 'scheduled'
  if (week.task.every { it.@status == 'finished'})
    atts.status = 'finished'
  if (week.task.any { it.@status == 'in progress'})
    atts.status = 'in progress'
}

void htmlReport(builder, plan) {                     //#4
  builder.html {
    head {
      title('Current Groovy progress')
      link(rel: 'stylesheet',
          type: 'text/css',
          href: 'style.css')
    }
    body {
      plan.week.eachWithIndex { week, i ->
        h1("Week No. $i: ${week.@status}")
        dl {
          week.task.each { task ->
            dt(class: task.@status, task.@title)
            dd("(${task.@done}/${task.@total}): ${task.@status}")
} } } } } }

def node = new XmlParser().parse(new File('data/plan.xml'))
numberfy(node)                                       //#|5
node.week.each { weekStatus(it) }                    //#|5

new File('data/GroovyPlans.html').withWriter { writer ->
  def builder = new MarkupBuilder(writer)
  htmlReport(builder, node)
}
