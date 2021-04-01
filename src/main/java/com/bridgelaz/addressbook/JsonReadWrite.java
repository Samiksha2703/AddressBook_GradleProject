package com.bridgelaz.addressbook;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JsonReadWrite {
    private static final String HOME = System.getProperty("user.dir");
    private static final String fileName = "AddressBook.json";
    private static final Path homePath = Paths.get(HOME);

    private static final Gson gson = new GsonBuilder().create();

    public static boolean jsonWrite(ContactPerson contacts) {
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fileName);
            try {
                if (Files.exists(filePath)) {
                    String s = gson.toJson(contacts);
                    FileWriter fileWriter = new FileWriter(String.valueOf(filePath));
                    fileWriter.write(s);
                    fileWriter.close();
                    return true;
                } else {
                    Files.createFile(filePath);
                    String s = gson.toJson(contacts);
                    FileWriter fileWriter = new FileWriter(String.valueOf(filePath));
                    fileWriter.write(s);
                    fileWriter.close();
                    return true;
                }
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }


    public static boolean jsonRead() {
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fileName);
            try {
                if (Files.exists(filePath)) {
                    BufferedReader br = new BufferedReader(
                            new FileReader(String.valueOf(filePath)));
                    ContactPerson contactPerson = gson.fromJson(br, ContactPerson.class);
                    System.out.println("ContactPerson{" +
                            "firstName='" + contactPerson.firstName + '\'' +
                            ", lastName='" + contactPerson.lastName + '\'' +
                            ", address='" + contactPerson.address + '\'' +
                            ", city='" + contactPerson.city + '\'' +
                            ", state='" + contactPerson.state + '\'' +
                            ", zip=" + contactPerson.zip +
                            ", phoneNumber='" + contactPerson.phoneNumber + '\'' +
                            ", email='" + contactPerson.email + '\'' +
                            '}' );
                    return true;
                }
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }
}