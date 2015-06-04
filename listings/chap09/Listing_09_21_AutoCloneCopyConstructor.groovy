import groovy.transform.*
import static groovy.transform.AutoCloneStyle.*

@TupleConstructor
@AutoClone(style=COPY_CONSTRUCTOR)
class Person {
    final String name
    final Date born
}

@TupleConstructor(includeSuperProperties=true,
        callSuper=true)
@AutoClone(style=COPY_CONSTRUCTOR)
class Chef2 extends Person {
    final List<String> recipes
}

def name = 'Jamie Oliver'
def recipes = ['Lentil Soup', 'Crispy Duck']
def born = Date.parse('yyyy-MM-dd', '1975-05-27')
def c1 = new Chef2(name, born, recipes)
def c2 = c1.clone()
assert c2.name == name
assert c2.born == born
assert c2.recipes == recipes
