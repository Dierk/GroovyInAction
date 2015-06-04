import business.*

def canoo = new Vendor()
canoo.name          = 'Canoo Engineering AG'
canoo.product       = 'UltraLightClient (ULC)'

assert canoo.dump() =~ /ULC/