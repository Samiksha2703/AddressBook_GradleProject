package com.bridgelaz.addressbook;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class OpenCSVReader {

    private static String HOME = System.getProperty("user.dir");
    private static String fileName = "AddressBook.csv";
    private static Path homePath = Paths.get(HOME);

    public static boolean readCSVFile() throws IOException {
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fileName);
            try {
                if (Files.exists(filePath)) {
                    CSVReader reader = new CSVReader(new FileReader(String.valueOf(filePath)));
                    StringBuffer buffer = new StringBuffer();
                    String line[];
                    while ((line = reader.readNext()) != null) {
                        for (int i = 0; i < line.length; i++) {
                            System.out.print(line[i] + " ");
                        }
                        System.out.println(" ");
                    }
                    return true;
                }
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    public static boolean writeCSVFile(ArrayList<String[]> addContact) throws IOException {
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fileName);
            try {
                if (Files.exists(filePath)) {
                    CSVWriter writer = new CSVWriter(new FileWriter(String.valueOf(filePath)));
                    for (String[] contact : addContact) {
                        writer.writeNext(contact);
                    }
                    writer.flush();
                    return true;
                } else {
                    Files.createFile(filePath);
                    CSVWriter writer = new CSVWriter(new FileWriter(String.valueOf(filePath)));
                    for (String[] contact : addContact) {
                        writer.writeNext(contact);
                    }
                    writer.flush();
                    return true;
                }
            } catch (IOException e) {
                return false;
            }
        } else return false;

    }

}