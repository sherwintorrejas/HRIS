/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import MyApp.FirstFrame;
import static MyApp.FirstFrame.body;
import internalPage.manageUser;
import static internalPage.manageUser.table;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import newpackage.dbconnector;

/**
 *
 * @author SCC-PC01
 */
public class Add extends javax.swing.JFrame {

    /**
     * Creates new form Add
     */
    public Add() {
        initComponents();
        displayData();
    }
    public String gender;
    public String action;

    public void displayData() {

        try {

            dbconnector dbc = new dbconnector();
            ResultSet rs = dbc.getData("SELECT * FROM hris_emp");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            System.out.println("Error Message: " + ex);

        }
    }

    public void close() {
        this.dispose();
        FirstFrame fm = new FirstFrame();
        fm.setVisible(true);
        manageUser mu = new manageUser();
        FirstFrame.body.add(mu).setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        emp_id = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        add = new javax.swing.JTextField();
        radiomale = new javax.swing.JRadioButton();
        radiofemale = new javax.swing.JRadioButton();
        status = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        process = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        position = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));
        jPanel2.setLayout(null);

        minimize.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("—");
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        jPanel2.add(minimize);
        minimize.setBounds(600, 0, 40, 29);

        close.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setText("x");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel2.add(close);
        close.setBounds(640, 0, 40, 29);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ADD PEOPLE INFO");
        jPanel8.add(jLabel8);
        jLabel8.setBounds(40, 10, 250, 40);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(180, 10, 310, 60);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("BARANGAY TIMESHEET MANAGEMENT SYSTEM");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(90, 80, 500, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 690, 140);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setText("Gender:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(360, 270, 80, 30);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setText("Id:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 170, 40, 30);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setText("position:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 330, 100, 40);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setText("Last name:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 220, 100, 40);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setText("Address:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(360, 170, 80, 30);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setText("Status:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(360, 210, 80, 30);

        emp_id.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jPanel1.add(emp_id);
        emp_id.setBounds(130, 170, 150, 40);

        lname.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jPanel1.add(lname);
        lname.setBounds(130, 220, 180, 40);

        fname.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jPanel1.add(fname);
        fname.setBounds(130, 280, 180, 40);

        add.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add);
        add.setBounds(460, 160, 190, 40);

        radiomale.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        radiomale.setText("Male");
        radiomale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiomaleActionPerformed(evt);
            }
        });
        jPanel1.add(radiomale);
        radiomale.setBounds(470, 270, 90, 31);

        radiofemale.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        radiofemale.setText("Female");
        radiofemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiofemaleActionPerformed(evt);
            }
        });
        jPanel1.add(radiofemale);
        radiofemale.setBounds(560, 270, 110, 31);

        status.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel1.add(status);
        status.setBounds(460, 210, 190, 40);

        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(390, 390, 130, 50);

        process.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        process.setText("CONTINUE");
        process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processActionPerformed(evt);
            }
        });
        jPanel1.add(process);
        process.setBounds(530, 390, 130, 50);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setText("First name:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 280, 100, 40);

        position.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager ", "Accountant", "Security ", "Janitor" }));
        jPanel1.add(position);
        position.setBounds(130, 340, 180, 40);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hrisrevised.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(150, 110, 360, 370);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        int x = JOptionPane.showConfirmDialog(null, "CONFIRM EXIT?");
        if (x == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_closeMouseClicked

    private void radiomaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiomaleActionPerformed
        radiofemale.setSelected(false);
        if (radiomale.isSelected()) {
            gender = "Male";
        } else {
            gender = null;
        }
    }//GEN-LAST:event_radiomaleActionPerformed

    private void radiofemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiofemaleActionPerformed
        radiomale.setSelected(false);
        if (radiofemale.isSelected()) {
            gender = "female";
        } else {
            gender = null;
        }
    }//GEN-LAST:event_radiofemaleActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        close();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void processActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processActionPerformed
        if (action.equals("add")) {
            dbconnector dbc = new dbconnector();
            int result = dbc.insertData("INSERT INTO hris_emp(emp_lname,emp_fname,emp_position,emp_address,emp_status,emp_gender)VALUES('" + lname.getText() + "','" + fname.getText() + "','" + position.getSelectedItem() + "','" + add.getText() + "','" + status.getSelectedItem() + "','" + gender + "')");
            if (result == 1) {
                JOptionPane.showMessageDialog(null, "SUCCESSFULLY SAVE!");
                close();
            }
        } else if (action.equals("update")) {
            dbconnector dbc = new dbconnector();
            dbc.updateData("UPDATE hris_emp "
                    + "SET emp_lname = '" + lname.getText() + "', emp_fname='" + fname.getText() + "', emp_position='" + position.getSelectedItem() + "', emp_address='" + add.getText() + "', "
                    + "emp_status ='" + status.getSelectedItem() + "', emp_gender='" + gender + "'  "
                    + "WHERE emp_id = '" + emp_id.getText() + "'");
            displayData();
            close();

    }//GEN-LAST:event_processActionPerformed
    }

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField add;
    private javax.swing.JLabel close;
    public javax.swing.JTextField emp_id;
    public static javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    public static javax.swing.JTextField lname;
    private javax.swing.JLabel minimize;
    public static javax.swing.JComboBox<String> position;
    public static javax.swing.JButton process;
    public static javax.swing.JRadioButton radiofemale;
    public static javax.swing.JRadioButton radiomale;
    public static javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}
