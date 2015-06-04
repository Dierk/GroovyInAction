import groovy.swing.SwingBuilder
import java.awt.Color 
import java.awt.BorderLayout       as BL    //#|1
import javax.swing.WindowConstants as WC    //#|1
import javax.swing.BorderFactory   as BF    //#|1
import javax.swing.JOptionPane

swing = new SwingBuilder()

paint = swing.action(
    name:        'Paint', 
    closure:     this.&paintGraph,          //#2
    mnemonic:    'P',
    accelerator: 'ctrl P'
)
about = swing.action(
    name:        'About', 
    closure:     this.&showAbout,
    mnemonic:    'A',
    accelerator: 'F1'
)

frame = swing.frame(title:'Plotter', 
    location:[100,100], size:[500,500],     //#3
    defaultCloseOperation:WC.EXIT_ON_CLOSE) {
    menuBar (){
        menu(mnemonic:'A','Action'){
            menuItem(action:paint)
        }
        glue()                              //#4
        menu(mnemonic:'H','Help'){
            menuItem(action:about)
        }
    }    
    panel (border:BF.createEmptyBorder(6,6,6,6)) {
        borderLayout()
        vbox (constraints: BL.NORTH){
            hbox {                     
                hstrut(width:10)
                label 'f(x) = '
                textField(id:'function',action:paint,'Math.sin(x)')
                button(action:paint)
            }
        }              
        vbox (constraints: BL.WEST){
            labeledSpinner('max',1d)       //#5
            20.times { swing.vglue()}      
            labeledSpinner('min',-1d) 
        }      
        vbox(constraints: BL.CENTER, 
            border:BF.createTitledBorder('Function Plot')) {
            panel(id:'canvas')
        }            
        hbox (constraints: BL.SOUTH){        
            hstrut(width:10)
            labeledSpinner('from',0d) 
            10.times { swing.hglue()}   //#6 
            labeledSpinner('to',6.3d)
        }       
    }
}
frame.visible = true

// implementation methods 

def labeledSpinner(label, value){          //#7       
    swing.label(label)
    swing.hstrut()
    swing.spinner(id:label, stateChanged:this.&paintGraph,
        model:swing.spinnerNumberModel(value:value)
    ) 
}
def paintGraph(event) {                     //#8
    calc = new Dynamo(swing.function.text)    
    gfx  = swing.canvas.graphics
    int width  = swing.canvas.size.width
    int height = swing.canvas.size.height
    gfx.color  = new Color(255, 255, 150)
    gfx.fillRect(0, 0, width, height)
    gfx.color  = Color.blue
    xFactor    = (swing.to.value - swing.from.value) / width
    yFactor    = height / (swing.max.value - swing.min.value)
    int ceiling = height + swing.min.value * yFactor
    int lastY   = calc.f(swing.from.value) * yFactor
    for (x in (1..width)) {                  //#9
        int y = calc.f(swing.from.value + x * xFactor) * yFactor
        gfx.drawLine(x-1, ceiling-lastY, x, ceiling-y)
        lastY = y
    }
} 
void showAbout(event) {                     //#10
    JOptionPane.showMessageDialog(frame, 
'''A Function Plotter
that serves as a SwingBuilder example for
Groovy in Action''')
}
// Keep all dynamic invocation handling in one place.
class Dynamo {                              
    static final GroovyShell SHELL = new GroovyShell()
    Script functionScript
    Dynamo(String function){
        functionScript = SHELL.parse(function)  //#11
    }
    Object f(x) {
        functionScript.x = x
        return functionScript.run()             //#12
    }
}
//#1 type aliases as shortcuts
//#2 refer to method closure
//#3 general constructor
//#4 separate help menu
//#5 use factory method
//#6 build with logic
//#7 factory method
//#8 method used as closure
//#9 main plotting loop
//#10 show message dialog
//#11 once per paint
//#12 for each x
