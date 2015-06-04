static String prettify(String s) { "String: $s" }
static String prettify(Date d) { "Date: ${d.time}" }
def var = "I'm a String"
println prettify(var)

