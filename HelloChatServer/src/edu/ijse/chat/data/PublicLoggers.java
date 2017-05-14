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
public class PublicLoggers {

    private File logFile = new File("C://Users//Randula//Documents//Hello Database//logFile.txt");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Date date = new Date();
    private BufferedReader logBuffered;
    private FileReader logReader;
    private FileWriter logWriter;
    private String today;

    

    public PublicLoggers() throws IOException {

        today = sdf.format(date);
        createFile();
    }

    private void createFile() throws IOException {
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
    }

    public void writeLogs(String logLine) throws IOException {
        logWriter = new FileWriter(logFile, true);
       // logWriter.write(today + "\t");
        logWriter.write(logLine + "\n");
        logWriter.write("\t\t----------------------------------------\n");
        logWriter.flush();
    }

    public ArrayList<String> readLogs() throws FileNotFoundException, IOException {
        logReader = new FileReader(logFile);
        logBuffered =new BufferedReader(logReader);
        String line;
        ArrayList <String> lineArray = new ArrayList<>();
         while ((line = logBuffered.readLine()) != null) {          
            lineArray.add(line);
        }
        logBuffered.close();
       // Runtime.getRuntime().exec("notePad C://Users//Randula//Documents//Hello Database//logFile.txt");
        return lineArray;
    }
}
