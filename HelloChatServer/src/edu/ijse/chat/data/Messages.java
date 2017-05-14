/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.chat.data;

/**
 *
 * @author Randula
 */
public class Messages {
      private String sender;
    private String reciever;
    private String date;
    private String time;
    private String content;

    public Messages(String sender, String reciever, String date, String time, String content)  {
        this.sender = sender;
        this.reciever = reciever;
        this.date = date;
        this.time = time;
        this.content = content;
    }
    public Messages(String sender, String reciever, String content)  {
            this.sender = sender;
            this.reciever = reciever;          
            this.content = content;
        }
    /**
     * @return the sender
     */
    public String getSender()  {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(String sender){
        this.sender = sender;
    }

    /**
     * @return the reciever
     */
    public String getReciever() {
        return reciever;
    }

    /**
     * @param reciever the reciever to set
     */
    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date)  {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime(){
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time){
        this.time = time;
    }

    /**
     * @return the content
     */
    public String getContent()  {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    
}
