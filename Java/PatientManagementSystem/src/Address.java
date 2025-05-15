class Address {
    private String street, city, state;
    private int postcode;

    public Address(String street, String city, int postcode, String state) {
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.state = state;
    }

    public String getAddress() {
        return street + ", " + postcode + ", " + city + ", "  + state;
    }
}
