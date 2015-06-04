class MrBean {
    String firstname, lastname                         //#A
    
    String getName(){                                  //#1
        return "$firstname $lastname"
    }
}

def bean = new MrBean(firstname: 'Rowan')              //#B
bean.lastname = 'Atkinson'                             //#2

assert 'Rowan Atkinson' == bean.name                   //#3
//#A Groovy style properties
//#1 Getter for derived property
//#B Generic constructor
//#2 Call setter
//#3 Call getter
