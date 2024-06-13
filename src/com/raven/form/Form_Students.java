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
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author RAVEN
 */
public class Form_Students extends javax.swing.JPanel {

    /**
     * Creates new form Form_1
     */
    public Form_Students() {
        initComponents();
        loadAllData();
        tableStudents.getTableHeader().setFont(new Font("Sagoe UI", Font.BOLD, 12));
        tableStudents.getTableHeader().setOpaque(false);
        tableStudents.getTableHeader().setBackground(new Color(24, 159, 205));
        tableStudents.getTableHeader().setForeground(new Color(3, 15, 22));
        tableStudents.setRowHeight(25);
    }
    
    PreparedStatement pst;
    ResultSet rs;

    public void loadAllData (){
        String[] columnNames = {"ID", "Username", "Name", "Gender" ,"Enrollment Year", "Contact", "Address"};
        DefaultTableModel data_students = new DefaultTableModel(columnNames, 0);
        
        try {
            Connection C = db_connection.ConfigureDatabase();
            Statement statement = C.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement stmt = C.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet result = statement.executeQuery("SELECT s.id, u.username, s.name, s.gender, s.enrollmentYear, s.contact, s.address FROM students s INNER JOIN users u ON s.userId = u.id");
            ResultSet resultUser = stmt.executeQuery("SELECT id, username FROM users WHERE role='student'");

            // Mengisi tabel secara manual
            while (result.next()) {
                String id = result.getString("id");
                String username = result.getString("username");
                String name = result.getString("name");
                String gender = result.getString("gender");
                String enrollmentYear = result.getString("enrollmentYear");
                String contact = result.getString("contact");
                String address = result.getString("address");

                data_students.addRow(new Object[]{id, username, name, gender, enrollmentYear, contact, address});
            }

            // Setting tabel dengan model yang sudah diisi
            tableStudents.setModel(data_students);
            
            result.beforeFirst();
            inputId.removeAllItems();
            while (result.next()) {
                String id = result.getString("id");
                String name = result.getString("id"); // Assuming there is a 'name' column
                inputId.addItem(new ComboItem(id, name));
            }
            
            resultUser.beforeFirst(); // Pindahkan cursor ke sebelum baris pertama
            inputUserId.removeAllItems();
            while (resultUser.next()) {
                String id = resultUser.getString("id");
                String name = resultUser.getString("username"); // Assuming there is a 'name' column
                inputUserId.addItem(new ComboItem(id, name));
            }

        } catch (Exception e) {
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupGender = new javax.swing.ButtonGroup();
        inputName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputId = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputContact = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableStudents = new javax.swing.JTable();
        inputEnrollmentYear = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inputUserId = new javax.swing.JComboBox<>();
        inputMale = new javax.swing.JRadioButton();
        inputFemale = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputAddress = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new rojerusan.RSMaterialButtonRectangle();
        btnUpdate = new rojerusan.RSMaterialButtonRectangle();
        btnDelete = new rojerusan.RSMaterialButtonRectangle();
        btnClear = new rojerusan.RSMaterialButtonRectangle();
        btnRefresh = new rojerusan.RSMaterialButtonRectangle();
        btnSearch = new rojerusan.RSMaterialButtonRectangle();

        setBackground(new java.awt.Color(255, 255, 255));

        inputName.setPreferredSize(new java.awt.Dimension(450, 25));
        inputName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(127, 127, 127));
        jLabel9.setText("ID");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 127, 127));
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 127, 127));
        jLabel3.setText("Enrollment Year");

        inputId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIdActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 127, 127));
        jLabel4.setText("Contact");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(127, 127, 127));
        jLabel5.setText("Address");

        inputContact.setPreferredSize(new java.awt.Dimension(450, 25));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(127, 127, 127));
        jLabel7.setText("Gender");

        tableStudents.setModel(new javax.swing.table.DefaultTableModel(
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
        tableStudents.setFocusable(false);
        tableStudents.setRowHeight(25);
        tableStudents.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableStudents);

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(127, 127, 127));
        jLabel6.setText("Username");

        inputUserId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputUserIdActionPerformed(evt);
            }
        });

        btnGroupGender.add(inputMale);
        inputMale.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        inputMale.setText("Male");

        btnGroupGender.add(inputFemale);
        inputFemale.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        inputFemale.setText("Female");

        inputAddress.setColumns(20);
        inputAddress.setRows(5);
        jScrollPane1.setViewportView(inputAddress);

        jLabel1.setFont(new java.awt.Font("sansserif", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(106, 106, 106));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STUDENTS MENU");

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

        btnSearch.setText("Search");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(42, 42, 42))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel6))
                                                .addGap(45, 45, 45)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(inputEnrollmentYear, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(inputUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(inputMale)
                                                        .addGap(57, 57, 57)
                                                        .addComponent(inputFemale))
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(inputContact, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(inputUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(inputEnrollmentYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(inputMale)
                                .addComponent(inputFemale)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addComponent(inputContact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNameActionPerformed

    // Method to check if userId already exists in the database
private boolean checkUserIdExists(String userId, String studentId) {
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    boolean userIdExists = false;
    
    try {
        connection = db_connection.ConfigureDatabase();
        
        // Conditionally adjust the query based on whether studentId is provided
        if (studentId == null) {
            pst = connection.prepareStatement("SELECT COUNT(*) AS count FROM students WHERE userId = ?");
            pst.setString(1, userId);
        } else {
            pst = connection.prepareStatement("SELECT COUNT(*) AS count FROM students WHERE userId = ? AND id != ?");
            pst.setString(1, userId);
            pst.setString(2, studentId);
        }
        
        rs = pst.executeQuery();
        
        if (rs.next()) {
            int count = rs.getInt("count");
            userIdExists = (count > 0);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error closing database resources: " + e.getMessage());
        }
    }
    
    return userIdExists;
}

    
    private void inputIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIdActionPerformed

    private void inputUserIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputUserIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputUserIdActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        /// input validation
        // validasi user id tidak boleh dipake dua kali
        String userId = ComboItem.getSelectedId(inputUserId);
        // Check if user ID already exists in the database
        boolean userIdExist = checkUserIdExists(userId, null);
        if (userIdExist) {
            JOptionPane.showMessageDialog(null, "User ID not Available!");
        } else if (inputName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name is required!");
        } else if (inputEnrollmentYear.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enrollment Year is required!");
        } else if (inputAddress.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Address is required!");
        } else if (btnGroupGender.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Gender is required!");
        } else if (inputContact.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Contact is required!");
        } else {
            // add new student
            // String userId = ComboItem.getSelectedId(inputUserId);
            String name = inputName.getText();
            String enrollmentYear = inputEnrollmentYear.getText();
//            String gender = (String) inputGender.getSelectedItem();
            String contact = inputContact.getText();
            String address = inputAddress.getText();
            
            try {
                Connection C = db_connection.ConfigureDatabase();
                pst = C.prepareStatement("INSERT INTO students (userId, name, enrollmentYear, address, gender, contact) VALUES (?, ?, ?, ?, ?, ?)");
                pst.setString(1, userId);
                pst.setString(2, name);
                pst.setString(3, enrollmentYear);
                pst.setString(4, address);
                // Gender
                String gender = null;
                if (inputMale.isSelected()) {
                    gender = inputMale.getText();
                }
                if (inputFemale.isSelected()) {
                    gender = inputFemale.getText();
                }
                pst.setString(5, gender);
                pst.setString(6, contact);
                
                int k = pst.executeUpdate();
                
                if (k == 1) {
                    JOptionPane.showMessageDialog(null, "Student Added Succesfully!");
                    inputName.setText("");
                    inputEnrollmentYear.setText("");
                    btnGroupGender.clearSelection();
                    inputContact.setText("");
                    inputAddress.setText("");
                    loadAllData();
                } else {
                    JOptionPane.showMessageDialog(null, "An Error Occurred, Question Not Saved!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } 
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        // input validation
       String userId = ComboItem.getSelectedId(inputUserId);
       String studentId = ComboItem.getSelectedId(inputId);
        // Check if user ID already exists in the database
        boolean userIdExist = checkUserIdExists(userId, studentId);
        if (userIdExist) {
            JOptionPane.showMessageDialog(null, "User ID not Available!");
        } else if (inputName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name is required!");
        } else if (inputEnrollmentYear.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enrollment Year is required!");
        } else if (inputAddress.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Address is required!");
        } else if (inputContact.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Contact is required!");
        } else {
            // add new student
            String name = inputName.getText();
            String enrollmentYear = inputEnrollmentYear.getText();
            String contact = inputContact.getText();
            String address = inputAddress.getText();
            
            int response = JOptionPane.showConfirmDialog(null, "Are you sure want to Update this question?", "Confirm Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if (response == JOptionPane.YES_OPTION) {
                try {
                    Connection C = db_connection.ConfigureDatabase();
                    PreparedStatement pst = C.prepareStatement(
                        "UPDATE students SET userId = ?, name = ?, enrollmentYear = ?, address = ?, gender = ?, contact = ? WHERE id = ?");

                    pst.setString(1, userId);
                    pst.setString(2, name);
                    pst.setString(3, enrollmentYear);
                    pst.setString(4, address);
                    // Gender
                    String gender = null;
                    if (inputMale.isSelected()) {
                        gender = inputMale.getText();
                    }
                    if (inputFemale.isSelected()) {
                        gender = inputFemale.getText();
                    }
                    pst.setString(5, gender);
                    pst.setString(6, contact);
                    pst.setString(7, studentId);

                    int k = pst.executeUpdate();
                
                    if (k == 1) {
                        JOptionPane.showMessageDialog(null, "Student Update Succesfully!");
                        inputName.setText("");
                        inputEnrollmentYear.setText("");
                        btnGroupGender.clearSelection();
                        inputContact.setText("");
                        inputAddress.setText("");
                        loadAllData();
                    } else {
                        JOptionPane.showMessageDialog(null, "An Error Occurred, Question Not Saved!");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                
            }
        }
       
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String studentId = ComboItem.getSelectedId(inputId);
        
        // Tampilkan dialog konfirmasi
        int response = JOptionPane.showConfirmDialog(null, "Are you sure to delete this data?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            try {
                Connection C = db_connection.ConfigureDatabase();
                pst = C.prepareStatement("DELETE FROM students WHERE id=?");
                pst.setString(1, studentId);
                
                int k = pst.executeUpdate();
                
                if (k == 1) {
                    JOptionPane.showMessageDialog(null, "Item Deleted Successfuly!");
      
                    inputName.setText("");
                    inputEnrollmentYear.setText("");
                    btnGroupGender.clearSelection();
                    inputContact.setText("");
                    inputAddress.setText("");
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
        ComboItem.setComboBoxSelectedItem(inputId, "");
        ComboItem.setComboBoxSelectedItem(inputUserId, "");
        inputName.setText("");
        inputEnrollmentYear.setText("");
        btnGroupGender.clearSelection();
        inputContact.setText("");
        inputAddress.setText(""); 
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        loadAllData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        // get data by id
        String studentId = ComboItem.getSelectedId(inputId);
        // String gender = ComboItem.getSelectedId(inputGender);
        try {
            Connection C = db_connection.ConfigureDatabase();
            pst = C.prepareStatement("SELECT * FROM students WHERE id=?");
            pst.setString(1, studentId);
            rs = pst.executeQuery();
            
            
            if (rs.next()) {
                ComboItem.setComboBoxSelectedItem(inputId, studentId);
                ComboItem.setComboBoxSelectedItem(inputUserId, rs.getString("userId"));
                inputName.setText(rs.getString("name"));
                
                // akan ter select sesuai dengan gender yg ada di database
                String gender = rs.getString("gender");
                if (gender.equalsIgnoreCase("Male")) {
                inputMale.setSelected(true);
                } else if (gender.equalsIgnoreCase("Female")) {
                    inputFemale.setSelected(true);
                }
                inputEnrollmentYear.setText(rs.getString("enrollmentYear"));
                inputContact.setText(rs.getString("contact"));
                inputAddress.setText(rs.getString("address"));
                
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
    private javax.swing.ButtonGroup btnGroupGender;
    private rojerusan.RSMaterialButtonRectangle btnRefresh;
    private rojerusan.RSMaterialButtonRectangle btnSearch;
    private rojerusan.RSMaterialButtonRectangle btnUpdate;
    private javax.swing.JTextArea inputAddress;
    private javax.swing.JTextField inputContact;
    private javax.swing.JTextField inputEnrollmentYear;
    private javax.swing.JRadioButton inputFemale;
    private javax.swing.JComboBox<ComboItem> inputId;
    private javax.swing.JRadioButton inputMale;
    private javax.swing.JTextField inputName;
    private javax.swing.JComboBox<ComboItem> inputUserId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableStudents;
    // End of variables declaration//GEN-END:variables
}
