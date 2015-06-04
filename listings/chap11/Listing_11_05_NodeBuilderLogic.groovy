TimeZone.default = TimeZone.getTimeZone("CET")                 //#A

def builder = new NodeBuilder()
def invoices = builder.invoices {
  for (day in 1..3) {                                          //#B
    def invDate = Date.parse('yyyy-MM-dd', "2015-01-0$day")
    invoice(date: invDate) {                                   //#1
      item(count: day) {                                       //#1
        product(name: 'ULC', dollar: 1499)                     //#1
      }                                                        //#1
    }                                                          //#1
  }
}

def writer = new StringWriter()
invoices.print(new PrintWriter(writer))                        //#C

assert writer.toString() == """\
invoices() {
  invoice(date:Thu Jan 01 00:00:00 CET 2015) {
    item(count:1) {
      product(name:'ULC', dollar:1499)
    }
  }
  invoice(date:Fri Jan 02 00:00:00 CET 2015) {
    item(count:2) {
      product(name:'ULC', dollar:1499)
    }
  }
  invoice(date:Sat Jan 03 00:00:00 CET 2015) {
    item(count:3) {
      product(name:'ULC', dollar:1499)
    }
  }
}
"""
//#A Set timezone for consistent Date toString() values in test
//#B Loop over 3 days
//#1 Code for building a single invoice
//#C Print to a StringWriter for testing
