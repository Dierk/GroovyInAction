import groovy.transform.IndexedProperty

class Author {
    String name
    @IndexedProperty List<String> books
}

def books = ['The Mysterious Affair at Styles',
             'The Murder at the Vicarage']

new Author(name: 'Agatha Christie', books: books).with {
    books[0] = 'Murder on the Orient Express'            //#1
    setBooks(0, 'Death on the Nile')                     //#2
    assert getBooks(0) == 'Death on the Nile'            //#3
}
//#1 Groovy idiom for setting the first property
//#2 JavaBean approach to setting a single element
//#3 JavaBean approach to reading a single element
