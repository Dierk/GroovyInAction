class Holder {
  def value = 'My value'                    //#1
}

@groovy.transform.TypeChecked
void testNoCompileTimeErrorDueToDef() {
  def holder = new Holder()                 //#2
  holder.value = 5                          //#3
}

testNoCompileTimeErrorDueToDef()
//#1 Property declaration
//#2 Create Holder instance
//#3 Holder value type changes!
