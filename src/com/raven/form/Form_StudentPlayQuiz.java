/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.form;

import com.raven.db.db_connection;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author rifdahhr
 */
public class Form_StudentPlayQuiz extends javax.swing.JFrame {
    private String userId;
    private String quizId;
    public String answer;
    public int questionId = 1; // Changed to int for easier increment
    private ResultSet rsl; // ResultSet is now a class member for accessibility in different methods
    private int totalQuestions;
    private Map<Integer, String> userAnswers = new HashMap<>(); // To store user's answers
    private List<Integer> questionIds = new ArrayList<>(); // To store all question IDs for the quiz

    public String getUserId() {
        return userId;
    }
    
    public String getQuizId() {
        return quizId;
    }
    
    public void answerCheck() {
        // Implement your answer checking logic here
    }
    
    public void question() {
        // Implement your question loading logic here
    }
    
     public void submit() {
        showUserAnswers();
        int response = JOptionPane.showConfirmDialog(this, "Do you want to submit the quiz?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            int score = calculateScore(); // Call calculateScore and store the result in a variable
            double marks = Math.ceil(((double) score / totalQuestions) * 100);
            JOptionPane.showMessageDialog(this, "Your score is: " + score + "/" + totalQuestions + "\n" + "Marks: " + marks);
            saveResult(marks); // Pass the score to saveResult
            this.setVisible(false);
        }
    }
    
        public int calculateScore() {
        int score = 0;
        try {
            Connection C = db_connection.ConfigureDatabase();
            Statement statement = C.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            for (Map.Entry<Integer, String> entry : userAnswers.entrySet()) {
                int qId = entry.getKey();
                String userAnswer = entry.getValue();
                ResultSet rs = statement.executeQuery("SELECT correct_answer FROM questions WHERE id = " + qId + " AND quizId = '" + quizId + "'");
                if (rs.next()) {
                    String correctAnswer = rs.getString("correct_answer");
                    if (userAnswer.equals(correctAnswer)) {
                        score++;
                    }
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Form_StudentPlayQuiz.class.getName()).log(Level.SEVERE, null, e);
        }
        return score;
    }

      public void saveResult(double score) { // Accept score as a parameter
        try {
            Connection C = db_connection.ConfigureDatabase();
            PreparedStatement ps = C.prepareStatement("INSERT INTO student_result (quizId, userId, marks) VALUES (?, ?, ?)");
            ps.setString(1, quizId);
            ps.setString(2, userId);
            ps.setDouble(3, score); // Use the score parameter
            ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(Form_StudentPlayQuiz.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Creates new form Form_StudentPlayQuiz
     */
    public Form_StudentPlayQuiz() throws SQLException {
        initComponents();
        btnPrev.setVisible(false);
        loadQuestion();
    }

    public Form_StudentPlayQuiz(String quizIdParam, String userIdParam) throws SQLException {
        this.userId = userIdParam;
        this.quizId = quizIdParam;
        initComponents();
        btnPrev.setVisible(false);
        loadQuestionIds(quizIdParam); // Load all question IDs
        loadTotalQuestions(quizIdParam); // Load total number of questions
        loadQuestion(); // Load the first question based on the new logic
    }

        private void loadTotalQuestions(String quizIdParam) {
            try {
                Connection C = db_connection.ConfigureDatabase();
                Statement statement = C.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = statement.executeQuery("SELECT COUNT(*) AS total FROM questions WHERE quizId = '" + quizIdParam + "'");
                if (rs.next()) {
                    totalQuestions = rs.getInt("total");
                }
            } catch (Exception e) {
                Logger.getLogger(Form_StudentPlayQuiz.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    
        private void loadQuestionIds(String quizIdParam) {
            try {
                Connection C = db_connection.ConfigureDatabase();
                Statement statement = C.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = statement.executeQuery("SELECT id FROM questions WHERE quizId = '" + quizIdParam + "'");
                while (rs.next()) {
                    questionIds.add(rs.getInt("id"));
                }
            } catch (Exception e) {
                Logger.getLogger(Form_StudentPlayQuiz.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        private void loadQuestion() {
        if (questionId > questionIds.size() || questionId <= 0) {
            return; // Invalid questionId
        }

        int currentQuestionId = questionIds.get(questionId - 1); // Get the actual question ID
        try {
            Connection C = db_connection.ConfigureDatabase();
            Statement statement = C.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsl = statement.executeQuery("SELECT * FROM questions q JOIN quizes z ON q.quizId=z.id WHERE q.id = " + currentQuestionId);
            if (rsl.next()) {
                quizName.setText(rsl.getString("name"));
                question.setText(rsl.getString("question"));
                option_a.setText(rsl.getString("option_a"));
                option_b.setText(rsl.getString("option_b"));
                option_c.setText(rsl.getString("option_c"));
                option_d.setText(rsl.getString("option_d"));
                answer = rsl.getString("correct_answer");

                // Clear previous selection
                option_a.setSelected(false);
                option_b.setSelected(false);
                option_c.setSelected(false);
                option_d.setSelected(false);

                System.out.println("Cleared selections for question ID: " + currentQuestionId);

                // Restore previously selected answer if available
                if (userAnswers.containsKey(currentQuestionId)) {
                    String selectedAnswer = userAnswers.get(currentQuestionId);
                    switch (selectedAnswer) {
                        case "A":
                            option_a.setSelected(true);
                            System.out.println("Restored selection A for question ID: " + currentQuestionId);
                            break;
                        case "B":
                            option_b.setSelected(true);
                            System.out.println("Restored selection B for question ID: " + currentQuestionId);
                            break;
                        case "C":
                            option_c.setSelected(true);
                            System.out.println("Restored selection C for question ID: " + currentQuestionId);
                            break;
                        case "D":
                            option_d.setSelected(true);
                            System.out.println("Restored selection D for question ID: " + currentQuestionId);
                            break;
                    }
                }

                btnPrev.setVisible(questionId != 1); // Hide the "Previous" button if on the first question

                if (questionId == totalQuestions) {
                    btnNext.setText("Submit"); // Change the button text to "Submit" if on the last question
                } else {
                    btnNext.setText("Next"); // Change the button text back to "Next" if not on the last question
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Form_StudentPlayQuiz.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadQuestion(String quizIdParam) {
        
        try {
            Connection C = db_connection.ConfigureDatabase();
            Statement statement = C.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsl = statement.executeQuery("SELECT * FROM questions q JOIN quizes z ON q.quizId=z.id WHERE q.id = " + questionId + " AND quizId = '" + quizIdParam + "'");
            if (rsl.next()) {
                quizName.setText(rsl.getString("name"));
                question.setText(rsl.getString("question"));
                option_a.setText(rsl.getString("option_a"));
                option_b.setText(rsl.getString("option_b"));
                option_c.setText(rsl.getString("option_c"));
                option_d.setText(rsl.getString("option_d"));
                answer = rsl.getString("correct_answer");

                if (questionId == 1) {
                    btnPrev.setVisible(false); // Hide the "Previous" button if on the first question
                } else {
                    btnPrev.setVisible(true); // Show the "Previous" button if not on the first question
                }

                if (questionId == totalQuestions) {
                    btnNext.setText("Submit"); // Change the button text to "Submit" if on the last question
                } else {
                    btnNext.setText("Next"); // Change the button text back to "Next" if not on the last question
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Form_StudentPlayQuiz.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void saveUserAnswer() {
        // Save the selected answer for the current question
        int currentQuestionId = questionIds.get(questionId - 1);
        if (option_a.isSelected()) {
            userAnswers.put(currentQuestionId, "A");
        } else if (option_b.isSelected()) {
            userAnswers.put(currentQuestionId, "B");
        } else if (option_c.isSelected()) {
            userAnswers.put(currentQuestionId, "C");
        } else if (option_d.isSelected()) {
            userAnswers.put(currentQuestionId, "D");
        } else {
            userAnswers.remove(currentQuestionId); // Ensure previous answer is removed if none selected
        }
    }

    private void showUserAnswers() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> entry : userAnswers.entrySet()) {
            sb.append("Question ID: ").append(entry.getKey()).append(", Answer: ").append(entry.getValue()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupAnswer = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        quizName = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        question = new javax.swing.JLabel();
        option_a = new javax.swing.JRadioButton();
        option_c = new javax.swing.JRadioButton();
        option_d = new javax.swing.JRadioButton();
        option_b = new javax.swing.JRadioButton();
        btnPrev = new rojerusan.RSMaterialButtonRectangle();
        btnNext = new rojerusan.RSMaterialButtonRectangle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quiz Name");

        quizName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        quizName.setText("10");

        jPanel3.setPreferredSize(new java.awt.Dimension(650, 2));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        question.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        question.setText("PERTANYAAN");

        buttonGroupAnswer.add(option_a);
        option_a.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        option_a.setText("jRadioButton1");

        buttonGroupAnswer.add(option_c);
        option_c.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        option_c.setText("jRadioButton1");

        buttonGroupAnswer.add(option_d);
        option_d.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        option_d.setText("jRadioButton1");

        buttonGroupAnswer.add(option_b);
        option_b.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        option_b.setText("jRadioButton1");

        btnPrev.setText("Prev");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(quizName, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(option_a, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(option_c, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(option_b, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(question, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(option_d, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)))))
                .addGap(146, 146, 146))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(quizName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(question, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option_a)
                .addGap(18, 18, 18)
                .addComponent(option_b)
                .addGap(18, 18, 18)
                .addComponent(option_c)
                .addGap(18, 18, 18)
                .addComponent(option_d)
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        saveUserAnswer(); // Call saveUserAnswer() before moving to the next question
        if (questionId < totalQuestions) {
            questionId++; // Increment questionId to load the next question
            loadQuestion(); // Load the next question
            btnPrev.setVisible(true); // Ensure the "Previous" button is visible

            if (questionId == totalQuestions) {
                btnNext.setText("Submit"); // Change the button text to "Submit"
            }
        } else {
            submit(); // Call submit method if this is the last question
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
         saveUserAnswer(); // Call saveUserAnswer() before moving to the previous question
        if (questionId > 1) {
            questionId--;
            loadQuestion();

            btnPrev.setVisible(questionId != 1); // Hide the "Previous" button if on the first question

            if (questionId < totalQuestions) {
                btnNext.setText("Next"); // Change the button text back to "Next"
            }
        }
    }//GEN-LAST:event_btnPrevActionPerformed

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
            java.util.logging.Logger.getLogger(Form_StudentPlayQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_StudentPlayQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_StudentPlayQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_StudentPlayQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Form_StudentPlayQuiz().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Form_StudentPlayQuiz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle btnNext;
    private rojerusan.RSMaterialButtonRectangle btnPrev;
    private javax.swing.ButtonGroup buttonGroupAnswer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton option_a;
    private javax.swing.JRadioButton option_b;
    private javax.swing.JRadioButton option_c;
    private javax.swing.JRadioButton option_d;
    private javax.swing.JLabel question;
    private javax.swing.JLabel quizName;
    // End of variables declaration//GEN-END:variables
}

