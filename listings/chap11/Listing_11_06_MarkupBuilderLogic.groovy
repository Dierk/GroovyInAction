import groovy.xml.MarkupBuilder

TimeZone.default = TimeZone.getTimeZone("CET")

def writer = new StringWriter()
def builder = new MarkupBuilder(writer)                    //#1
builder.invoices {
  for (day in 1..3) {
    def invDate = Date.parse('yyyy-MM-dd', "2015-01-0$day")
    invoice(date: invDate) {
      item(count: day) {
        product(name: 'ULC', dollar: 1499)
      }
    }
  }
}

assert "\n" + writer.toString() == """
<invoices>
  <invoice date='Thu Jan 01 00:00:00 CET 2015'>
    <item count='1'>
      <product name='ULC' dollar='1499' />
    </item>
  </invoice>
  <invoice date='Fri Jan 02 00:00:00 CET 2015'>
    <item count='2'>
      <product name='ULC' dollar='1499' />
    </item>
  </invoice>
  <invoice date='Sat Jan 03 00:00:00 CET 2015'>
    <item count='3'>
      <product name='ULC' dollar='1499' />
    </item>
  </invoice>
</invoices>"""
//#1 NEW: MarkupBuilder replaces NodeBuilder