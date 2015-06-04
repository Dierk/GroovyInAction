package business

class Vendor {
    public String  name
    public String  product
    public Address address = new Address()
}

class Address  {
    public String  street, town, state
    public int     zip
}