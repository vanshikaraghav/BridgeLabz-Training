package address.book.service;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import address.book.model.Contact;
import address.book.repository.AddressBookRepository;

public class AddressBookService {

    private List<Contact> contacts = new ArrayList<>();
    private AddressBookRepository repository;

    public AddressBookService(AddressBookRepository repository) {
        this.repository = repository;
    }

    // UC1
    public void addContact(Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.add(contact);
        } else {
            System.out.println("Duplicate Entry!");
        }
    }

    // UC3
    public void deleteContact(String firstName) {
        contacts.removeIf(c -> c.getFirstName().equalsIgnoreCase(firstName));
    }

    // UC10
    public void sortByName() {
        contacts.sort(Comparator.comparing(Contact::getFirstName));
    }

    // UC11
    public void sortByCity() {
        contacts.sort(Comparator.comparing(Contact::getCity));
    }

    // UC9
    public long countByCity(String city) {
        return contacts.stream()
                .filter(c -> c.getCity().equalsIgnoreCase(city))
                .count();
    }

    // UC16 + UC17 (Non-blocking IO)
    public void saveAsync() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> repository.save(contacts));
        executor.shutdown();
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}