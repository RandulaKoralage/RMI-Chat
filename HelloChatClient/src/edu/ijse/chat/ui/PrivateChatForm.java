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
import edu.ijse.chat.util.CreateSounds;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Randula
 */
public class PrivateChatForm extends javax.swing.JFrame {

    public File file;
    private String sender;
    private String reciever;
    private ChatObserver chatObserver;
    private CreateSounds sounds;
    private String name;

    /**
     * Creates new form PrivateChatForm
     */
    public PrivateChatForm() {
        initComponents();
    }

    PrivateChatForm(String sender, String reciever) {
        initComponents();
        this.sender = sender;
        this.reciever = reciever;
        this.name = sender;
        setTitle(sender + " Chat with " + reciever);
        this.sounds = new CreateSounds();
        try {
            chatObserver = new ChatObserverImpl(this);

            ChatController chatController = ServerConnector.getServerConnector().getChatController();
            chatController.addPrivateChatObserver(chatObserver, sender, reciever);

            checkfriends(sender);
            setMessageHistory(sender, reciever);
            setMessageHistory(reciever, sender);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
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

        pane = new javax.swing.JScrollPane();
        txtChatSpace = new javax.swing.JTextArea();
        txtType = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        lblAttachment = new javax.swing.JLabel();
        lblFilePath = new javax.swing.JLabel();
        lblSend = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chat With");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pane.setOpaque(false);

        txtChatSpace.setEditable(false);
        txtChatSpace.setColumns(20);
        txtChatSpace.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtChatSpace.setForeground(new java.awt.Color(255, 51, 51));
        txtChatSpace.setRows(5);
        pane.setViewportView(txtChatSpace);

        getContentPane().add(pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 300, 320));

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
        getContentPane().add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 230, 40));

        btnSend.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSend.setText("Send");
        btnSend.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSend.setContentAreaFilled(false);
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        getContentPane().add(btnSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 70, 40));

        lblAttachment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/chat/ui/images/attach.png"))); // NOI18N
        lblAttachment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAttachmentMouseClicked(evt);
            }
        });
        getContentPane().add(lblAttachment, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, 40));
        getContentPane().add(lblFilePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 300, 20));

        lblSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/chat/ui/images/ok.png"))); // NOI18N
        lblSend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSendMouseClicked(evt);
            }
        });
        getContentPane().add(lblSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 40, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/chat/ui/images/privateChat.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTypeFocusGained
        txtType.setFont(new Font("Comic Sans MS", 0, 12));
        txtType.setText(null);
    }//GEN-LAST:event_txtTypeFocusGained

    private void lblAttachmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAttachmentMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showDialog(this, "Select File");
        file = fileChooser.getSelectedFile();

        if (file != null) {
            if (!file.getName().isEmpty()) {
                String str;

                if (lblFilePath.getText().length() > 30) {
                    String t = file.getPath();
                    str = t.substring(0, 20) + " [...] " + t.substring(t.length() - 20, t.length());
                } else {
                    str = file.getPath();
                }
                lblFilePath.setText(str);
            }
        }
    }//GEN-LAST:event_lblAttachmentMouseClicked

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        actionStart();
    }//GEN-LAST:event_btnSendActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            ChatController chatController = ServerConnector.getServerConnector().getChatController();
            chatController.sendMessage("PRIVATE", sender, reciever, "EXIT");
            chatController.removePrivateChatObserver(chatObserver, sender, reciever);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing

    private void lblSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSendMouseClicked
        sendFile();
    }//GEN-LAST:event_lblSendMouseClicked

    private void txtTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTypeActionPerformed
        actionStart();
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
            java.util.logging.Logger.getLogger(PrivateChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrivateChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrivateChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrivateChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrivateChatForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAttachment;
    private javax.swing.JLabel lblFilePath;
    private javax.swing.JLabel lblSend;
    private javax.swing.JScrollPane pane;
    private javax.swing.JTextArea txtChatSpace;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables

    public void setMessage(String sender, String reciever, String content) {

        if (this.name.equals(sender) && this.reciever.equals(reciever)) {

            txtChatSpace.append("Me" + " : " + content + "\n");
        }
        if (this.name.equals(reciever) && this.reciever.equals(sender)) {

            txtChatSpace.append(sender + " : " + content + "\n");
           // sounds.playSound("Pop.wav");
        }
    }

    public void checkfriends(String sender) {
        try {
            ChatController chatController = ServerConnector.getServerConnector().getChatController();
            chatController.saveContact(reciever, sender);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setMessageHistory(String sender, String reciever) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date date = new Date();
            String todate = dateFormat.format(date);

            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            Date todate1 = cal.getTime();
            String fromdate = dateFormat.format(todate1);

            ChatController chatController = ServerConnector.getServerConnector().getChatController();
            ArrayList<String> list = (ArrayList<String>) chatController.viewDaysChat(fromdate, sender, reciever);

            for (String s : list) {
                txtChatSpace.append(s + "\n");
            }

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void sendFile() {
        long size = file.length();
        boolean isSent = false;

        try {
            ChatController chatController = ServerConnector.getServerConnector().getChatController();

            FileInputStream in = new FileInputStream(file);
            byte[] mydata = new byte[1024 * 1024];
            int mylen = in.read(mydata);
            while (mylen > 0) {
                isSent = chatController.sendDocument(sender, reciever, file.getName(), mydata, mylen);
                mylen = in.read(mydata);
            }
            System.out.println(isSent);
            if (isSent) {
                JOptionPane.showMessageDialog(this, "Successfully Delivered", "Delivery", 1);
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(PrivateChatForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(PrivateChatForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(PrivateChatForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrivateChatForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PrivateChatForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean recieveFile(String sender, String reciever, String filePath, byte[] data, int len) {
        boolean isRecieved = false;
        if (this.sender.equalsIgnoreCase(reciever)) {
            if (JOptionPane.showConfirmDialog(this, ("Accept this file from " + sender + " ?")) == 0) {
                FileOutputStream out = null;
                try {
                    JFileChooser jf = new JFileChooser();
                    jf.setSelectedFile(new File(filePath));
                    int returnVal = jf.showSaveDialog(this);
                    String saveTo = jf.getSelectedFile().getPath();

                    File f = new File(saveTo);
                    f.createNewFile();
                    out = new FileOutputStream(f, true);
                    out.write(data, 0, len);
                    out.flush();
                    out.close();

                    System.out.println("Done writing data...");
                    isRecieved = true;
                    JOptionPane.showMessageDialog(this, "Done writing data...", "Delivery", 1);

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PrivateChatForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(PrivateChatForm.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        out.close();
                    } catch (IOException ex) {
                        Logger.getLogger(PrivateChatForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return isRecieved;
    }

    public void setExitMessage(String sender, String reciever, String content) {
        if (this.sender.equals(reciever) && this.reciever.equals(sender)) {
            txtChatSpace.append(sender + " ...LEAVE THE CONVERSATION....");
            txtType.setEditable(false);
            btnSend.setEnabled(false);
            lblFilePath.setEnabled(false);
            lblAttachment.setEnabled(false);
        }
    }

    private void actionStart() {
                   
     if(!txtType.getText().equals("")) {
            try {
                ChatController chatController = ServerConnector.getServerConnector().getChatController();
                chatController.sendMessage("PRIVATE", sender, reciever, txtType.getText());
                chatController.saveMessage(sender, reciever, txtType.getText());
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
