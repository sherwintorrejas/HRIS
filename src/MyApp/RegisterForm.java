/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApp;

import static internalPage.manageUser.table;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Image;
import java.io.File;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;
import newpackage.dbconnector;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author USER
 */
public class RegisterForm extends javax.swing.JFrame {

    /**
     * Creates new form RegisterForm
     */
    public RegisterForm() {
        initComponents();

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    public void displayData() {

        try {

            dbconnector dbc = new dbconnector();
            ResultSet rs = dbc.getData("SELECT * FROM brgy_emp");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            System.out.println("Error Message: " + ex);

        }
    }

   

    public  String doHashing(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            messageDigest.update(password.getBytes());
            byte[] resultByteArray = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    
    String gender;

    int validateRegister() {
        int result;
        if (fname.getText().isEmpty() || lname.getText().isEmpty() || setUser.getText().isEmpty() || setPass.getText().isEmpty() || email.getText().isEmpty()||imageChooser.getIcon()==null) {
            result = 0;
        } else {
            result = 1;
        }
        return result;
    }

    Color navcolor = new Color(22, 123, 123);
    Color headcolor = new Color(0, 102, 102);
    Color bodycolor = new Color(204, 204, 204);
    Border empty = BorderFactory.createEmptyBorder();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        setUser = new javax.swing.JTextField();
        setPass = new javax.swing.JPasswordField();
        address = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        female = new javax.swing.JRadioButton();
        male = new javax.swing.JRadioButton();
        nationality = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        profile = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        imageChooser = new javax.swing.JLabel();
        position = new javax.swing.JComboBox<>();
        lname = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        date = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 0));
        jPanel1.setLayout(null);

        setUser.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jPanel1.add(setUser);
        setUser.setBounds(160, 260, 260, 40);

        setPass.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        setPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setPassActionPerformed(evt);
            }
        });
        jPanel1.add(setPass);
        setPass.setBounds(160, 310, 260, 40);

        address.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jPanel1.add(address);
        address.setBounds(160, 360, 260, 40);

        email.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jPanel1.add(email);
        email.setBounds(160, 410, 260, 40);

        female.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        jPanel1.add(female);
        female.setBounds(270, 460, 110, 50);

        male.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        jPanel1.add(male);
        male.setBounds(170, 460, 90, 50);

        nationality.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        nationality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afghanistan", "Åland Islands", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia (Plurinational State of)", "Bonaire, Sint Eustatius and Saba", "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, Democratic Republic of the", "Cook Islands", "Costa Rica", "Côte d'Ivoire", "Croatia", "Cuba", "Curaçao", "Cyprus", "Czechia", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard Island and McDonald Islands", "Holy See", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Isle of Man", "Israel", "Italy", "Jamaica", "Japan", "Jersey", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea (Democratic People's Republic of)", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macao", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia (Federated States of)", "Moldova, Republic of", "Monaco", "Mongolia", "Montenegro", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "North Macedonia", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Palestine, State of", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Réunion", "Romania", "Russian Federation", "Rwanda", "Saint Barthélemy", "Saint Helena, Ascension and Tristan da Cunha", "Saint Kitts and Nevis", "Saint Lucia", "Saint Martin (French part)", "Saint Pierre and Miquelon", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Sint Maarten (Dutch part)", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Svalbard and Jan Mayen", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Timor-Leste", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom of Great Britain and Northern Ireland", "United States of America", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela (Bolivarian Republic of)", "Viet Nam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna", "Western Sahara", "Yemen", "Zambia", "Zimbabwe" }));
        jPanel1.add(nationality);
        nationality.setBounds(660, 350, 180, 50);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("REGISTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(720, 520, 160, 50);

        profile.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        profile.setText("CHOOSE IMAGE//");
        profile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });
        jPanel1.add(profile);
        profile.setBounds(490, 150, 170, 50);

        jPanel2.setBackground(new java.awt.Color(51, 255, 255));
        jPanel2.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(153, 255, 204));
        jPanel8.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("REGISTRATION FORM");
        jPanel8.add(jLabel6);
        jLabel6.setBounds(60, 20, 270, 40);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(260, 10, 370, 80);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("HUMAN RESOURCE INFOMATION SYSTEM");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(280, 100, 350, 30);
        jPanel2.add(jLabel11);
        jLabel11.setBounds(40, -20, 180, 180);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel10.setText("—");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel11.add(jLabel10);
        jLabel10.setBounds(20, 0, 40, 50);

        close.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setText("x");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel11.add(close);
        close.setBounds(40, 0, 70, 50);

        jPanel2.add(jPanel11);
        jPanel11.setBounds(800, 0, 100, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 910, 140);

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setText("RESET");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(560, 520, 150, 50);

        imageChooser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(imageChooser);
        imageChooser.setBounds(680, 140, 180, 160);

        position.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager ", "Accountant", "Security ", "Janitor" }));
        jPanel1.add(position);
        position.setBounds(170, 530, 220, 40);

        lname.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jPanel1.add(lname);
        lname.setBounds(160, 210, 260, 40);

        fname.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jPanel1.add(fname);
        fname.setBounds(160, 160, 260, 40);
        jPanel1.add(date);
        date.setBounds(660, 410, 180, 50);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("First name:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(-10, 160, 160, 40);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Last name:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(-10, 210, 160, 40);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Username:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-10, 260, 160, 40);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Password:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(-30, 310, 180, 40);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Address:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 360, 150, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Email:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(-10, 410, 160, 40);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText(" Gender:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 470, 130, 30);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Positon:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(30, 530, 114, 34);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Nationality:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(490, 360, 160, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Date of Birth:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(470, 420, 180, 28);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        female.setSelected(false);
        if (male.isSelected()) {
            gender = "Male";
        } else {
            gender = null;
        }
    }//GEN-LAST:event_maleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        male.setSelected(false);
        if (female.isSelected()) {
            gender = "female";
        } else {
            gender = null;
        }
    }//GEN-LAST:event_femaleActionPerformed

    private void setPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setPassActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int check = validateRegister();
        if (check == 1) {
            dbconnector dbc = new dbconnector();
            String password = setPass.getText();
            String hash = BCrypt.hashpw(password, BCrypt.gensalt());
            int result = dbc.insertData("INSERT INTO tbl_acc(a_fname,a_lname,a_username,a_password,a_address,a_email,a_gender,a_position,a_nationality,a_DOB,a_image,a_status)VALUES('" + lname.getText() + "','"
                    + fname.getText() + "','" + setUser.getText() + "','" + hash + "','" + address.getText() + "','"
                    + address.getText() + "','" + gender + "','" + position.getSelectedItem() + "','"
                    + nationality.getSelectedItem() + "','" + date.getDate() + "','" + profile.getIcon() + "','" +"Pending" + "')");
                 
            if (result == 1) {
                JOptionPane.showMessageDialog(null, "SUCCESSFULLY SAVE!");
            } else {
                System.out.println("Saving data failed!");

            }
        } else {
            JOptionPane.showMessageDialog(null, "all fields are required!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        
        JFileChooser browseImageFile = new JFileChooser();

        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "pnp", "jpg", "jpeg", "gif");
        browseImageFile.addChoosableFileFilter(fnef);
        int showOpenDialogue = browseImageFile.showOpenDialog(null);
        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();
            String selectedImagePath = selectedImageFile.getAbsolutePath();
            JOptionPane.showMessageDialog(null, selectedImagePath);

            ImageIcon ii = new ImageIcon(selectedImagePath);
            Image image = ii.getImage().getScaledInstance(imageChooser.getWidth(), imageChooser.getHeight(), Image.SCALE_SMOOTH);
            imageChooser.setIcon(new ImageIcon(image));

        }
    }//GEN-LAST:event_profileActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        int b = JOptionPane.showConfirmDialog(null, "Confirm Exit?");
        if (b == JOptionPane.YES_OPTION) {
            LogIn lg = new LogIn();
            this.dispose();
            lg.setVisible(true);
        }
    }//GEN-LAST:event_closeMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_jLabel10MouseClicked

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
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JLabel close;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextField email;
    private javax.swing.JRadioButton female;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel imageChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField lname;
    private javax.swing.JRadioButton male;
    private javax.swing.JComboBox<String> nationality;
    private javax.swing.JComboBox<String> position;
    public static javax.swing.JButton profile;
    public static javax.swing.JPasswordField setPass;
    public static javax.swing.JTextField setUser;
    // End of variables declaration//GEN-END:variables
}