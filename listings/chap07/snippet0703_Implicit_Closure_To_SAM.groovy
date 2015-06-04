import java.awt.event.ActionListener
listeners = []
def addListener(ActionListener al) { listeners << al }
addListener { println "I heard that!" }
listeners*.actionPerformed()
