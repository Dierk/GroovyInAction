html.html{
  head {
    title 'Groovlet Demonstrator'
  }
  body {
    h1 'Variables in the Binding:'
    table(summary:'binding') {
      tbody {
        binding.variables.each { key, value ->
          tr {
            td key.toString()
            td(value ? value.toString() : 'null')
} } } } } }
