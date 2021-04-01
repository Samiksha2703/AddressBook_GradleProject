package com.bridgelaz.addressbooktest;

import com.bridgelaz.addressbook.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class AddressBookTest {
    ArrayList<Contact> contact = new ArrayList<>();

    @Test
    public void whenPersonContactDetailsAddedToFil_ShouldReturn_True() {
        Contact contact1 = new Contact("Samiksha",
                "Shende",
                "Sane Guruji Nagar",
                "Wardha",
                "Maharastra",
                442001,
                "7387555893",
                "shendesamiksha@rediffmail.com");

        Contact contact2 = new Contact("Apurva",
                "Yede",
                "Mundwa",
                "Pune",
                "Maharastra",
                411036,
                "8668984803",
                "apurvayede@gmail.com");

        AddressBookIO addressBook = new AddressBookIO();
        contact.add(contact1);
        contact.add(contact2);
        boolean isAdded = addressBook.addContact(contact);
        Assertions.assertTrue(isAdded);
    }

    @Test
    public void PersonContactDetailsAddedToFile_WhenRead_ShouldReturn_True() {
        Contact contact1 = new Contact("Samiksha",
                "Shende",
                "Sane Guruji Nagar",
                "Wardha",
                "Maharastra",
                442001,
                "7387555893",
                "shendesamiksha@rediffmail.com");

        Contact contact2 = new Contact("Apurva",
                "Yede",
                "Mundwa",
                "Pune",
                "Maharastra",
                411036,
                "8668984803",
                "apurvayede@gmail.com");

        AddressBookIO addressBook = new AddressBookIO();
        contact.add(contact1);
        contact.add(contact2);
        boolean isAdded = addressBook.addContact(contact);
        if (isAdded) {
            boolean isRead = addressBook.viewContact();
            Assertions.assertTrue(isRead);
        }
    }

    @Test
    public void givenCSVFile_WhenRead_ShouldReturn_True() throws IOException {
        OpenCSVReader openCSVReader = new OpenCSVReader();
        Boolean result = openCSVReader.readCSVFile();
        Assertions.assertTrue(result);
    }

    @Test
    public void givenCSVFile_WhenWritten_ShouldReturn_True() throws IOException {
        String ADDRESS_BOOK_CSV_FILE_PATH = ".src/test/resources/AddressBook.csv";
        ArrayList<String[]> contacts = new ArrayList<>();
        String[] contact1 = {"Samiksha",
                "Shende",
                "Sane Guruji Nagar",
                "Wardha",
                "Maharastra",
                "442001",
                "7387555893",
                "shendesamiksha@rediffmail.com"};

        String[] contact2 = {"Apurva",
                "Yede",
                "Mundwa",
                "Pune",
                "Maharastra",
                "411036",
                "8668984803",
                "apurvayede@gmail.com"};

        contacts.add(contact1);
        contacts.add(contact2);
        OpenCSVReader openCSVReader = new OpenCSVReader();
        Boolean result = openCSVReader.writeCSVFile(contacts);
        Assertions.assertTrue(result);
    }

    @Test
    public void givenObject_WhenStoredInTheJson_ShouldReturn_TRUE() {
        ContactPerson contact = new ContactPerson("Samiksha",
                "Shende",
                "Sane Guruji Nagar",
                "Wardha",
                "Maharastra",
                442001,
                "7387555893",
                "shendesamiksha@rediffmail.com");

        JsonReadWrite jsonReadWrite = new JsonReadWrite();
        boolean isAdded = jsonReadWrite.jsonWrite(contact);
        Assertions.assertTrue(isAdded);
    }

    @Test
    public void givenJsonFile_WhenRead_ShouldReturn_TRUE() {
        JsonReadWrite jsonReadWrite = new JsonReadWrite();
        boolean isRead = jsonReadWrite.jsonRead();
        Assertions.assertTrue(isRead);
    }

}