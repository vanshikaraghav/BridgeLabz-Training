package address.book.model;

import java.util.Objects;

public class Contact {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    public Contact(String firstName, String lastName, String address,
                   String city, String state, String zip,
                   String phone, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName() { return firstName; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }

    // UC7 - Override equals for duplicate check
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contact)) return false;
        Contact contact = (Contact) obj;
        return firstName.equalsIgnoreCase(contact.firstName) &&
               lastName.equalsIgnoreCase(contact.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
    }

    // UC10 - Override toString
    @Override
    public String toString() {
        return firstName + " " + lastName + " | " + city + " | " + state;
    }
}