class BookBean {
  String title                                         //#A
}

def groovyBook = new BookBean()

groovyBook.setTitle('Groovy in Action')                //#B
assert groovyBook.getTitle() == 'Groovy in Action'     //#B

groovyBook.title = 'Groovy conquers the world'         //#C
assert groovyBook.title == 'Groovy conquers the world' //#C
//#A Property declaration
//#B Property use with explicit getter calls
//#C Property use with Groovy shortcuts
