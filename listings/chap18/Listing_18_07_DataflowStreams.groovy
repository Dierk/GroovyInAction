import static groovyx.gpars.dataflow.Dataflow.*
import groovyx.gpars.dataflow.DataflowQueue

def chances = new DataflowQueue()
def amounts = new DataflowQueue()
def payouts = new DataflowQueue()

operator( inputs: [chances, amounts],
          outputs:[payouts],
        { chance, amount -> payouts << chance * amount }
)

task { [0.1, 0.2, 0.3].each { chances << it } }
task { [300, 200, 100].each { amounts << it } }

[30, 40, 30].each { assert it == payouts.val }