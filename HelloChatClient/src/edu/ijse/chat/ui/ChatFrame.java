/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.chat.ui;

import edu.ijse.chat.connector.ServerConnector;
import edu.ijse.chat.controller.ChatController;
import edu.ijse.chat.observer.ChatObserver;
import edu.ijse.chat.observer.ChatObserverImpl;
import java.awt.Font;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Randula
 */
public class ChatFrame extends javax.swing.JFrame {

    /**
     * Creates new form ChatFrame
     */
    private String name;
    private ChatObserver chatObserver;
    private SignUp signUp;
    private String user;

    public ChatFrame() {
        initComponents();
        arrangeComponents();
    }

    @Override
    public String toString() {
        return name;
    }

    public ChatFrame(String name, String membership) {

        try {
            initComponents();
            arrangeComponents();
            this.name = name;
            lblName.setText("Hello " + name);
            signUp = new SignUp(name);
            switch (membership) {
                case "Guest":
                    lblGroup.setEnabled(false);
                    this.user = "Guest";
                    break;
                case "Joined":
                    this.user = "Joined";
                    lblSignup.setEnabled(false);
                    setChatList(name);
            }
            try {
                chatObserver = new ChatObserverImpl(this);
                ChatController chatController
                        = ServerConnector.getServerConnector()
                        .getChatController();
                chatController.addChatObserver(chatObserver, name,
                        InetAddress.getLocalHost() + " As a " + user);

            } catch (NotBoundException | MalformedURLException |
                    RemoteException | UnknownHostException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (NotBoundException | MalformedURLException |
                RemoteException ex) {
            System.err.print(ex.getMessage());
        }
    }

    private void arrangeComponents() {
        scpGroupList.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        scpGroupList = new javax.swing.JScrollPane();
        lstGroupList = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstOnlineList = new javax.swing.JList();
        lblOnlineList = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtChatSpace = new javax.swing.JTextArea();
        txtType = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        lblLogout = new javax.swing.JLabel();
        lblGroup = new javax.swing.JLabel();
        lblSignup = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lstGroupList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstGroupList.setInheritsPopupMenu(true);
        lstGroupList.setSelectionBackground(new java.awt.Color(255, 153, 153));
        lstGroupList.setSelectionForeground(new java.awt.Color(0, 0, 0));
        lstGroupList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lstGroupListFocusLost(evt);
            }
        });
        lstGroupList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstGroupListMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lstGroupListMousePressed(evt);
            }
        });
        scpGroupList.setViewportView(lstGroupList);

        getContentPane().add(scpGroupList, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 80, -1));

        lstOnlineList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lstOnlineList.setSelectionBackground(new java.awt.Color(255, 153, 153));
        lstOnlineList.setSelectionForeground(new java.awt.Color(0, 0, 0));
        lstOnlineList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstOnlineListMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lstOnlineListMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(lstOnlineList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 150, 440));

        lblOnlineList.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblOnlineList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOnlineList.setText("10 People Online");
        getContentPane().add(lblOnlineList, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 150, 30));

        txtChatSpace.setEditable(false);
        txtChatSpace.setColumns(20);
        txtChatSpace.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtChatSpace.setRows(5);
        txtChatSpace.setBorder(null);
        txtChatSpace.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jScrollPane2.setViewportView(txtChatSpace);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 670, 390));

        txtType.setFont(new java.awt.Font("Comic Sans MS", 2, 14)); // NOI18N
        txtType.setText("Type Your Message Here...");
        txtType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51)));
        txtType.setOpaque(false);
        txtType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTypeFocusGained(evt);
            }
        });
        txtType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTypeActionPerformed(evt);
            }
        });
        getContentPane().add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 590, 40));

        btnSend.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSend.setText("Send");
        btnSend.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSend.setContentAreaFilled(false);
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        getContentPane().add(btnSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 460, 70, 40));

        lblLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/chat/ui/images/logout.png"))); // NOI18N
        lblLogout.setToolTipText("LogOut");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });
        getContentPane().add(lblLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 40, 30));

        lblGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/chat/ui/images/group.png"))); // NOI18N
        lblGroup.setToolTipText("Group");
        lblGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGroupMouseClicked(evt);
            }
        });
        getContentPane().add(lblGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 40, 30));

        lblSignup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/chat/ui/images/signup.png"))); // NOI18N
        lblSignup.setToolTipText("SignUp");
        lblSignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSignupMouseClicked(evt);
            }
        });
        getContentPane().add(lblSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 40, 30));

        lblName.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(204, 0, 0));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 310, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/chat/ui/images/ChatHome.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 890, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTypeFocusGained
        txtType.setFont(new Font("Comic Sans MS", 0, 12));
        txtType.setText(null);
    }//GEN-LAST:event_txtTypeFocusGained

    private void lblGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGroupMouseClicked

        if (lblGroup.isEnabled()) {
            try {
                setChatList(name);
                if (scpGroupList.isVisible()) {
                    scpGroupList.setVisible(false);
                } else {
                    scpGroupList.setVisible(true);
                }
            } catch (NotBoundException | MalformedURLException |
                    RemoteException ex) {
                System.err.print(ex.getMessage());
            }
        }
    }//GEN-LAST:event_lblGroupMouseClicked

    private void lstGroupListFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lstGroupListFocusLost
        scpGroupList.setVisible(false);
    }//GEN-LAST:event_lstGroupListFocusLost

    private void lblSignupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignupMouseClicked
        if (lblSignup.isEnabled()) {
            try {
                SignUp signUp = new SignUp(name);
                signUp.setVisible(true);
                closeWindow();
                this.dispose();
            } catch (NotBoundException | MalformedURLException |
                    RemoteException | UnknownHostException ex) {
                System.err.print(ex.getMessage());
            }
        }
    }//GEN-LAST:event_lblSignupMouseClicked

    private void lstGroupListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstGroupListMouseClicked

        sendRequest();


    }//GEN-LAST:event_lstGroupListMouseClicked

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        try {
            actionStart();
        } catch (RemoteException | NotBoundException |
                MalformedURLException ex) {
            System.err.print(ex.getMessage());
        }

    }//GEN-LAST:event_btnSendActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed


    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            closeWindow();
        } catch (NotBoundException | MalformedURLException |
                RemoteException | UnknownHostException ex) {
            System.err.print(ex.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing

    private void lstOnlineListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstOnlineListMouseClicked

        if (lblGroup.isEnabled()) {
            try {
                String target = lstOnlineList.getSelectedValue().toString();
                boolean isExist = false;
                ChatController chatController
                        = ServerConnector.getServerConnector()
                        .getChatController();

                boolean isJoined = chatController.checkExistance(target);

                ArrayList<String> list
                        = (ArrayList<String>) chatController
                        .getFriendsList(name);
                for (String friend : list) {
                    if (friend.equalsIgnoreCase(target)) {
                        isExist = true;
                    }
                }

                if (!this.name.equals(target) && !isExist && isJoined) {
                    JOptionPane.showMessageDialog(this,
                            "Your Private Chat Request Sent to " + target,
                            "Request Sent", 1);

                    chatController.sendMessage("REQUEST", name,
                            target, "JOIN GROUP");
                } else if (!isJoined) {
                    JOptionPane.showMessageDialog(this,
                            "We do not allow you to chat with tempory chatters",
                            "Warning", 2);
                }
            } catch (NotBoundException | MalformedURLException |
                    RemoteException ex) {
                System.out.println(ex.getMessage());
            }

        } else {
            int res = JOptionPane.showConfirmDialog(this,
                    "Hi Guset ! " + "\n" + "Do you want to Signup as Permenent "
                    + "Chat Member to use this Service?");

            if (res == 0) {
                try {
                    signUp.setVisible(true);
                    closeWindow();
                    this.dispose();
                } catch (NotBoundException | MalformedURLException |
                        RemoteException | UnknownHostException ex) {
                    System.err.print(ex.getMessage());
                }
            }

        }
    }//GEN-LAST:event_lstOnlineListMouseClicked

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        try {
            closeWindow();
            this.dispose();
        } catch (NotBoundException | MalformedURLException |
                RemoteException | UnknownHostException ex) {
            System.err.print(ex.getMessage());
        }
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lstOnlineListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstOnlineListMousePressed

    }//GEN-LAST:event_lstOnlineListMousePressed

    private void lstGroupListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstGroupListMousePressed

    }//GEN-LAST:event_lstGroupListMousePressed

    private void txtTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTypeActionPerformed
        try {
            actionStart();
        } catch (RemoteException | NotBoundException |
                MalformedURLException ex) {
            System.err.print(ex.getMessage());
        }
    }//GEN-LAST:event_txtTypeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGroup;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOnlineList;
    private javax.swing.JLabel lblSignup;
    private javax.swing.JList lstGroupList;
    private javax.swing.JList lstOnlineList;
    private javax.swing.JScrollPane scpGroupList;
    private javax.swing.JTextArea txtChatSpace;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables

    public void setMessage(String msgType, String sender,
            String reciever, String content) {

        txtChatSpace.append(sender + " : " + content + "\n");

    }

    public void setOnlineList(List<String> userList) {
        String[] onlines = new String[userList.size()];
        onlines = userList.toArray(onlines);
        lstOnlineList.setListData(onlines);

        lblOnlineList.setText(userList.size() + " People Online");
    }

    public void viewRequest(String sender, String reciever) {
        if (this.name.equalsIgnoreCase(reciever)) {
            ChatRequest chatRequest = new ChatRequest(sender, reciever);
            chatRequest.setVisible(true);
        }
    }

    public void viewPrivate(String sender, String reciever) {
        if (this.name.equalsIgnoreCase(sender)) {
            PrivateChatForm privateChatForm
                    = new PrivateChatForm(sender, reciever);
            privateChatForm.setVisible(true);

        } else if (this.name.equalsIgnoreCase(reciever)) {
            PrivateChatForm privateChatForm
                    = new PrivateChatForm(reciever, sender);
            privateChatForm.setVisible(true);

        }
    }

    private void closeWindow() throws NotBoundException, MalformedURLException,
            RemoteException, UnknownHostException {

        ChatController chatController
                = ServerConnector.getServerConnector().getChatController();
        chatController.removeChatObserver(chatObserver,
                name, InetAddress.getLocalHost() + "");

    }

    public void setChatList(String owner) throws NotBoundException,
            MalformedURLException, RemoteException {

        ChatController chatController
                = ServerConnector.getServerConnector().getChatController();
        ArrayList<String> list
                = (ArrayList<String>) chatController.getFriendsList(owner);

        ArrayList<String> listNew = new ArrayList<>();
        for (String friend : list) {
            boolean isContains = chatController.getUserList(friend);
            if (!isContains) {
                friend = "<html>" + friend
                        + " <font color='green'>"
                        + "\t" + "(OFF)"
                        + "</font></html>";
                listNew.add(friend);
            } else {
                friend = "<html>" + friend
                        + " <font color='red'>"
                        + "\t" + "(ON)" + "</font></html>";
                listNew.add(friend);
            }
        }

        String[] group = new String[list.size()];
        group = listNew.toArray(group);
        lstGroupList.removeAll();
        lstGroupList.setListData(group);

    }

    public void tellIgnored(String reciever, String requester) {
        if (this.name.equalsIgnoreCase(requester)) {
            JOptionPane.showMessageDialog(this,
                    "Your Private Chat Request Ignored by " + reciever,
                    "Oops!", 0);
        }
    }

    private void actionStart() throws RemoteException,
            NotBoundException, MalformedURLException {
        if (txtType.getText() != null) {

            ChatController chatController
                    = ServerConnector.getServerConnector()
                    .getChatController();
            chatController.sendMessage("PUBLIC",
                    name, "ALL", txtType.getText());
        }
    }

    private void sendRequest() {
        String line = lstGroupList.getSelectedValue().toString();
        String[] parts = line.split("\t");

        String part1 = parts[0];
        String[] parts1 = part1.split("<html>");
        String part2 = parts1[1];

        String part0 = parts[1];
        String status = part0.substring(0, part0.length() - 14);

        if (status.equalsIgnoreCase("(OFF)")) {
            JOptionPane.showMessageDialog(this, "Friend curently Offline",
                    "Oops!", 1);
        } else {
            String target = part2.substring(0, part2.length() - 19);

            try {
                ChatController chatController
                        = ServerConnector.getServerConnector()
                        .getChatController();
                chatController.sendMessage("COMFIRM", name,
                        target, "JOINED GROUP");
            } catch (NotBoundException | MalformedURLException |
                    RemoteException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}