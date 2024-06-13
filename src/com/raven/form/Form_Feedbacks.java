/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import com.raven.db.db_connection;
import com.raven.swing.ComboItem;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author RAVEN
 */
public class Form_Feedbacks extends javax.swing.JPanel {

    /**
     * Creates new form Form_1
     */
    public Form_Feedbacks() {
        initComponents();
        loadAllData();
        tableResult.getTableHeader().setFont(new Font("Sagoe UI", Font.BOLD, 12));
        tableResult.getTableHeader().setOpaque(false);
        tableResult.getTableHeader().setBackground(new Color(24, 159, 205));
        tableResult.getTableHeader().setForeground(new Color(3, 15, 22));
        tableResult.setRowHeight(25);
    }
    
    PreparedStatement pst;
    ResultSet rs;
    
    public void loadAllData() {
        try {
            Connection C = db_connection.ConfigureDatabase();
            Statement statement = C.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement stmt = C.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement smt = C.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultFeedbacks = smt.executeQuery("SELECT * FROM feedbacks");
            ResultSet result = statement.executeQuery("SELECT * FROM teachers");
            ResultSet resultStudents = stmt.executeQuery("SELECT * FROM students");

            // Mengisi resultTable dengan data
            tableResult.setModel(DbUtils.resultSetToTableModel(resultFeedbacks));
            
            // Mengisi inputId dengan id dari resultSet yang sama
            resultFeedbacks.beforeFirst(); // Pindahkan cursor ke sebelum baris pertama
            inputId.removeAllItems();
            while (resultFeedbacks.next()) {
                String id = resultFeedbacks.getString("id");
                String name = resultFeedbacks.getString("id"); // Assuming there is a 'name' column
                inputId.addItem(new ComboItem(id, name));
            }

            // Mengisi inputId dengan id dari resultSet yang sama
            result.beforeFirst(); // Pindahkan cursor ke sebelum baris pertama
            teacherId.removeAllItems();
            while (result.next()) {
                String id = result.getString("id");
                String name = result.getString("name"); // Assuming there is a 'name' column
                teacherId.addItem(new ComboItem(id, name));
            }

            // Mengisi inputQuizId dengan id dari resultSet yang sama
            resultStudents.beforeFirst(); // Pindahkan cursor ke sebelum baris pertama
            studentId.removeAllItems();
            while (resultStudents.next()) {
                String id = resultStudents.getString("id");
                String name = resultStudents.getString("name"); // Assuming there is a 'name' column
                studentId.addItem(new ComboItem(id, name));
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputFeedback = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        inputId = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        pageTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableResult = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        studentId = new javax.swing.JComboBox<>();
        teacherId = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new rojerusan.RSMaterialButtonRectangle();
        btnUpdate = new rojerusan.RSMaterialButtonRectangle();
        btnDelete = new rojerusan.RSMaterialButtonRectangle();
        btnClear = new rojerusan.RSMaterialButtonRectangle();
        btnRefresh = new rojerusan.RSMaterialButtonRectangle();
        btnSearch = new rojerusan.RSMaterialButtonRectangle();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(915, 606));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 127, 127));
        jLabel2.setText("Student");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 127, 127));
        jLabel3.setText("Description");

        inputFeedback.setColumns(20);
        inputFeedback.setRows(5);
        jScrollPane1.setViewportView(inputFeedback);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 127, 127));
        jLabel4.setText("ID");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        pageTitle.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        pageTitle.setForeground(new java.awt.Color(127, 127, 127));
        pageTitle.setText("Feedback Data");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableResult.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tableResult);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pageTitle)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pageTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
        );

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(127, 127, 127));
        jLabel5.setText("Teacher");

        jLabel1.setFont(new java.awt.Font("sansserif", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(106, 106, 106));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FEEDBACKS MENU");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnRefresh.setText("refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnSearch.setText("search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                .addComponent(studentId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(teacherId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(168, 168, 168)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(teacherId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(studentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        // Input Validation
        if(inputFeedback.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Feedback is Required!");
        } else {
            // Add new Quiz
            String feedback = inputFeedback.getText();
            String teacherIdSelected = ComboItem.getSelectedId(teacherId);
            String studentIdSelected = ComboItem.getSelectedId(studentId);

            try {
                Connection C = db_connection.ConfigureDatabase();
                pst = C.prepareStatement("INSERT INTO feedbacks (teacherId, studentId, feedback) VALUES (?, ?, ?)");
                pst.setString(1, teacherIdSelected);
                pst.setString(2, studentIdSelected);
                pst.setString(3, feedback);

                int k = pst.executeUpdate();

                if(k==1){
                    JOptionPane.showMessageDialog(null, "Item Added Successfuly!");
                    inputFeedback.setText("");
                    loadAllData();
                } else {
                    JOptionPane.showMessageDialog(null, "An Error Occured, Item Not Saved!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        // Input Validation
    if(inputFeedback.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Feedback is Required!");
    } else {
        // Ambil data dari input
        String feedback = inputFeedback.getText();
        String feedbackId = ComboItem.getSelectedId(inputId);
        String inputTeacherId = ComboItem.getSelectedId(teacherId);
        String inputStudentId = ComboItem.getSelectedId(studentId);

        // Tampilkan dialog konfirmasi
        int response = JOptionPane.showConfirmDialog(null, "Are you sure to update this data?", "Confirm Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        // Jika pengguna mengonfirmasi (klik Yes), lanjutkan pembaruan
        if (response == JOptionPane.YES_OPTION) {
            try {
                Connection C = db_connection.ConfigureDatabase();
                pst = C.prepareStatement("UPDATE feedbacks SET teacherId=?, studentId=?, feedback=? WHERE id=?");
                pst.setString(1, inputTeacherId);
                pst.setString(2, inputStudentId);
                pst.setString(3, feedback);
                pst.setString(4, feedbackId );

                int k = pst.executeUpdate();

                    if(k == 1) {
                        JOptionPane.showMessageDialog(null, "Item Updated Successfully!");
                        inputFeedback.setText("");
                        inputFeedback.requestFocus();
                        ComboItem.setComboBoxSelectedItem(inputId, "");
                        ComboItem.setComboBoxSelectedItem(studentId, "");
                        ComboItem.setComboBoxSelectedItem(teacherId, "");
                        loadAllData();
                    } else {
                        JOptionPane.showMessageDialog(null, "An Error Occurred, Item Not Updated!");
                    }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String feedbackId = ComboItem.getSelectedId(inputId);
        
        // Tampilkan dialog konfirmasi
        int response = JOptionPane.showConfirmDialog(null, "Are you sure to delete this data?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response == JOptionPane.YES_OPTION){
            try {
            Connection C = db_connection.ConfigureDatabase();
            pst = C.prepareStatement("DELETE FROM feedbacks WHERE id=?");
            pst.setString(1, feedbackId);
            
            int k = pst.executeUpdate();
            
                if(k==1){
                    JOptionPane.showMessageDialog(null, "Item Deleted Successfuly!");
                    inputFeedback.setText("");
                    inputFeedback.requestFocus();
                    ComboItem.setComboBoxSelectedItem(inputId, "");
                    ComboItem.setComboBoxSelectedItem(studentId, "");
                    ComboItem.setComboBoxSelectedItem(teacherId, "");
                    loadAllData();
                } else {
                    JOptionPane.showMessageDialog(null, "An Error Occured, Item Not Deleted!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        inputFeedback.setText("");
        inputFeedback.requestFocus();
        ComboItem.setComboBoxSelectedItem(inputId, "");
        ComboItem.setComboBoxSelectedItem(studentId, "");
        ComboItem.setComboBoxSelectedItem(teacherId, "");
        loadAllData();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        loadAllData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String feedbackId = ComboItem.getSelectedId(inputId);
        try {
            Connection C = db_connection.ConfigureDatabase();
            pst = C.prepareStatement("SELECT * FROM feedbacks WHERE id=?");
            pst.setString(1, feedbackId);
            rs = pst.executeQuery();
            
            if(rs.next()){
                ComboItem.setComboBoxSelectedItem(inputId, feedbackId);
                ComboItem.setComboBoxSelectedItem(studentId, rs.getString("studentId"));
                ComboItem.setComboBoxSelectedItem(teacherId, rs.getString("teacherId"));
                inputFeedback.setText(rs.getString("feedback"));
            } else {
                JOptionPane.showMessageDialog(null, "No Items Found!");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle btnAdd;
    private rojerusan.RSMaterialButtonRectangle btnClear;
    private rojerusan.RSMaterialButtonRectangle btnDelete;
    private rojerusan.RSMaterialButtonRectangle btnRefresh;
    private rojerusan.RSMaterialButtonRectangle btnSearch;
    private rojerusan.RSMaterialButtonRectangle btnUpdate;
    private javax.swing.JTextArea inputFeedback;
    private javax.swing.JComboBox<ComboItem> inputId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel pageTitle;
    private javax.swing.JComboBox<ComboItem> studentId;
    private javax.swing.JTable tableResult;
    private javax.swing.JComboBox<ComboItem> teacherId;
    // End of variables declaration//GEN-END:variables
}
