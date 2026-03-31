package address.book.repository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import address.book.model.Contact;

public class JSONRepository implements AddressBookRepository {

    private static final String FILE_NAME = "addressbook.json";
    private Gson gson = new Gson();

    // UC14 - Write to JSON
    @Override
    public void save(List<Contact> contacts) {

        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(contacts, writer);
            System.out.println("Data saved successfully to JSON file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // UC14 - Read from JSON
    @Override
    public List<Contact> load() {

        try (Reader reader = new FileReader(FILE_NAME)) {

            Type contactListType = new TypeToken<List<Contact>>() {}.getType();
            List<Contact> contacts = gson.fromJson(reader, contactListType);

            return contacts != null ? contacts : new ArrayList<>();

        } catch (FileNotFoundException e) {
            System.out.println("JSON file not found. Returning empty list.");
            return new ArrayList<>();

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}