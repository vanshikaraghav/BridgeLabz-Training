package adress_book;
import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);
        AddressBookService service = new AddressBookService();
        while(true) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1) {
                System.out.print("Enter First Name: ");
                String firstName = sc.nextLine();

                System.out.print("Enter Last Name: ");
                String lastName = sc.nextLine();

                System.out.print("Enter Address: ");
                String address = sc.nextLine();

                System.out.print("Enter City: ");
                String city = sc.nextLine();

                System.out.print("Enter State: ");
                String state = sc.nextLine();

                System.out.print("Enter Zip: ");
                String zip = sc.nextLine();

                System.out.print("Enter Phone: ");
                String phone = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();
                
                AddressBookContact contact = new AddressBookContact(firstName, lastName, address, city, state, zip, phone, email);
                service.addContact(contact);
            }else if(choice == 2) {
            	System.out.println("Enter firstName to edit: ");
            	String name = sc.nextLine();
            	System.out.println("Enter phone Number to edit: ");
            	String phoneNumber = sc.nextLine();
            	service.editContact(name, phoneNumber);
            }else if(choice == 3) {
            	System.out.println("Enter First Name to delete: ");
            	String name = sc.nextLine();
            	service.deleteContact(name);
            }else if(choice == 4) {
            	service.displayContacts();
            }else {
            	System.out.println("Invalid");
            }
        }
	}
}
