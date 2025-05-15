
class Person {
    private String firstName, lastName, gender;
    private Address address;

    public Person(String firstName, String lastName, String gender, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getGender() {
        return this.gender;
    }

    public Address getAddress() {
        return address;
    }
}
