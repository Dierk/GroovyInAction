//@Grab('org.codehaus.groovy:groovy-xml:2.2.0')
def base = 'http://news.bbc.co.uk/rss/newsonline_uk_edition/'
def url = base + 'front_page/rss091.xml'

println 'The top three news today:'
def items = new XmlParser().parse(url).channel[0].item
for (item in items[0..2]) {
  println item.title.text()
  println item.link.text()
  println item.description.text()
  println '----'
}
/*
The top three news today:
Three Britons killed in balloon crash
http://www.bbc.co.uk/news/uk-21588495...
Three Britons are dead and another is in hospital...
----
Europe jitters over Italy deadlock
http://www.bbc.co.uk/news/world-europe-21587123...
European politicians and markets react anxiously after Italy's general election...
----
Russia meteor's origin tracked down
http://www.bbc.co.uk/news/science-environment-21579422...
Astronomers trace origin of meteor that broke up over Russia earlier this month...
----
*/
/*
<rss version="2.0" ...>
  ...
    <item>
      <title>Three Britons killed in balloon crash</title>
      <description>Three Britons are dead and another is in hospital...</description>
      <link>http://www.bbc.co.uk/news/uk-21588495...</link>
      <pubDate>Tue, 26 Feb 2013 13:20:07 GMT</pubDate>
      ...
    </item>
...
*/
