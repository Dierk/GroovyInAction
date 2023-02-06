final String PI = '3.14'
assert PI.class.name == 'java.lang.String'
assert PI.size() == 4
groovy.test.GroovyAssert.shouldFail(ClassCastException){
    Float areaOfCircleRadiusOne = PI
}
