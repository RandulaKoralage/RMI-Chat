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
public class MessageList {

    private File msgFile = new File("C://Users//Randula//Documents//Hello Database//Messages//message.txt");
    private SimpleDateFormat sdf1;
    private SimpleDateFormat sdf2; 

    private BufferedReader msgBuffered;
    private FileReader msgReader;
    private FileWriter msgWriter;

    public MessageList() throws IOException {

        createFile();
    }

    private void createFile() throws IOException {
        if (!msgFile.exists()) {
            msgFile.createNewFile();
        }
    }

    public void writeMsg(String sender, String reciever, String content) throws IOException {
        Date date = new Date();
        Date times = new Date();
        sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf1.format(date);
        sdf2 = new SimpleDateFormat("HH:mm:ss");
        String time = sdf2.format(times);

        msgWriter = new FileWriter(msgFile, true);

        msgWriter.write(sender + "\t");
        msgWriter.write(reciever + "\t");
        msgWriter.write(today + "\t");
        msgWriter.write(time + "\t");
        msgWriter.write(content + "\n");
        msgWriter.write("\t\t----------------------------------------\n");
        msgWriter.flush();

    }

    public ArrayList<Messages> readMsg() throws FileNotFoundException, IOException {
        msgReader = new FileReader(msgFile);
        msgBuffered = new BufferedReader(msgReader);
        String line;
        ArrayList<Messages> msgList = new ArrayList<>();
        while ((line = msgBuffered.readLine()) != null) {
            if (!line.equals("\t\t----------------------------------------")) {
                String[] parts = line.split("\t");
                Messages message = new Messages(parts[0], parts[1], parts[2], parts[3], parts[4]);
                msgList.add(message);
            }
        }
        msgBuffered.close();
        // Runtime.getRuntime().exec("notePad C://Users//Randula//Documents//Hello Database//logFile.txt");
        return msgList;
    }

    public ArrayList<Messages> readMsg(String date, String sender, String reciever) throws FileNotFoundException, IOException {
        msgReader = new FileReader(msgFile);
        msgBuffered = new BufferedReader(msgReader);
        String line;

        Date daToday = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(daToday);

        ArrayList<Messages> msgList = new ArrayList<>();

        while ((line = msgBuffered.readLine()) != null) {
            if (!line.equals("\t\t----------------------------------------")) {
                String[] parts = line.split("\t");
                if ((sender.equalsIgnoreCase(parts[0]) && reciever.equalsIgnoreCase(parts[1])) || (sender.equalsIgnoreCase(parts[1]) && reciever.equalsIgnoreCase(parts[0]))) {
                    if (today.equalsIgnoreCase(parts[2])) {
                        Messages message = new Messages(parts[0], parts[1], parts[2], parts[3], parts[4]);
                        msgList.add(message);
                    }
                }
                if (msgList.size() == 0) {
                    if (date.equalsIgnoreCase(parts[2])) {
                        Messages message = new Messages(parts[0], parts[1], parts[2], parts[3], parts[4]);
                        msgList.add(message);
                    }
                }
            }
        }

        msgBuffered.close();
        // Runtime.getRuntime().exec("notePad C://Users//Randula//Documents//Hello Database//logFile.txt");
        return msgList;
    }
}
