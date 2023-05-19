/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPage;

import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.table.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import newpackage.dbconnector;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.io.*;
import java.sql.*;
import java.awt.*;
import java.text.MessageFormat;
/**
 *
 * @author User
 */
public class add extends javax.swing.JInternalFrame {
 DefaultTableModel model;
Connection con;
    public String gender;
    /**
     * Creates new form add
     */
    public add() {
        initComponents();
        displayData();  
           this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
     
    }
        public void displayData() {

        try {

            dbconnector dbc = new dbconnector();
            ResultSet rs = dbc.getData("SELECT * FROM hris_emp");
            table.setModel(DbUtils.resultSetToTableModel(rs));
 DefaultTableModel model = (DefaultTableModel) table.getModel();
    String[] columnIdentifiers = {"ID", "Name", "Lastname", "Position","Address","Status", "Gender"};
    model.setColumnIdentifiers(columnIdentifiers);
        } catch (SQLException ex) {
            System.out.println("Error Message: " + ex);

        }
    }

    public void fillTable() throws SQLException {

        dbconnector dbc = new dbconnector();
        ResultSet rs = dbc.getData("SELECT * FROM hris_emp");
        table.setModel(DbUtils.resultSetToTableModel(rs));

    }
        
    
  public void reset(){
  id.setText("");
      lname.setText("");
   fname.setText("");
   status.setSelectedIndex(0);
   addrs.setText("");
   position.setSelectedIndex(0);
   FEMALE.setSelected(false);
      MALE.setSelected(false);
      prof.setIcon(null);
   }
   public void table(){
     int row = table.getSelectedRow();
     int cc = table.getSelectedColumn();
     String tc = table.getModel().getValueAt(row, 0).toString();
             try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hris", "root", "");
             String sql = "select * from hris_emp where emp_id="+tc+"";
             PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            int i=rs.getInt("emp_id");
            String name=rs.getString("emp_lname");
            String nme=rs.getString("emp_fname");
            String pos=rs.getString("emp_position");
            String addr=rs.getString("emp_address");
            String stat=rs.getString("emp_status");
             String gen=rs.getString("emp_gender");
            byte[] img = rs.getBytes("profile");
            format = new ImageIcon(img);
            Image im =format.getImage().getScaledInstance(prof.getWidth(), prof.getHeight(),Image.SCALE_SMOOTH);
            prof.setIcon(new ImageIcon(im));
            
            
                id.setText(""+i);
                lname.setText(name);
                fname.setText(nme);
                position.setSelectedItem(pos);
                addrs.setText(addr);
                status.setSelectedItem(stat);
               
   if (gen.equals("Male")) {
    MALE.setSelected(true);
     FEMALE.setSelected(false);
} else if (gen.equals("Female")) {
    FEMALE.setSelected(true);
     MALE.setSelected(false);
}      
         
            }
             ps.close();
             rs.close();
         } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
         }
   
        }
      public boolean validation(){
  String lastname= lname.getText();
String name= fname.getText();
String ads= addrs.getText();
 if (name.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER NAME");
 return false;
 }
 if(lastname.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER LASTNAME");
 return false;
 }
if(ads.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER COURSE");
 return false;
 } 

  return true;
    } 
      
      public boolean val(){
      if(prof.getIcon()==null){
      JOptionPane.showMessageDialog(this, "PLEASE ENTER PHOTO");
     return false;
     }
      return true;
      }
      public void upload(){
     JFileChooser chose = new JFileChooser();
     chose.showOpenDialog(null);
     File f = chose.getSelectedFile();
         filename = f.getAbsolutePath();
         ImageIcon ii = new ImageIcon(filename);
         Image img = ii.getImage().getScaledInstance(prof.getWidth(), prof.getHeight(), Image.SCALE_SMOOTH);
     prof.setIcon(new ImageIcon(img));
         try {
             File ig = new File(filename);
             FileInputStream is = new FileInputStream(ig);
             ByteArrayOutputStream bos =  new ByteArrayOutputStream();
             byte[] buf = new byte [1024];
             for (int rnum; (rnum = is.read(buf))!=-1;){
             bos.write(buf, 0, rnum);
             }
             pic=bos.toByteArray();
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
         }
          
    }
      
        public void adds(){
      String pos = (String) position.getSelectedItem();
       String stat = (String) status.getSelectedItem();   
        String gend;
    if (MALE.isSelected()) {
        gend = "Male";
    } else if (FEMALE.isSelected()) {
        gend= "Female";
    } else {
        gend = null;
    } 
         try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hris", "root", "");
            String sql = "INSERT INTO hris_emp(emp_lname,emp_fname,emp_position,emp_address,emp_status,emp_gender, profile)values (?,?,?,?,?,?,?)"; 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lname.getText());
            ps.setString(2, fname.getText());
            ps.setString(3, pos);
            ps.setString(4, addrs.getText());
              ps.setString(5, stat);
            ps.setString(6, gend);
            ps.setBytes(7, pic);
            ps.executeUpdate();
           
            displayData();
               reset(); 
        JOptionPane.showMessageDialog(this, "ADDED SUCCESSFULLY");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
     
     }
           public void update(){
        String pos = (String) position.getSelectedItem();
       String stat = (String) status.getSelectedItem();   
        String gen;
    if (MALE.isSelected()) {
        gen = "Male";
    } else if (FEMALE.isSelected()) {
        gen= "Female";
    } else {
        gen = null;
    } 
         
         try {
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hris", "root", "");
         int row = table.getSelectedRow();
         String value = (table.getModel().getValueAt(row, 0).toString());
         String sql = "UPDATE hris_emp SET emp_lname=?,emp_fname=?,emp_position=?,emp_address=?,emp_status=?,emp_gender=?, profile=? where emp_id="+value;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lname.getText());
            ps.setString(2, fname.getText());
            ps.setString(3, pos);
            ps.setString(4, addrs.getText());
              ps.setString(5, stat);
            ps.setString(6, gen);
            ps.setBytes(7, pic);
            ps.executeUpdate();
           
            ps.executeUpdate();
           if(row == 0){
            JOptionPane.showMessageDialog(null, "Updated FAILED!");
        }else{
           JOptionPane.showMessageDialog(null, "Updated Successfully!");
           displayData();
           reset();
        }
         } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        addrs = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        position = new javax.swing.JComboBox<>();
        status = new javax.swing.JComboBox<>();
        fname = new javax.swing.JTextField();
        MALE = new javax.swing.JRadioButton();
        FEMALE = new javax.swing.JRadioButton();
        prof = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 0));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("MANAGE EMPLOYEE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 540, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("HUMAN RESOURCE INFORMATION SYSTEM");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 79, 480, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 850, 110));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Lastname", "Position", "Address", "Status", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 480, 380));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 80, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 100, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 90, 30));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 80, 30));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("UPLOAD");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Id:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 40, 40));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Last name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 90, 40));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setText("First name:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 90, 40));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel8.setText("Status:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 60, 40));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setText("Address:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 80, 40));
        jPanel1.add(addrs, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 200, 30));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("position:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 80, 40));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel11.setText("Gender:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 80, 40));
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 200, 30));
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 200, 30));

        position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Accountant", "Security", "Janitor" }));
        jPanel1.add(position, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 200, 30));

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SINGLE", "MARRIED" }));
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 200, 30));
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 200, 30));

        MALE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MALE.setText("MALE");
        MALE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MALEActionPerformed(evt);
            }
        });
        jPanel1.add(MALE, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 70, -1));

        FEMALE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FEMALE.setText("FEMALE");
        FEMALE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FEMALEActionPerformed(evt);
            }
        });
        jPanel1.add(FEMALE, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, 90, -1));

        prof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prof.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(prof, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 130, 110));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hrisrevised.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 840, 390));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 594));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MALEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MALEActionPerformed
         FEMALE.setSelected(false);
        if (MALE.isSelected()) {
            gender = "Male";
        } else {
            gender = null;
        }
    }//GEN-LAST:event_MALEActionPerformed

    private void FEMALEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FEMALEActionPerformed
       MALE.setSelected(false);
        if (FEMALE.isSelected()) {
            gender = "Female";
        } else {
            gender = null;
        }
    }//GEN-LAST:event_FEMALEActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         int rowIndex = table.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please select a data first");
        } else {
            TableModel model = table.getModel();
            Object value = model.getValueAt(rowIndex, 0);
            String id = value.toString();
            int a = JOptionPane.showConfirmDialog(null, "Are you sure?");
            if (a == JOptionPane.YES_OPTION) {
                dbconnector dbc = new dbconnector();
                dbc.deleteData(Integer.parseInt(id));
                displayData();
                reset();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       upload();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  if(validation()== true && val()==true){
     adds();
        }     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(validation()== true && val()==true){
     update();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
      table();
    }//GEN-LAST:event_tableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       MessageFormat head = new MessageFormat("EMPLOYEE");
        MessageFormat FOOT = new MessageFormat("Page{0, number , integer}");

        try {
            table.print(JTable.PrintMode.NORMAL, head, FOOT);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "cannot print");
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton FEMALE;
    private javax.swing.JRadioButton MALE;
    private javax.swing.JTextField addrs;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lname;
    private javax.swing.JComboBox<String> position;
    private javax.swing.JLabel prof;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
String filename = null;
byte[] pic = null; 
private ImageIcon format = null;

}
