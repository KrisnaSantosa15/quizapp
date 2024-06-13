package com.raven.form;

import com.raven.main.Main;
import com.raven.model.Model_Card;
import com.raven.model.StatusType;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import com.raven.main.Main;

public class Form_Home extends javax.swing.JPanel {
    
    private String userId;
    private String username;
    private String name;

    // Getter methods to access the passed parameters
    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return name;
    }

    public Form_Home() {
        initComponents();
    }

    // Setter methods to set the parameters
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullName(String name) {
        this.name = name;
    }

    public Form_Home(String userIdParam, String usernameParam, String nameParam /*, other fields */) {
        this.userId = userIdParam;
        this.username = usernameParam;
        this.name = nameParam;

        initComponents();

        fullNameLabel.setText(getUsername());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fullNameLabel = new javax.swing.JLabel();
        banner1 = new com.raven.component.Banner();
        totalStudents1 = new com.raven.component.totalStudents();
        btnPindahkeFeedback = new rojerusan.RSMaterialButtonRectangle();
        lbValues = new javax.swing.JLabel();
        lbValues1 = new javax.swing.JLabel();
        totalTeachers1 = new com.raven.component.totalTeachers();
        totalQuizes1 = new com.raven.component.totalQuizes();
        totalQuestions1 = new com.raven.component.totalQuestions();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("HI, WELCOME");

        fullNameLabel.setFont(new java.awt.Font("sansserif", 1, 32)); // NOI18N
        fullNameLabel.setForeground(new java.awt.Color(127, 127, 127));
        fullNameLabel.setText("{{NAME}}");

        btnPindahkeFeedback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-arrow-10.png"))); // NOI18N
        btnPindahkeFeedback.setText("OK! Take me there");
        btnPindahkeFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPindahkeFeedbackActionPerformed(evt);
            }
        });

        lbValues.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbValues.setForeground(new java.awt.Color(102, 102, 102));
        lbValues.setText("Your Feedback Matters, ");

        lbValues1.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbValues1.setForeground(new java.awt.Color(102, 102, 102));
        lbValues1.setText("Help Your Students Improve!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(fullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(banner1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalStudents1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalQuizes1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalTeachers1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalQuestions1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbValues)
                                    .addGap(43, 43, 43))
                                .addComponent(btnPindahkeFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(lbValues1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPindahkeFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(fullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(banner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(lbValues)
                                .addGap(18, 18, 18)
                                .addComponent(lbValues1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalTeachers1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalStudents1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(totalQuizes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalQuestions1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(234, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPindahkeFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPindahkeFeedbackActionPerformed
        // TODO add your handling code here:
        // Pindah ke form feedback  
    }//GEN-LAST:event_btnPindahkeFeedbackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Banner banner1;
    private rojerusan.RSMaterialButtonRectangle btnPindahkeFeedback;
    private javax.swing.JLabel fullNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbValues;
    private javax.swing.JLabel lbValues1;
    private com.raven.component.totalQuestions totalQuestions1;
    private com.raven.component.totalQuizes totalQuizes1;
    private com.raven.component.totalStudents totalStudents1;
    private com.raven.component.totalTeachers totalTeachers1;
    // End of variables declaration//GEN-END:variables
}
