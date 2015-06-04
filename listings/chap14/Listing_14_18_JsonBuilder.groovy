//@Grab('org.codehaus.groovy:groovy-json:2.2.0')
import groovy.json.JsonBuilder

def builder = new JsonBuilder()
builder.weeks {
  capacity '8'
  tasks(
    [{
      done '0'
      total '4'
      title 'build web service'
    }, {
      done '0'
      total '1'
      title 'build web service client'
    }]
  )
}

assert builder.toString() == '{"weeks":{"capacity":"8","tasks":[' +
    '{"done":"0","total":"4","title":"build web service"},' +
    '{"done":"0","total":"1","title":"build web service client"}' +
    ']}}'
