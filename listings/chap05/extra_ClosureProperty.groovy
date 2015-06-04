class GrailsController {
    def params = [a:1, b:2]
    def list   = { params.keySet().toList() }
}

def controller = new GrailsController()
assert controller.list() == ['a', 'b']

controller.list = { controller.params.values().toList() }
assert controller.list() == [1, 2]