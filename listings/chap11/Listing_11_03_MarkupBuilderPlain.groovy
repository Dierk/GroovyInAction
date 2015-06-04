def builder = new groovy.xml.MarkupBuilder()
builder.numbers {

    description 'Squares and factors of 10..15'

    for (i in 10..15) {
        number (value: i, square: i*i) {  //#1
            for (j in 2..<i) {
                if (i % j == 0) {
                    factor (value: j)     //#2
                }
            }
        }
    }
}
//#1 Emit number elements 10 through 15
//#2 Emit each factor element