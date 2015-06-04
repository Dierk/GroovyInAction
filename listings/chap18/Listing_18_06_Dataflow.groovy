import groovyx.gpars.dataflow.Dataflows
import static groovyx.gpars.dataflow.Dataflow.task

final flow = new Dataflows()
task { flow.result = flow.x + flow.y }      //#1
task { flow.x = 10 }                        //|#2
task { flow.y = 5 }                         //|#2
assert 15 == flow.result                    //#3
//#1 Assign derived value
//#2 Assign value
//#3 Read value
