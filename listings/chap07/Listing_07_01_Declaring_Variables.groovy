class ClassWithTypedAndUntypedFieldsAndProperties {

    public    fieldWithModifier
    String    typedField
    def       untypedField
    protected field1, field2, field3
    private   assignedField = new Date()

    static    classField
    public static final String CONSTA = 'a', CONSTB = 'b'

    def someMethod(){
        def localUntypedMethodVar = 1
        int localTypedMethodVar = 1
        def localVarWithoutAssignment, andAnotherOne
    }
}

def localvar = 1                                       //#A
boundvar1 = 1                                          //#B

def someMethod(){                                      //#C
    def localMethodVar = 1                             //#C
    boundvar2 = 1                                      //#C
}                                                      //#C
someMethod()
//#A Local variable to the script
//#B From the binding
//#C Local method to the script
