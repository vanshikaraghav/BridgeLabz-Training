package adress_book;
import java.util.ArrayList;

public class AddressBookDAO {
	
	// Repository Layer - DAO
    private ArrayList<AddressBookContact> contactList = new ArrayList<>();

    public void addContact(AddressBookContact contact) {
        contactList.add(contact);
    }

    public ArrayList<AddressBookContact> getAllContacts() {
        return contactList;
    }

    public AddressBookContact findByName(String name) {
        for(AddressBookContact contact : contactList) {
            if(contact.getFirstName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public boolean deleteByName(String name) {
        for(int i=0;i<contactList.size();i++){
        	if(contactList.get(i).getFirstName().equalsIgnoreCase(name)) {
        		contactList.remove(i);
        		return true;
        	}
        }
        return false;
    }
}
