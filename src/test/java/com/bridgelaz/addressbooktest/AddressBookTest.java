package com.bridgelaz.addressbooktest;

import com.bridgelaz.addressbook.AddressBookIO;
import com.bridgelaz.addressbook.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
            boolean isRead = addressBook.veiwContact();
            Assertions.assertTrue(isRead);
        }
    }
}
