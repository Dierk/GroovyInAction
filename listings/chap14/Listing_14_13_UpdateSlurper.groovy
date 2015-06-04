//@Grab('org.codehaus.groovy:groovy-xml:2.2.0')
import groovy.xml.XmlUtil

def plan = new XmlSlurper().parse(new File('data/plan.xml'))

plan.week[0].task[2].@done = '2'
plan.week[0].task[2] = 'time saver'

plan.week[1].task[1].replaceNode {
  task(done:'0', total:'4', title:'build web service')
}
//plan.week[1].appendNode {
//  task(done:'0', total:'1', title:'build web service client')
//}
plan.week[1].task[1] + {
  task(done:'0', total:'1', title:'build web service client')
}
//plan.week[1] << {
//  task(done:'0', total:'1', title:'build web service client')
//}

UpdateChecker.check(XmlUtil.serialize(plan))
