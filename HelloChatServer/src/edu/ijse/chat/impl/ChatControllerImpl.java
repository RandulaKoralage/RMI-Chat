/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.chat.impl;

import edu.ijse.chat.controller.ChatController;
import edu.ijse.chat.observarble.ChatObservable;
import edu.ijse.chat.observer.ChatObserver;
import edu.ijse.chat.ui.ChatServerForm;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Randula
 */
public class ChatControllerImpl extends UnicastRemoteObject implements ChatController {

    private String msgType, sender, reciever, content;

    public ChatControllerImpl() throws RemoteException {

    }

    public ChatControllerImpl(ChatServerForm chatServerForm) throws RemoteException {
        this.chatServer = chatServerForm;
    }
    ChatObservable chatObservable = new ChatObservable();
    ChatServerForm chatServer;

    @Override
    public void sendMessage(String msgType, String sender, String reciever, String content) throws RemoteException {
        this.msgType = msgType;
        this.content = content;
        this.reciever = reciever;
        this.sender = sender;
        chatObservable.notifyChatObserver(msgType, sender, reciever, content);
    }

    @Override
    public void addChatObserver(ChatObserver chatObserver, String name, String ip) throws RemoteException {
        chatObservable.addChatObserver(chatObserver, name);
        chatServer.plusList(name, ip);
    }

    @Override
    public void removeChatObserver(ChatObserver chatObserver, String name, String ip) throws RemoteException {
        chatObservable.removeChatObserver(chatObserver, name);
        chatServer.reduseList(name, ip);
    }

    @Override
    public void addPrivateChatObserver(ChatObserver chatObserver, String sender, String reciever) throws RemoteException {
        chatObservable.addPrivateChatObserver(chatObserver, sender, reciever);
    }

    @Override
    public void removePrivateChatObserver(ChatObserver chatObserver, String sender, String reciever) throws RemoteException {
        chatObservable.removePrivateChatObserver(chatObserver, sender, reciever);
    }

    @Override
    public void signUp(String username, String password) throws RemoteException {
        chatServer.writeSignUp(username, password);
    }

    @Override
    public void saveContact(String owner, String friend) throws RemoteException {
        chatServer.writeContact(owner, friend);

    }

    @Override
    public boolean checkPassword(String userName, String password) throws RemoteException {
        boolean isContains = chatServer.checkForUsers(userName, password);
        return isContains;
    }

    @Override
    public boolean getUserList(String userName) throws RemoteException {
        boolean isContains = chatObservable.getUserList(userName);
        return isContains;
    }

    @Override
    public boolean checkExistance(String userName) throws RemoteException {
        boolean isExist = chatServer.checkForUsername(userName);
        return isExist;
    }

    @Override
    public List<String> getFriendsList(String owner) throws RemoteException {
        List<String> contactList = chatServer.readContactList(owner);
        return contactList;
    }

    @Override
    public void saveMessage(String sender, String reciever, String content) {
        chatServer.writeMessage(sender, reciever, content);
    }

    @Override
    public List<String> viewDaysChat(String date, String sender, String user) throws RemoteException {
        List<String> chat = chatServer.viewChatOnDay(date, sender, reciever);
        return chat;
    }

    @Override
    public boolean sendDocument(String sender, String reciever, String filePath, byte[] data, int len) throws RemoteException {
        boolean isSent = chatObservable.notifyDocumentViewer(sender, reciever, filePath, data, len);
        return isSent;
    }

    @Override
    public void saveContact(String owner, ArrayList<String> fList) throws RemoteException {
        chatServer.writeContactTo(owner, fList);
    }

    @Override
    public void ignoredRequest(String reciever, String requester) throws RemoteException {
        chatObservable.notifyForRequests(reciever, requester);
    }

}
