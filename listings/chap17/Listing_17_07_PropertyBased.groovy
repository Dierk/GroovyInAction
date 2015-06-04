@Grab('net.java.quickcheck:quickcheck:0.6')
import static net.java.quickcheck.generator.PrimitiveGenerators.*
import static java.lang.Math.round
import static Converter.celsius

def gen = integers(-40, 240)                         //#1
def liquidC =  0..100
def liquidF = 32..212
100.times {
  int f = gen.next()                                 //#2
  int c = round(celsius(f))
  assert c <= f                                      //#3
  assert c in liquidC == f in liquidF                //#4
}
//#1 Select integers from this range
//#2 Get the next integer
//#3 Celsius less than Fahrenheit (above -40 degrees)
//#4 Water should be liquid in this range
