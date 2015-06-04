import groovy.json.JsonBuilder

def builder = new JsonBuilder()
builder {
  invoices(1..3) { day ->                                       //#1
    invoice(date: "2015-01-0$day") {                            //#2
      item(count: day) {                                        //#2
        product(name: 'ULC', dollar: 1499)                      //#2
      }                                                         //#2
    }                                                           //#2
  }
}

assert builder.toPrettyString().startsWith(                     //#3
'''{
    "invoices": [
        {
            "invoice": [
                {
                    "date": "2015-01-01"
''')
//#1 Pretended method can take collection and Closure
//#2 Closure defines JSON for each item in collection
//#4 Check the start of pretty output