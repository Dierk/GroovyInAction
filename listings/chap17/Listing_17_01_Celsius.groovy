import static Converter.celsius

assert  20 == celsius(68)
assert  35 == celsius(95)
assert -17 == celsius(0).toInteger()                //#A
assert   0 == celsius(32)
//#A Round down to whole number
