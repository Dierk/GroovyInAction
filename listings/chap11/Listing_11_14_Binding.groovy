import groovy.beans.*
import groovy.swing.SwingBuilder

import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.beans.PropertyVetoException

class Person implements ActionListener {
  @Bindable String name
  @Vetoable int age

  void actionPerformed(ActionEvent e) {
    if (e.actionCommand == name) setAge(age + 1)
  }
}

class BirthdayNotifier {
  @ListenerList List<ActionListener> listeners

  def triggerBirthday(name) {
    def event = new ActionEvent(this, 0, name)
    fireActionPerformed(event)
  }
}

data = [
    new Person(name: 'Anthony', age: 51),
    new Person(name: 'Greg', age: 42),
    new Person(name: 'Jeff', age: 60),
    new Person(name: 'Murray', age: 54)
]

swing = new SwingBuilder()
frame = swing.frame(title: 'Binding Demo') {
  table {
    tableModel(list: data, id: 'tableModel') {
      propertyColumn(header: 'Name', propertyName: 'name',
          editable: true)
      propertyColumn(header: 'Age', propertyName: 'age',
          type: Integer, editable: true)
    }
  }
}
frame.pack()
frame.visible = true

notifier = new BirthdayNotifier()
data.each {
  it.addPropertyChangeListener { evt ->
    println "$evt.newValue has replaced $evt.oldValue"              //#1
  }
  it.addVetoableChangeListener { evt ->
    if (evt.newValue < 0)                                           //#2
      throw new PropertyVetoException("Can't have -ve age", evt)    //#2
    else                                                            //#2
      println "$evt.source.name now has age $evt.newValue"          //#2
  }
  notifier.addActionListener(it)                                    //#3
}

try {
  data[0].age = -99                                                 //#4
} catch (e) {
  println "Change ignored: $e.message"
}
data[1].name = 'Sam'                                                //#5
data[1].age = 36                                                    //#5

notifier.triggerBirthday(data[2].name)                              //#6

swing.tableModel.fireTableDataChanged()
//#1 Log when the name changes
//#2 Log when the age change but veto -ve ages
//#3 Listen for birthday notifications
//#4 Attempt to trigger invalid age
//#5 Sam replaces Greg
//#6 Jeff has a birthday
