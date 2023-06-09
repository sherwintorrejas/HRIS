/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPage;

import static MyApp.FirstFrame.body;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import newpackage.dbconnector;

/**
 *
 * @author USER
 */
public class Dashboard extends javax.swing.JInternalFrame {

    /**
     * Creates new form userDashboard
     */
    public Dashboard() {
        initComponents();
        displayData();
        displayDataemp();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

    }
    Color navcolor = new Color(22, 123, 123);
    Color headcolor = new Color(0, 102, 102);
    Color bodycolor = new Color(204,255,204);
     public void displayDataemp() {

        try {

            dbconnector dbc = new dbconnector();
            ResultSet rs = dbc.getData("SELECT hris_emp.emp_id,hris_emp.emp_fname,hris_emp.emp_lname,timeinput.T_date, timeinput.T_in,timeinput.T_out FROM hris_emp INNER JOIN timeinput ON hris_emp.emp_id = timeinput.Ts_id");
            viewTable.setModel(DbUtils.resultSetToTableModel(rs));
      DefaultTableModel model = (DefaultTableModel) viewTable.getModel();
    String[] columnIdentifiers = {"ID", "Lastname", "Name", "Date","Time In","Time Out"};
    model.setColumnIdentifiers(columnIdentifiers);
        } catch (SQLException ex) {
            System.out.println("Error Message: " + ex);

        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        viewTable = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(51, 255, 255));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HUMAN RESOURCE INFORMATION SYSTEM");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(90, 20, 550, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 860, 70);

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

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 400, 402);

        viewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Lastname", "Name", "Date", "Time In", "Time Out"
            }
        ));
        jScrollPane2.setViewportView(viewTable);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(420, 90, 430, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
   
    }//GEN-LAST:event_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTable viewTable;
    // End of variables declaration//GEN-END:variables
}
