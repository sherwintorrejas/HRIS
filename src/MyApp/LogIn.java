package MyApp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BasicStroke;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author USER
 */
public class LogIn extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    public LogIn() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

    }
    private Connection connection;

    Color hover = new Color(204, 204, 204);
    Color defbutton = new Color(22, 123, 123);

    Border empty = BorderFactory.createEmptyBorder();

    void buttonBorderAnimation(JPanel panel) {
        panel.setBackground(hover);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f)));
    }

    void buttonDefaultColor(JPanel panel) {
        panel.setBackground(defbutton);
        panel.setBorder(empty);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        cancel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        logIn = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        hideMouse = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        cancel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        logIn1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        minimize1 = new javax.swing.JLabel();
        close1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/images.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 320, 190));

        jPanel4.setBackground(new java.awt.Color(153, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(153, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WELCOME ");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 670, 40));

        close.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setText("x");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel4.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 40, 40));

        minimize.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("—");
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        jPanel4.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 50, 40));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 40));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("Username:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 110, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Password:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 110, -1));

        password.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 250, 40));

        cancel.setBackground(new java.awt.Color(204, 255, 204));
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelMouseExited(evt);
            }
        });
        cancel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CANCEL");
        cancel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 40));

        jPanel2.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 120, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Dont have account? Click here..");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 340, 30));

        logIn.setBackground(new java.awt.Color(204, 255, 204));
        logIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logInMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logInMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logInMouseExited(evt);
            }
        });
        logIn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LOG IN");
        logIn.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 40));

        jPanel2.add(logIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 120, 40));

        hideMouse.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        hideMouse.setText("ad");
        hideMouse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hideMouseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                hideMouseMouseReleased(evt);
            }
        });
        jPanel2.add(hideMouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 90, 20));

        username.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 250, 40));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 820, 430);

        jPanel5.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 300, 270));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Bradley Hand ITC", 1, 36)); // NOI18N
        jLabel8.setText("LOG IN HERE:");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 280, 70));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 300, 70));
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 430));

        jPanel5.add(jPanel6);
        jPanel6.setBounds(0, 0, 430, 430);

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setLayout(null);

        cancel1.setBackground(new java.awt.Color(22, 123, 123));
        cancel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancel1MouseExited(evt);
            }
        });
        cancel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel10.setText("CANCEL");
        cancel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 50));

        jPanel8.add(cancel1);
        cancel1.setBounds(80, 270, 120, 50);

        logIn1.setBackground(new java.awt.Color(22, 123, 123));
        logIn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logIn1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logIn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logIn1MouseExited(evt);
            }
        });
        logIn1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel11.setText("OKAY");
        logIn1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 50));

        jPanel8.add(logIn1);
        logIn1.setBounds(220, 270, 120, 50);

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel12.setText("Dont have account? Register here..");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel12);
        jLabel12.setBounds(50, 350, 330, 30);

        minimize1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        minimize1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize1.setText("—");
        minimize1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimize1MouseClicked(evt);
            }
        });
        jPanel8.add(minimize1);
        minimize1.setBounds(290, 0, 50, 40);

        close1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        close1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close1.setText("x");
        close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close1MouseClicked(evt);
            }
        });
        jPanel8.add(close1);
        close1.setBounds(340, 0, 40, 40);

        jPanel5.add(jPanel8);
        jPanel8.setBounds(430, 0, 390, 430);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 0, 0, 0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered
        buttonBorderAnimation(cancel);
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited
        buttonDefaultColor(cancel);
    }//GEN-LAST:event_cancelMouseExited

    private void logInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInMouseEntered
        buttonBorderAnimation(logIn);
    }//GEN-LAST:event_logInMouseEntered

    private void logInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInMouseExited
        buttonDefaultColor(logIn);
    }//GEN-LAST:event_logInMouseExited

    private void logInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInMouseClicked
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hris", "root", "");
           
            String Username = username.getText();
            String Password = password.getText();

            Statement stm = connection.createStatement();
            String sql = "select * from tbl_acc where a_username = '"+username.getText()+"'AND a_status = 'active'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                String hash = rs.getString("a_password");
                if (BCrypt.checkpw(Password, hash)) {
                    FirstFrame fm = new FirstFrame();
                    this.dispose();
                    fm.setVisible(true);

                }else{
                    System.out.println("Invalid Account!");
                }
             
            } else {
                JOptionPane.showMessageDialog(null, "Username or password wrong");
                username.setText("");
                password.setText("");
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_logInMouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        int x = JOptionPane.showConfirmDialog(null, "CONFIRM EXIT?");
        if (x == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_closeMouseClicked

    private void hideMouseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseMousePressed
      
        hideMouse.setVisible(false);
        password.setEchoChar((char) 0);
    }//GEN-LAST:event_hideMouseMousePressed

    private void hideMouseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseMouseReleased
       
        hideMouse.setVisible(true);
        password.setEchoChar('*');
    }//GEN-LAST:event_hideMouseMouseReleased

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        RegisterForm rs = new RegisterForm();
        this.dispose();
        rs.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void cancel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseEntered
        buttonBorderAnimation(cancel);
    }//GEN-LAST:event_cancel1MouseEntered

    private void cancel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseExited
        buttonDefaultColor(cancel);
    }//GEN-LAST:event_cancel1MouseExited

    private void logIn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logIn1MouseClicked

        FirstFrame fm = new FirstFrame();
        this.dispose();
        fm.setVisible(true);
    }//GEN-LAST:event_logIn1MouseClicked

    private void logIn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logIn1MouseEntered
        buttonBorderAnimation(logIn);
    }//GEN-LAST:event_logIn1MouseEntered

    private void logIn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logIn1MouseExited
        buttonDefaultColor(logIn);
    }//GEN-LAST:event_logIn1MouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        RegisterForm rs = new RegisterForm();
        this.dispose();
        rs.setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void minimize1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize1MouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_minimize1MouseClicked

    private void close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseClicked
        int x = JOptionPane.showConfirmDialog(null, "CONFIRM EXIT?");
        if (x == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_close1MouseClicked

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cancel;
    private javax.swing.JPanel cancel1;
    private javax.swing.JLabel close;
    private javax.swing.JLabel close1;
    private javax.swing.JLabel hideMouse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel logIn;
    private javax.swing.JPanel logIn1;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel minimize1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
