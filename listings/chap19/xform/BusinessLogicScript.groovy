package xform

abstract class BusinessLogicScript extends Script {
    def when(boolean condition, Closure closure) {
        if (condition) closure()
    }
}
