package groovy.runtime.metaclass.custom

class CustomMetaClass extends MetaClassImpl {

    CustomMetaClass(MetaClassRegistry registry, Class theClass) {
        super(registry, theClass)
        println "custom meta class is in use"
    }

}
