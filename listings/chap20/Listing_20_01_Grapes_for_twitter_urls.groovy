@Grab(group='org.ccil.cowan.tagsoup', module='tagsoup', version='1.2')
import org.ccil.cowan.tagsoup.Parser

def parser = new XmlParser(new Parser())
def html = parser.parse("http://manning.com/koenig2")

def twitterUrls = html.body.'**'.a.@href.grep(~/.*twitter.*/)
println twitterUrls.join("\n")

assert 'http://www.twitter.com/mittie' in twitterUrls