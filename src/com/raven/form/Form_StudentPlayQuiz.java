/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.form;

import com.raven.db.db_connection;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
            PreparedStatement ps = C.prepareStatement("INSERT INTO student_result (quizId, studentId, marks) VALUES (?, ?, ?)");
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
        loadTotalQuestions(quizIdParam); // Load total number of questions
        loadQuestion(quizIdParam);
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

    private void loadQuestion() {
        try {
            Connection C = db_connection.ConfigureDatabase();
            Statement statement = C.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsl = statement.executeQuery("SELECT * FROM questions WHERE id = " + questionId);
            if (rsl.next()) {
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
        if (option_a.isSelected()) {
            userAnswers.put(questionId, "A");
        } else if (option_b.isSelected()) {
            userAnswers.put(questionId, "B");
        } else if (option_c.isSelected()) {
            userAnswers.put(questionId, "C");
        } else if (option_d.isSelected()) {
            userAnswers.put(questionId, "D");
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
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Quiz Name");

        quizName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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

        question.setText("PERTANYAAN");

        buttonGroupAnswer.add(option_a);
        option_a.setText("jRadioButton1");

        buttonGroupAnswer.add(option_c);
        option_c.setText("jRadioButton1");

        buttonGroupAnswer.add(option_d);
        option_d.setText("jRadioButton1");

        buttonGroupAnswer.add(option_b);
        option_b.setText("jRadioButton1");

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrev.setText("Prev");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(option_a, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(option_c, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(option_b, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(option_d, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnPrev)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNext))
                                .addComponent(question, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(quizName, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
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
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(btnNext))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
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
        saveUserAnswer(); // Call saveUserAnswer() before moving to the next question
        if (questionId < totalQuestions) {
            questionId++; // Increment questionId to load the next question
            loadQuestion(getQuizId()); // Load the next question
            btnPrev.setVisible(true); // Ensure the "Previous" button is visible

            if (questionId == totalQuestions) {
                btnNext.setText("Submit"); // Change the button text to "Submit"
            }
        } else {
            submit(); // Call submit method if this is the last question
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        saveUserAnswer(); // Call saveUserAnswer() before moving to the previous question
        if (questionId > 1) {
            questionId--;
            loadQuestion(getQuizId());

            if (questionId == 1) {
                btnPrev.setVisible(false); // Hide the "Previous" button if on the first question
            }

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
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
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

