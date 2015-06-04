def writer = new FileWriter('markup.html')
def html   = new groovy.xml.MarkupBuilder(writer)                                   
html.html {
  head {
    title 'Constructed by MarkupBuilder'
  }
  body {
    h1 'What can I do with MarkupBuilder?'
parent {
  mkp.yield "Some text"
  child('Child text')
  mkp.yield "more text"
}
    form (action:'whatever') {
      for (line in ['Produce HTML','Produce XML','Have some fun']){
        input(type:'checkbox',checked:'checked', id:line, '')
        label(for:line, line)
        br()
} } } }