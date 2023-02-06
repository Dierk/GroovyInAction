@Grab(group='org.ccil.cowan.tagsoup', module='tagsoup', version='1.2')
import org.ccil.cowan.tagsoup.Parser

def parser = new groovy.xml.XmlParser(new Parser())
def html = parser.parse("https://manning.com/koenig2")

def twitterUrls = html.body.'**'.a.@href.grep(~/.*twitter.*/)
println twitterUrls.join("\n")

assert 'https://twitter.com/manningbooks' in twitterUrls
