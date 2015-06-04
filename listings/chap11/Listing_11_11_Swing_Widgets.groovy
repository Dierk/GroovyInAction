import groovy.swing.SwingBuilder

swing = new SwingBuilder()
frame = swing.frame(title:'Demo') {
	menuBar {
        menu('File') {
            menuItem 'New' 
            menuItem 'Open'
        }
    }
    panel {
        label 'Label 1'
        slider()
        comboBox(items:['one','two','three'])
    }    
}
frame.pack()
frame.visible = true
