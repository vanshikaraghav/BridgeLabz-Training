package adress_book;

import java.util.List;

public class AddressBookService {

    private AddressBookDAO dao = new AddressBookDAO();

    // UC 2 – Add Contact  (Service Layer)
    public void addContact(AddressBookContact contact) {
        dao.addContact(contact);
        System.out.println("Contact added successfully.");
    }

    // UC 3 – Edit Contact
    public void editContact(String name, String newPhone) {
        AddressBookContact contact = dao.findByName(name);
        if(contact != null) {
            contact.setPhoneNumber(newPhone);
            System.out.println("Contact updated successfully.");
        }else {
            System.out.println("Contact not found.");
        }
    }

    // UC 4 – Delete Contact
    public void deleteContact(String name) {
        boolean deleted = dao.deleteByName(name);
        if(deleted) {
            System.out.println("Contact deleted successfully.");
        }else {
           System.out.println("Contact not found.");
        }
    }

    public void displayContacts() {
        List<AddressBookContact> contacts = dao.getAllContacts();
        for(AddressBookContact contact : contacts) {
            contact.displayContact();
        }
    }
}