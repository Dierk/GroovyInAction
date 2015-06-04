public class Greeter {               // Java!
    static void greet(Object o) {
        System.out.println("Hello, object " + o);
    }

    static void greet(String s) {
        System.out.println("Hello, string " + s);
    }

    public static void main(String... args) {
        Object o = "Bob";
        String s = "Bob";
        greet(o);
        greet(s);
    }
}

