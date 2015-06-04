def greeting = 'Hello'

greeting <<= ' Groovy'                                 //#1

assert greeting instanceof java.lang.StringBuffer

greeting << '!'                                        //#2

assert greeting.toString() == 'Hello Groovy!'

greeting[1..4] = 'i'                                   //#A

assert greeting.toString() == 'Hi Groovy!'
//#1 Left shift and assign
//#2 Left shift on StringBuffer
//#A Substring 'ello' becomes 'i'
