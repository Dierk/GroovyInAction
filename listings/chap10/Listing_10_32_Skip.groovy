import groovy.xml.MarkupBuilder
import groovy.transform.TypeChecked
import groovy.transform.TypeCheckingMode

@TypeChecked                                                     //#A
class HTMLExample2 {
    @TypeChecked(TypeCheckingMode.SKIP)                          //#B
    private static String buildPage(String pageTitle) {
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)

        xml.html {
           head { title(pageTitle) }
        }
        writer
    }

    static String page404() {
        buildPage '404 - Not Found'
    }
}

HTMLExample2.page404()
//#A Type check class
//#B But exclude this method
