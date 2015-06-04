def builder = new NodeBuilder()                            //#1
def ulcDate = Date.parse('yyyy-MM-dd', "2015-01-01")
def otherDate = Date.parse('yyyy-MM-dd', '2015-02-02')
def invoices = builder.invoices {                          //#2
  invoice(date: ulcDate) {                                 //#3
    item(count: 5) {
      product(name: 'ULC', dollar: 1499)
    }
    item(count: 1) {
      product(name: 'Visual Editor', dollar: 499)
    }
  }
  invoice(date: otherDate) {
    item(count: 4) {
      product(name: 'Visual Editor', dollar: 499)
    }
  }
}

soldAt = invoices.grep {                                   //#4
  it.item.product.any { it.'@name' == 'ULC' }              //#4
}.'@date'                                                  //#4
assert soldAt == [ulcDate]
//#1 Builder creation
//#2 Root node creation
//#3 Invoice creation
//#4 GPath query
