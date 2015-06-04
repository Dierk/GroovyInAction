import groovy.swing.SwingBuilder

swing = new SwingBuilder()
button = swing.button('Print')

frame = swing.frame(title:'Printer') {
  panel {
    textField(columns:10)
    widget(button)
  }
}

button.actionPerformed = {
  println frame.title
}

frame.pack()
frame.visible = true
