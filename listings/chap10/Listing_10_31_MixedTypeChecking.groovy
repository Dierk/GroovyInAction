import groovy.xml.MarkupBuilder
import groovy.transform.TypeChecked

class HTMLExample {
    private static String buildPage(String pageTitle) {
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)

        xml.html {
           head { title(pageTitle) }
        }
        writer
    }

    @TypeChecked                                     //#A
    static String page404() {
        buildPage '404 - Not Found'
    }
}

HTMLExample.page404()
//#A Type check only this method
