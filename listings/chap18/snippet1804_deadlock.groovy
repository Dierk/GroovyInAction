import groovyx.gpars.dataflow.Dataflows
import static groovyx.gpars.dataflow.Dataflow.task

final flow = new Dataflows()
task { flow.x = flow.y }			
task { flow.y = flow.x }