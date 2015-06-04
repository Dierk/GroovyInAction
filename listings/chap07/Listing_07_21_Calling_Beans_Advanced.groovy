class DoublerBean {
    public value                                       //#A
    
    void setValue(value){
        this.value = value                             //#1
    }
    
    def getValue(){                        
        value * 2                                      //#2
    }
}

def bean = new DoublerBean(value: 100)     

assert 200 == bean.value                               //#3
assert 100 == bean.@value                              //#B
//#A Visible field
//#1 Inner field access
//#2 Inner field access
//#3 Property access
//#B Outer field access
