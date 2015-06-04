//@Grab('org.codehaus.groovy:groovy-templates:2.2.0')
import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory
import groovy.text.SimpleTemplateEngine as STE

import javax.xml.xpath.XPathFactory
import static javax.xml.xpath.XPathConstants.NODESET
import static javax.xml.xpath.XPathConstants.NUMBER

def doc  = DOMBuilder.parse(new FileReader('data/plan.xml'))
def plan = doc.documentElement
def xpath = XPathFactory.newInstance().newXPath()

def binding = [scale:1, weeks:[] ]
use(DOMCategory) {
  xpath.evaluate('//week', plan, NODESET).each{ week ->     //#1
    binding.weeks << [
      total:   (int) xpath.evaluate('sum(task/@total)', week, NUMBER),
      done:    (int) xpath.evaluate('sum(task/@done)', week, NUMBER),
      capacity: week.'@capacity'.toInteger()
    ]
  }
}
def max = binding.weeks.capacity.max()                      //#2
if (max > 0) binding.scale = 200.intdiv(max)

def templateFile = new File('data/GroovyPlans.template.html')
def template     = new STE().createTemplate(templateFile)   //#3

new File('data/XPathGroovyPlans.html').withWriter {
  it << template.make(binding)
}