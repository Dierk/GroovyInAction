class VendorWithCtor {
    String name, product

    VendorWithCtor(name, product) {                    //#A
        this.name    = name
        this.product = product
    }
}

def first = new VendorWithCtor('Canoo','ULC')          //#B

def second = ['Canoo','ULC'] as VendorWithCtor         //#1

VendorWithCtor third = ['Canoo','ULC']                 //#2
//#A Constructor definition
//#B Normal constructor use
//#1 Coercion with as
//#2 Coercion in assignment
