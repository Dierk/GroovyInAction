import groovy.transform.CompileStatic
static String prettify(String s) { "String: $s" }
static String prettify(Date d) { "Date: ${d.time}" }

@CompileStatic
void test() {
   def var = "I'm a String"           //#1
   println prettify(var)              //#2
}
test()
//#1 Using def, which is equivalent to Object
//#2 Calls prettify(String)
