/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.chat.observarble;

import edu.ijse.chat.observer.ChatObserver;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Randula
 */
public class ChatObservable {

    private HashMap<String, ChatObserver> publicChatList;
    private HashMap<String, ChatObserver> privateChatList;
    private LinkedList<String> userList;

    public ChatObservable() {

        publicChatList = new HashMap<>();
        privateChatList = new HashMap<>();
        userList = new LinkedList<>();
    }

    public void notifyChatObserver(String msgType, String sender, String reciever, String content) throws RemoteException {
        if (msgType.equals("PRIVATE")) {
            for (ChatObserver observer : privateChatList.values()) {
                observer.update(msgType, sender, reciever, content);
            }
        } else {
            for (ChatObserver observer : publicChatList.values()) {
                observer.update(msgType, sender, reciever, content);
            }
        }
    }

    public void addChatObserver(ChatObserver chatObserver, String name) throws RemoteException {
        publicChatList.put(name, chatObserver);
        userList.add(name);
        for (ChatObserver observer : publicChatList.values()) {
            observer.listUpdate(userList);
        }

    }

    public void removeChatObserver(ChatObserver chatObserver, String name) throws RemoteException {
        publicChatList.remove(name, chatObserver);
        userList.remove(name);

        for (ChatObserver observer : publicChatList.values()) {
            observer.listUpdate(userList);
        }

    }

    public void addPrivateChatObserver(ChatObserver chatObserver, String sender, String reciever) {
        privateChatList.put(sender+reciever, chatObserver);
    }

    public void removePrivateChatObserver(ChatObserver chatObserver, String sender, String reciever) {
        privateChatList.remove(sender, chatObserver);
    }

    public boolean getUserList(String userName) {
        boolean isUser = false;
        for (String user : userList) {
            if (user.equalsIgnoreCase(userName)) {
                isUser = true;
            }
        }
        return isUser;
    }

    public boolean notifyDocumentViewer(String sender, String reciever, String filePath, byte[] data, int len) throws RemoteException {
        boolean isSent = false;
        for (ChatObserver observer : privateChatList.values()) {
            isSent = observer.informUser(sender, reciever, filePath, data, len);
        }
        return isSent;
    }

    public void notifyForRequests(String reciever, String requester) throws RemoteException {
        for (ChatObserver observer : publicChatList.values()) {
            observer.requetManager(reciever,requester);
        }
    }
}
