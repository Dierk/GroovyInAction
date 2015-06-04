@Grab('org.codehaus.groovyfx:groovyfx:0.3.1')

import static groovyx.javafx.GroovyFX.start

start {
  stage title: 'GroovyFX Hello World', visible: true, {
    scene fill: BLACK, width: 600, height: 300, {
      hbox padding: 40, alignment:'center', {
        text 'Hello', font: '80pt sanserif', {
          fill linearGradient(endX: 0, stops: [PALEGREEN, SEAGREEN])
        }
        text ' FX ', font: '80pt sanserif', {
          fill   linearGradient(endX: 0, stops: [CYAN, DODGERBLUE])
          effect dropShadow(color: DODGERBLUE, radius: 25, spread: 0.35)
        }
        imageView 'file:World.png', effect:reflection()
      }
    }
  }
}