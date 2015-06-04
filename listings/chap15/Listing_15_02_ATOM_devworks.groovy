//@Grab('org.codehaus.groovy:groovy-xml:2.2.0')
import groovy.xml.Namespace

def url = 'http://www.ibm.com/developerworks/views/java/rss/' +
    'libraryview.jsp?feed_by=atom'
def atom = new Namespace('http://www.w3.org/2005/Atom')
def numEntries = 3                                                  //#A
def entries = new XmlParser().parse(url)[atom.entry][0..<numEntries]
def len = "dd mmm yyyy ".size()                                     //#B
def summaries = entries.collect {
  it[atom.published].text()[0..<len] +
      (it[atom.summary].text().contains('Groovy') ? '*' : ' ') +
      it[atom.title].text()
}
println summaries.join("\n")
//#A show latest 3 entries
//#B chop published date after this many chars
/*
<feed xmlns="http://www.w3.org/2005/Atom" xml:lang="en">
...
  <entry>
    <title>Java.next: The Java.next languages</title>
    <summary>
    A new developerWorks series by Neal Ford that performs a deep comparison
    of three next-generation JVM languages: Groovy, Scala, and Clojure...
    </summary>
    <published>29 Jan 2013 05:00:00 +0000</published>
    ...
  </entry>
...
 */
/*
26 Feb 2013  Test automation and continuous integration with STAF/STAX
05 Feb 2013  HTML5 2D game development: Manipulating time, Part 1
29 Jan 2013 *Java.next: The Java.next languages
29 Jan 2013  Functional thinking: Why functional programming is on the rise
15 Jan 2013  Look-ahead Java deserialization
08 Jan 2013  HTML5 2D game development: Implementing Sprite behaviors
08 Jan 2013  Agile DevOps: Continuous software delivery in the cloud
19 Dec 2012 *Functional thinking: Laziness, Part 2
*/
