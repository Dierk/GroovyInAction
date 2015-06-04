import groovyx.gpars.dataflow.Dataflows
import static groovyx.gpars.dataflow.Dataflow.task

final flow = new Dataflows()
task { flow.list = [0] }
task { flow.list[0] = 1 }
println flow.list