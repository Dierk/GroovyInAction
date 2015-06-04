import java.util.Date;

class JavaDispatch {
    public static String prettify(Object o) {
      if (o instanceof String) { return doPrettify((String) o); }
      if (o instanceof Date) { return doPrettify((Date) o); }
      return doPrettify(o);
    }

    static String doPrettify(Object o) { return "Value:"+o.toString(); }
    static String doPrettify(String s) { return "String:"+s; }
    static String doPrettify(Date d) { return "Date:"+d.getTime(); }
}
