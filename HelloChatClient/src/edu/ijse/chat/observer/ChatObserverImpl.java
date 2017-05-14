/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.chat.observer;

import edu.ijse.chat.ui.ChatFrame;
import edu.ijse.chat.ui.PrivateChatForm;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Randula
 */
public class ChatObserverImpl extends UnicastRemoteObject implements ChatObserver {

    private ChatFrame chatFrame;
    private PrivateChatForm privateChatForm;

    public ChatObserverImpl(ChatFrame chatFrame) throws RemoteException {
        this.chatFrame = chatFrame;
    }

    public ChatObserverImpl(PrivateChatForm privateChatForm) throws RemoteException {
        this.privateChatForm = privateChatForm;
    }

    @Override
    public void update(String msgType, String sender, String reciever, String content) throws RemoteException {
        if (msgType.equals("PUBLIC") || msgType.equals("SERVICE")) {
            chatFrame.setMessage(msgType, sender, reciever, content);
        } else if (msgType.equals("REQUEST")) {
            chatFrame.viewRequest(sender, reciever);
        } else if (msgType.equals("COMFIRM")) {
            chatFrame.viewPrivate(sender, reciever);
        } else if (msgType.equals("PRIVATE") && (!content.equals("EXIT"))) {
            privateChatForm.setMessage(sender, reciever, content);
        } else if (msgType.equals("PRIVATE") && (content.equals("EXIT"))) {
            privateChatForm.setExitMessage(sender, reciever, content);
        }

    }

    @Override
    public void listUpdate(List<String> userList) throws RemoteException {

        chatFrame.setOnlineList(userList);
    }

    @Override
    public boolean informUser(String sender, String reciever, String filePath, byte[] data, int len) throws RemoteException {
        boolean isSent = privateChatForm.recieveFile(sender, reciever, filePath, data, len);
        return isSent;
    }

    @Override
    public void requetManager(String reciever, String requester) throws RemoteException {
        chatFrame.tellIgnored(reciever, requester);
    }

}
