class SimpleVendor {
    String name, product
}

new SimpleVendor()
new SimpleVendor(name: 'Canoo')
new SimpleVendor(product: 'ULC')
new SimpleVendor(name: 'Canoo', product: 'ULC')

def vendor = new SimpleVendor(name: 'Canoo')
assert 'Canoo' == vendor.name
