package scenario_based;
import java.util.ArrayList;
import java.util.List;

class InvalidPhoneNumberException extends Exception {
    InvalidPhoneNumberException(String msg) {
        super(msg);
    }
}

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class PhoneContactOrganizor {
    static List<Contact> contacts = new ArrayList<>();

    public static void addContact(String name, String phone) throws InvalidPhoneNumberException {
        if(!phone.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits");
        }
        for(Contact c : contacts) {
            if(c.phone.equals(phone)) {
                System.out.println("Duplicate contact not allowed");
                return;
            }
        }
        contacts.add(new Contact(name, phone));
        System.out.println("Contact added successfully");
    }

    public static void searchContact(String phone) {
        for(Contact c : contacts) {
            if(c.phone.equals(phone)) {
                System.out.println("Found: " + c.name + " - " + c.phone);
                return;
            }
        }
        System.out.println("Contact not found");
    }

    public static void deleteContact(String phone) {
        contacts.removeIf(c -> c.phone.equals(phone));
        System.out.println("Contact deleted (if existed)");
    }

    public static void main(String[] args) {
        try{
            addContact("Aman", "9876543210");
            addContact("Rahul", "9876543210");
            addContact("Neha", "12345");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        searchContact("9876543210");
        deleteContact("9876543210");
        searchContact("9876543210");
    }
}

