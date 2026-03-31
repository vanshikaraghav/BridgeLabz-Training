package address.book.repository;

import java.util.List;

import address.book.model.Contact;

public interface AddressBookRepository {

    void save(List<Contact> contacts);

    List<Contact> load();
}