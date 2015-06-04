@Grab('com.github.jsqlparser:jsqlparser:0.9.2')
import net.sf.jsqlparser.parser.CCJSqlParserManager

afterMethodCall { mc ->
  def receiver = mc.receiver
  if (!isVariableExpression(receiver)) return              //#1
  def method = getTargetMethod(mc)                         //#1
  if (classNodeFor(groovy.sql.Sql) == getType(receiver)    //#1
      && method.name == 'eachRow') {                       //#1
    def argList = getArguments(mc)                         //#1
    if (argList && isConstantExpression(argList[0])) {     //#1

      def pm = new CCJSqlParserManager()                        //#2
      def sqlQuery = argList[0].text                            //#2
      try {                                                     //#2
        pm.parse(new StringReader(sqlQuery))                    //#2
      } catch (e) {
        addStaticTypeError("SQL query is not valid: $e", argList[0]) //#3
      }
    }
  }
}
//#1 Info extraction and guards
//#2 Validate SQL using library
//#3 Flag an error if invalid
