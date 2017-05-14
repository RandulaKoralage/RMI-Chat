/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.chat.controller;

import edu.ijse.chat.observer.ChatObserver;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Randula
 */
public interface ChatController extends Remote {

    public void sendMessage(String msgType, String sender, String reciever, String content) throws RemoteException;

    public void addChatObserver(ChatObserver chatObserver, String name, String ip) throws RemoteException;

    public void removeChatObserver(ChatObserver chatObserver, String name, String ip) throws RemoteException;

    public void addPrivateChatObserver(ChatObserver chatObserver, String sender, String reciever) throws RemoteException;

    public void removePrivateChatObserver(ChatObserver chatObserver, String sender, String reciever) throws RemoteException;

    public void ignoredRequest(String reciever, String requester) throws RemoteException;

    public void signUp(String username, String password) throws RemoteException;

    public void saveContact(String owner, String friend) throws RemoteException;

    public void saveContact(String owner, ArrayList<String> fList) throws RemoteException;

    public boolean getUserList(String userName) throws RemoteException;

    public boolean checkPassword(String userName, String password) throws RemoteException;

    public boolean checkExistance(String userName) throws RemoteException;

    public List<String> getFriendsList(String owner) throws RemoteException;

    public void saveMessage(String sender, String reciever, String content) throws RemoteException;

    public List<String> viewDaysChat(String date, String sender, String reciever) throws RemoteException;

    public boolean sendDocument(String sender, String reciever, String filePath, byte[] data, int len) throws RemoteException;
}
