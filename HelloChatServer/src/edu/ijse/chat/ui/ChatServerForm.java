/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.chat.ui;

import edu.ijse.chat.data.MessageList;
import edu.ijse.chat.data.Messages;
import edu.ijse.chat.data.PrivateContacts;
import edu.ijse.chat.data.PublicLoggers;
import edu.ijse.chat.data.SignUpList;
import edu.ijse.chat.data.User;
import edu.ijse.chat.impl.ChatControllerImpl;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Randula
 */
public class ChatServerForm extends javax.swing.JFrame {

    private int onlineClients = 0;
    private DateFormat dateFormat;
    private Date date = new Date();
    private PublicLoggers loggerF;
    private SignUpList signUpF;
    private PrivateContacts contactF;
    private MessageList messageF;
    private Registry serverRegistry;
    private ChatControllerImpl chatControllerImpl;

    /**
     * Creates new form ChatServerForm
     */
    public ChatServerForm() {

        try {
            initComponents();
            loggerF = new PublicLoggers();
            signUpF = new SignUpList();
            contactF = new PrivateContacts();
            messageF = new MessageList();
        } catch (IOException ex) {
           System.out.println(ex.getMessage());    
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtServerPane = new javax.swing.JTextArea();
        btnConnection = new javax.swing.JButton();
        lblStartTime = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblEndTime = new javax.swing.JLabel();
        lblCstatus = new javax.swing.JLabel();
        lblEtime = new javax.swing.JLabel();
        lblStime2 = new javax.swing.JLabel();
        lblNowOnline = new javax.swing.JLabel();
        lblHistory = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server Manager");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtServerPane.setEditable(false);
        txtServerPane.setColumns(20);
        txtServerPane.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtServerPane.setRows(5);
        jScrollPane1.setViewportView(txtServerPane);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 610, 390));

        btnConnection.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnConnection.setText("Establish Connection");
        btnConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectionActionPerformed(evt);
            }
        });
        getContentPane().add(btnConnection, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 230, 60));

        lblStartTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStartTime.setText("Start Time");
        getContentPane().add(lblStartTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 80, 30));

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStatus.setText("Status");
        getContentPane().add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 80, 30));

        lblEndTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEndTime.setText("End Time");
        getContentPane().add(lblEndTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 80, 30));

        lblCstatus.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        lblCstatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        getContentPane().add(lblCstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, 150, 30));

        lblEtime.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        lblEtime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        getContentPane().add(lblEtime, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 280, 150, 30));

        lblStime2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        lblStime2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        getContentPane().add(lblStime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 150, 30));

        lblNowOnline.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblNowOnline.setForeground(new java.awt.Color(255, 0, 0));
        lblNowOnline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNowOnline.setText("0 People Online");
        getContentPane().add(lblNowOnline, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 230, 50));

        lblHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/chat/ui/image/history.png"))); // NOI18N
        lblHistory.setToolTipText("Login History");
        lblHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHistoryMouseClicked(evt);
            }
        });
        getContentPane().add(lblHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 60, 40));

        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/chat/ui/image/users.png"))); // NOI18N
        lblUser.setText("jLabel2");
        lblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserMouseClicked(evt);
            }
        });
        getContentPane().add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 50, 40));

        lblMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/chat/ui/image/message.png"))); // NOI18N
        lblMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMessageMouseClicked(evt);
            }
        });
        getContentPane().add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 50, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/chat/ui/image/ServerHome.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHistoryMouseClicked
        try {

            ArrayList<String> list = loggerF.readLogs();
            HistoryFrame historyFrame = new HistoryFrame(list);
            historyFrame.setVisible(true);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());    
        }
    }//GEN-LAST:event_lblHistoryMouseClicked

    private void btnConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectionActionPerformed

        if (btnConnection.getText().equalsIgnoreCase("Establish Connection")) {
            try {
                chatControllerImpl = new ChatControllerImpl(this);
                serverRegistry = LocateRegistry.createRegistry(5050);
                serverRegistry.rebind("ChatServer", chatControllerImpl);

                btnConnection.setText("Disconnect Server");
                txtServerPane.append("Server Started at : " + InetAddress.getLocalHost() + "\n");
            } catch (RemoteException ex) {
                txtServerPane.append(ex.getMessage());
            } catch (UnknownHostException ex) {
                ex.getMessage();
            }
            DateFormat dateFormat;
            Date date = new Date();
            dateFormat = new SimpleDateFormat("HH:mm:ss");
            lblStime2.setText(dateFormat.format(date));
            lblCstatus.setText("Running...");
        } else {
            shutDownServer();

        }

    }//GEN-LAST:event_btnConnectionActionPerformed

    private void lblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserMouseClicked
        try {
            ArrayList<User> list = signUpF.readUsers();
            new UserFrame(list).setVisible(true);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());     
        }
    }//GEN-LAST:event_lblUserMouseClicked

    private void lblMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMessageMouseClicked
        try {
            String message = JOptionPane.showInputDialog(this, "Message here", "Server", 1);
            chatControllerImpl.sendMessage("SERVICE", "SERVER ADMI", "ALL", message);
        } catch (RemoteException ex) {
           System.out.println(ex.getMessage());    
        }
    }//GEN-LAST:event_lblMessageMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCstatus;
    private javax.swing.JLabel lblEndTime;
    private javax.swing.JLabel lblEtime;
    private javax.swing.JLabel lblHistory;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblNowOnline;
    private javax.swing.JLabel lblStartTime;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStime2;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextArea txtServerPane;
    // End of variables declaration//GEN-END:variables

    public void plusList(String name, String ip) {
        try {
            onlineClients++;
            dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String log = name + " Loged In from : " + ip + " At : " + (dateFormat.format(date));
            txtServerPane.append(log + "\n");
            lblNowOnline.setText(onlineClients + " People Online");
            loggerF.writeLogs(log);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());    
        }
    }

    public void reduseList(String name, String ip) {
        try {
            onlineClients--;
            dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String log = name + " Loged out from : " + ip + " At : " + (dateFormat.format(date));
            txtServerPane.append(log + "\n");
            lblNowOnline.setText(onlineClients + " People Online");
            loggerF.writeLogs(log);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());    
        }
    }

    public void writeSignUp(String username, String password) {
        try {
            signUpF.writeUsers(username, password);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());    
        }
    }

    public void writeContact(String owner, String friend) {
        try {
            ArrayList<String> fList = contactF.readFriends(owner);
            boolean isAlreadyExists = false;
            for (String name : fList) {
                if (name.equalsIgnoreCase(friend)) {
                    isAlreadyExists = true;
                }
            }
            if (!isAlreadyExists) {
                System.out.println(isAlreadyExists);
                contactF.writeUsers(owner, friend);
            }

        } catch (IOException ex) {
           System.out.println(ex.getMessage());    
        }
    }

    public void writeContactTo(String owner, ArrayList<String> fList) {

    }

    public boolean checkForUsers(String userName, String password) {
        boolean isUser = false;
        try {
            ArrayList<User> list = signUpF.readUsers();
            for (User user : list) {
                if (userName.equalsIgnoreCase(user.getUserName())) {
                    System.out.println("userName " + userName + " saved " + user.getUserName());
                    if (password.equals(user.getPassWord())) {
                        System.out.println(password + "  " + user.getPassWord());
                        isUser = true;
                    }
                }
            }
        } catch (IOException ex) {
           System.out.println(ex.getMessage());    
        }
        System.out.println(isUser);
        return isUser;
    }

    public boolean checkForUsername(String userName) {
        boolean isExist = false;
        try {

            ArrayList<User> list = signUpF.readUsers();
            for (User user : list) {
                if (userName.equalsIgnoreCase(user.getUserName())) {
                    isExist = true;
                }
            }
            return isExist;
        } catch (IOException ex) {
           System.out.println(ex.getMessage());    
        }
        return isExist;
    }

    public List<String> readContactList(String owner) {
        List<String> list = new ArrayList<>();
        try {
            list = contactF.readFriends(owner);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public void writeMessage(String sender, String reciever, String content) {
        try {
            messageF.writeMsg(sender, reciever, content);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());    
        }
    }

    public List<String> viewChatOnDay(String date, String sender, String reciever) {
        ArrayList<String> chat = new ArrayList<>();
        try {
            ArrayList<Messages> readMsg = messageF.readMsg(date, sender, reciever);
            for (Messages msg : readMsg) {
                String newTxt = (msg.getSender() + " : " + msg.getContent() + "\n" + "\t\t" + msg.getTime());
                chat.add(newTxt);
            }
        } catch (IOException ex) {
           System.out.println(ex.getMessage());    
        }
        return chat;
    }

    private void shutDownServer() {
        try {
            DateFormat dateFormat;
            Date date = new Date();
            btnConnection.setText("Establish Connection");
            dateFormat = new SimpleDateFormat("HH:mm:ss");
            lblEtime.setText(dateFormat.format(date));
            lblCstatus.setText("Stoped...");
            serverRegistry.unbind("ChatServer");
            UnicastRemoteObject.unexportObject(serverRegistry, true);
            txtServerPane.append("Server Stoped at : " + InetAddress.getLocalHost() + "\n");

        } catch (RemoteException | NotBoundException | UnknownHostException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
