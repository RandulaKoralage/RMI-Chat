/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.chat.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Randula
 */
public class PrivateContacts {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final String folder = "C://Users//Randula//Documents//Hello Database//Private//";
    private File contactFile;
    private final Date date = new Date();
    private BufferedReader contactBuffered;
    private FileReader contactReader;
    private FileWriter contactWriter;
    private String today;
    private String friend;
    private String owner;

    public PrivateContacts() throws IOException {
        today = sdf.format(date);

    }

    private void createFile(String owner, String friend) throws IOException {
        this.friend = friend;
        this.owner = owner;

        contactFile = new File(folder + owner + ".txt");
        if (!contactFile.exists()) {
            contactFile.createNewFile();
        }
    }

    public void writeUsers(String owner, String friend) throws IOException {
        createFile(owner, friend);
        contactWriter = new FileWriter(contactFile, true);
        contactWriter.write(today + "\t");
        // contactWriter.write(owner + "\t");
        contactWriter.write(friend + "\n");
        contactWriter.write("\t\t----------------------------------------\n");
        contactWriter.flush();

    }

    public ArrayList<String> readFriends(String owner) throws FileNotFoundException, IOException {
        contactFile = new File(folder + owner + ".txt");
        if (!contactFile.exists()) {
            contactFile.createNewFile();
        }

        contactReader = new FileReader(contactFile);
        contactBuffered = new BufferedReader(contactReader);
        String line;
        ArrayList<String> contactList = new ArrayList<>();
        while ((line = contactBuffered.readLine()) != null) {
            if (!line.equals("\t\t----------------------------------------")) {
                String[] parts = line.split("\t");
                contactList.add(parts[1]);
            }
        }
        contactBuffered.close();
        // Runtime.getRuntime().exec("notePad C://Users//Randula//Documents//Hello Database//logFile.txt");
        return contactList;
    }

    public void writeUsersToArray(String owner, ArrayList<String> fList) throws IOException {

        HashMap map = new HashMap<ArrayList, String>();
        contactFile = new File("Contact.txt");
        if (!contactFile.exists()) {
            contactFile.createNewFile();
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(contactFile));

        oos.writeObject(map);

    }
}
