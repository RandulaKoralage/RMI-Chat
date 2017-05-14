/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.chat.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Randula
 */
public class SignUpList {

    private File userFile = new File("C://Users//Randula//Documents//Hello Database//userFile.txt");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Date date = new Date();
    private BufferedReader userBuffered;
    private FileReader userReader;
    private FileWriter userWriter;
    private String today;

    public SignUpList() throws IOException {

        today = sdf.format(date);
        createFile();
    }

    private void createFile() throws IOException {
        if (!userFile.exists()) {
            userFile.createNewFile();
        }
    }

    public void writeUsers(String userName, String password) throws IOException {
        userWriter = new FileWriter(userFile, true);
        userWriter.write(today + "\t");
        userWriter.write(userName + "\t");
        userWriter.write(password + "\n");
        userWriter.write("\t\t----------------------------------------\n");
        userWriter.flush();

    }

    public ArrayList<User> readUsers() throws FileNotFoundException, IOException {
        userReader = new FileReader(userFile);
        userBuffered = new BufferedReader(userReader);
        String line;
        ArrayList<User> userList = new ArrayList<>();
        while ((line = userBuffered.readLine()) != null) {
            if (!line.equals("\t\t----------------------------------------")) {
                String[] parts = line.split("\t");              
                User user = new User(parts[0], parts[1], parts[2]);
                userList.add(user);
            }
        }
        userBuffered.close();
        // Runtime.getRuntime().exec("notePad C://Users//Randula//Documents//Hello Database//logFile.txt");
        return userList;
    }
}
