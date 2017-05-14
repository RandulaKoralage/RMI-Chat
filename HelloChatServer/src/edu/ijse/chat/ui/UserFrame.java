package edu.ijse.chat.ui;

import edu.ijse.chat.data.User;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class UserFrame extends javax.swing.JFrame {
    private DefaultTableModel dtm;
  
    public UserFrame(ArrayList<User> list) {
        initComponents();
        setTable(list);
        
    }
    public void setTable(ArrayList<User> list){
        dtm = new DefaultTableModel();
        dtm = (DefaultTableModel) tblUser.getModel();
        dtm.setRowCount(0);
        for (User user : list) {
            Object[] rows = {user.getUserName(),user.getSignUpDate()};
            dtm.addRow(rows);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Joined Users");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Joined Users :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "User Name", "Joine Date"
            }
        ));
        tblUser.setFillsViewportHeight(true);
        jScrollPane2.setViewportView(tblUser);
        if (tblUser.getColumnModel().getColumnCount() > 0) {
            tblUser.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 470, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblUser;
    // End of variables declaration//GEN-END:variables
}
