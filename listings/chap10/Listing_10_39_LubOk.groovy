import groovy.transform.TypeChecked

class A { void foo() {} }
class B extends A { void bar() {} }

@TypeChecked
void main() {
    def var = new A()
    def cl = { var = new B() }
    cl()
    var.foo()
}

main()
