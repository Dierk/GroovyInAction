import groovy.transform.InheritConstructors

@InheritConstructors
class MyPrintWriter extends PrintWriter { }

def pw1 = new MyPrintWriter(new File('out1.txt'))      //#A
def pw2 = new MyPrintWriter('out2.txt', 'US-ASCII')    //#B
[pw1, pw2].each {
    it << 'foo'
    it.close()
}
assert new File('out1.txt').text == new File('out2.txt').text
['out1.txt', 'out2.txt'].each{ new File(it).delete() }
//#A File file variant
//#B String fileName, String charset variant
