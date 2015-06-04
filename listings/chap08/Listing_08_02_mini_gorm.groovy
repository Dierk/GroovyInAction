class MiniGorm {
    def db = []
    Object methodMissing(String name, Object args) {
        println name
        db.find { it[name.toLowerCase()-'findby'] == args[0] } //#1
    }
}

def people = new MiniGorm()                         //#2
def dierk  = [first: 'Dierk', last:'Koenig']
def paul   = [first: 'Paul',  last:'King']
people.db << dierk << paul

assert people.findByFirst('Dierk') == dierk         //#3
assert people.findByLast('King')   == paul