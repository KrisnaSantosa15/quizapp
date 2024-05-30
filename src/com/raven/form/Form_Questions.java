package com.raven.form;

import com.raven.db.db_connection;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import com.raven.swing.ComboItem;

public class Form_Questions extends javax.swing.JPanel {

    public Form_Questions() {
        initComponents();
        loadAllData();
    }
    
    PreparedStatement pst;
    ResultSet rs;
    
     public void loadAllData() {
        try {
            Connection C = db_connection.ConfigureDatabase();
            Statement statement = C.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement stmt = C.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet result = statement.executeQuery("SELECT * FROM questions");
            ResultSet resultQuiz = stmt.executeQuery("SELECT * FROM quizes");

            // Mengisi resultTable dengan data
            tableResult.setModel(DbUtils.resultSetToTableModel(result));

            // Mengisi inputId dengan id dari resultSet yang sama
            result.beforeFirst(); // Pindahkan cursor ke sebelum baris pertama
            inputId.removeAllItems();
            while (result.next()) {
                String id = result.getString("id");
                String name = result.getString("id"); // Assuming there is a 'name' column
                inputId.addItem(new ComboItem(id, name));
            }

            // Mengisi inputQuizId dengan id dari resultSet yang sama
            resultQuiz.beforeFirst(); // Pindahkan cursor ke sebelum baris pertama
            inputQuizId.removeAllItems();
            while (resultQuiz.next()) {
                String id = resultQuiz.getString("id");
                String name = resultQuiz.getString("name"); // Assuming there is a 'name' column
                inputQuizId.addItem(new ComboItem(id, name));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.raven.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableResult = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        inputQuizId = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        inputQuestion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inputOptionA = new javax.swing.JTextField();
        inputOptionB = new javax.swing.JTextField();
        inputOptionC = new javax.swing.JTextField();
        inputOptionD = new javax.swing.JTextField();
        inputCorrectAnswer = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        inputId = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(915, 606));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Question Data");

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
        jScrollPane2.setViewportView(tableResult);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 127, 127));
        jLabel2.setText("Quiz Name");

        inputQuizId.setPreferredSize(new java.awt.Dimension(450, 25));
        inputQuizId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputQuizIdActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 127, 127));
        jLabel3.setText("Question");

        inputQuestion.setPreferredSize(new java.awt.Dimension(450, 25));
        inputQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputQuestionActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 127, 127));
        jLabel4.setText("Option A");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(127, 127, 127));
        jLabel5.setText("Option B");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(127, 127, 127));
        jLabel6.setText("Option C");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(127, 127, 127));
        jLabel7.setText("Option D");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(127, 127, 127));
        jLabel8.setText("Correct Answer");

        inputOptionA.setPreferredSize(new java.awt.Dimension(355, 25));
        inputOptionA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputOptionAActionPerformed(evt);
            }
        });

        inputOptionB.setPreferredSize(new java.awt.Dimension(355, 25));

        inputOptionC.setPreferredSize(new java.awt.Dimension(355, 25));

        inputOptionD.setPreferredSize(new java.awt.Dimension(355, 25));

        inputCorrectAnswer.setPreferredSize(new java.awt.Dimension(355, 25));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(127, 127, 127));
        jLabel9.setText("Id");

        inputId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIdActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setPreferredSize(new java.awt.Dimension(100, 40));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(100, 40));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(100, 40));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnClear.setText("Clear");
        btnClear.setPreferredSize(new java.awt.Dimension(100, 40));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.setPreferredSize(new java.awt.Dimension(100, 40));
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
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(57, 57, 57)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(inputOptionA, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(inputQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(283, 283, 283)
                                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(inputQuizId, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputCorrectAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inputOptionB, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputOptionC, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputOptionD, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputQuizId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputOptionA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(inputOptionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputOptionB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(inputOptionD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(inputCorrectAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(349, 349, 349))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIdActionPerformed

    private void inputOptionAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputOptionAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputOptionAActionPerformed

    private void inputQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputQuestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputQuestionActionPerformed

    private void inputQuizIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputQuizIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputQuizIdActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        // Input Validation
    if(inputQuestion.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Question is Required!");
    } else if(inputOptionA.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Option A is Required!");
    } else if(inputOptionB.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Option B is Required!");
    } else if(inputOptionC.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Option C is Required!");
    } else if(inputOptionD.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Option D is Required!");
    } else if(inputCorrectAnswer.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Correct Answer is Required!");
    } else {
        // Add new Question
            String quizId = ComboItem.getSelectedId(inputQuizId);
            String question = inputQuestion.getText();
            String optionA = inputOptionA.getText();
            String optionB = inputOptionB.getText();
            String optionC = inputOptionC.getText();
            String optionD = inputOptionD.getText();
            String correctAnswer = inputCorrectAnswer.getText();

            try {
                Connection C = db_connection.ConfigureDatabase();
                pst = C.prepareStatement("INSERT INTO questions (quizId, question, option_a, option_b, option_c, option_d, correct_answer) VALUES (?, ?, ?, ?, ?, ?, ?)");
                pst.setString(1, quizId);
                pst.setString(2, question);
                pst.setString(3, optionA);
                pst.setString(4, optionB);
                pst.setString(5, optionC);
                pst.setString(6, optionD);
                pst.setString(7, correctAnswer);

                int k = pst.executeUpdate();

                if (k == 1) {
                    JOptionPane.showMessageDialog(null, "Question Added Successfully!");
                    inputQuestion.setText("");
                    inputOptionA.setText("");
                    inputOptionB.setText("");
                    inputOptionC.setText("");
                    inputOptionD.setText("");
                    inputCorrectAnswer.setText("");
                    inputQuestion.requestFocus();
                    loadAllData(); // Refresh the data if necessary
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
        // Input Validation
        if (inputQuestion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Question is Required!");
        } else if (inputOptionA.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Option A is Required!");
        } else if (inputOptionB.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Option B is Required!");
        } else if (inputOptionC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Option C is Required!");
        } else if (inputOptionD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Option D is Required!");
        } else if (inputCorrectAnswer.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Correct Answer is Required!");
        } else {
            // Retrieve Input Values
            String questionId = ComboItem.getSelectedId(inputId); // Assuming you have an inputId JComboBox or similar
            String quizId = ComboItem.getSelectedId(inputQuizId);
            String question = inputQuestion.getText();
            String optionA = inputOptionA.getText();
            String optionB = inputOptionB.getText();
            String optionC = inputOptionC.getText();
            String optionD = inputOptionD.getText();
            String correctAnswer = inputCorrectAnswer.getText();

            // Display confirmation dialog
            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this question?", "Confirm Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            // If user confirms (clicks Yes), proceed with update
            if (response == JOptionPane.YES_OPTION) {
                try {
                    Connection C = db_connection.ConfigureDatabase();
                    // Prepare Update Statement
                    PreparedStatement pst = C.prepareStatement(
                        "UPDATE questions SET quizId = ?, question = ?, option_a = ?, option_b = ?, option_c = ?, option_d = ?, correct_answer = ? WHERE id = ?");
                    pst.setString(1, quizId);
                    pst.setString(2, question);
                    pst.setString(3, optionA);
                    pst.setString(4, optionB);
                    pst.setString(5, optionC);
                    pst.setString(6, optionD);
                    pst.setString(7, correctAnswer);
                    pst.setString(8, questionId); // Set the question ID for the WHERE clause

                    int k = pst.executeUpdate();

                    if (k == 1) {
                        JOptionPane.showMessageDialog(null, "Question Updated Successfully!");
                        inputQuestion.setText("");
                        inputOptionA.setText("");
                        inputOptionB.setText("");
                        inputOptionC.setText("");
                        inputOptionD.setText("");
                        inputCorrectAnswer.setText("");
                        inputQuestion.requestFocus();
                        loadAllData(); // Refresh the data if necessary
                    } else {
                        JOptionPane.showMessageDialog(null, "An Error Occurred, Question Not Updated!");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        // Get Data By Id:
        String questionId = ComboItem.getSelectedId(inputId);
        try {
            Connection C = db_connection.ConfigureDatabase();
            pst = C.prepareStatement("SELECT * FROM questions WHERE id=?");
            pst.setString(1, questionId);
            rs = pst.executeQuery();
            
            if(rs.next()){
                ComboItem.setComboBoxSelectedItem(inputId, questionId);
                ComboItem.setComboBoxSelectedItem(inputQuizId, rs.getString("quizId"));
                inputQuestion.setText(rs.getString("question"));
                inputOptionA.setText(rs.getString("option_a"));
                inputOptionB.setText(rs.getString("option_b"));
                inputOptionC.setText(rs.getString("option_c"));
                inputOptionD.setText(rs.getString("option_d"));
                inputCorrectAnswer.setText(rs.getString("correct_answer"));
            } else {
                JOptionPane.showMessageDialog(null, "No Items Found!");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String questionId = ComboItem.getSelectedId(inputId);
        
        // Tampilkan dialog konfirmasi
        int response = JOptionPane.showConfirmDialog(null, "Are you sure to delete this data?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response == JOptionPane.YES_OPTION){
            try {
            Connection C = db_connection.ConfigureDatabase();
            pst = C.prepareStatement("DELETE FROM questions WHERE id=?");
            pst.setString(1, questionId);
            
            int k = pst.executeUpdate();
            
                if(k==1){
                    JOptionPane.showMessageDialog(null, "Item Deleted Successfuly!");
                    inputQuestion.setText("");
                    inputOptionA.setText("");
                    inputOptionB.setText("");
                    inputOptionC.setText("");
                    inputOptionD.setText("");
                    inputCorrectAnswer.setText("");
                    inputQuestion.requestFocus();
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
        ComboItem.setComboBoxSelectedItem(inputQuizId, "");
        inputQuestion.setText("");
        inputOptionA.setText("");
        inputOptionB.setText("");
        inputOptionC.setText("");
        inputOptionD.setText("");
        inputCorrectAnswer.setText("");
        inputQuestion.requestFocus();
    }//GEN-LAST:event_btnClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField inputCorrectAnswer;
    private javax.swing.JComboBox<ComboItem> inputId;
    private javax.swing.JTextField inputOptionA;
    private javax.swing.JTextField inputOptionB;
    private javax.swing.JTextField inputOptionC;
    private javax.swing.JTextField inputOptionD;
    private javax.swing.JTextField inputQuestion;
    private javax.swing.JComboBox<ComboItem> inputQuizId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.swing.PanelBorder panelBorder1;
    private javax.swing.JTable tableResult;
    // End of variables declaration//GEN-END:variables
}
