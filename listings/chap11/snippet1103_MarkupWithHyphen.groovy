def writer = new StringWriter()
def builder = new groovy.xml.MarkupBuilder(writer)

def web = builder.'web-app' {
    builder.'display-name'('Groovy WebApp')
}    

def result = writer.toString().replaceAll("\r","")
 
assert "\n"+result == """
<web-app>
  <display-name>Groovy WebApp</display-name>
</web-app>"""   