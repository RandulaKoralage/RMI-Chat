/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.chat.observer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Randula
 */
public interface ChatObserver extends Remote {

    public void update(String msgType, String sender, String reciever, String content) throws RemoteException;

    public void listUpdate(List<String> userList) throws RemoteException;

    public boolean informUser(String sender, String reciever, String filePath, byte[] data, int len) throws RemoteException;

    public void requetManager(String reciever, String requester) throws RemoteException;
}
