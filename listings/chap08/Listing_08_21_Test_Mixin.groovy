@Mixin(MessageFeature)
class FirstTest extends GroovyTestCase {
    void testWithMixinUsage() {
        message = "Called from Test"
        assertMessage "Called from Test"
    }
}
class MessageFeature {
    def message
    void assertMessage(String msg) {
        assertEquals msg, message
    }
}