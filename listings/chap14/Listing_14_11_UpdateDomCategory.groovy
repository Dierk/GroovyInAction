//@Grab('org.codehaus.groovy:groovy-xml:2.2.0')

import groovy.xml.DOMBuilder
import groovy.xml.XmlUtil
import groovy.xml.dom.DOMCategory

def doc = DOMBuilder.parse(new FileReader('data/plan.xml'))
def plan = doc.documentElement

use(DOMCategory) {
  plan.week[0].task[2]['@done'] = '2'                     // #1
  plan.week[0].task[2].value = 'time saver'               // #2

  plan.week[1].task[1].replaceNode {
    task(done:'0', total:'4', title:'build web service')
  }
// an alternative to replace node is remove then append
//  def oldTask = plan.week[1].task[1]
//  plan.week[1].removeChild(oldTask)
//  plan.week[1].appendNode('task', [done:'0', total:'4',
//      title:'build web service'])

//  plan.week[1].appendNode('task', [done:'0', total:'1',
//      title:'build web service client'])
    plan.week[1].task[1] + {
      task(done:'0', total:'1', title:'build web service client')
    }
}

UpdateChecker.check(XmlUtil.serialize(plan))
