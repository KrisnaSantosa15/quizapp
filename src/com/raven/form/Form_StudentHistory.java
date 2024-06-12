/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import com.raven.db.db_connection;
import com.raven.swing.ComboItem;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author RAVEN
 */
public class Form_StudentHistory extends javax.swing.JPanel {
    private String userId;
    
    public String getUserId() {
        return userId;
    }

    /**
     * Creates new form Form_1
     */
    public Form_StudentHistory() {
        initComponents();
        loadAllData();
    }
    
    public Form_StudentHistory(String userIdParam) {
        this.userId = userIdParam;
        initComponents();
        loadAllData();
    }
    
    PreparedStatement pst;
    ResultSet rs;
    
    public void loadAllData() {
        try {
            Connection C = db_connection.ConfigureDatabase();
            String query = "SELECT sr.id, q.name, marks from student_result sr JOIN quizes q ON q.id=sr.quizId WHERE userId = ?";

            PreparedStatement pstmt = C.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            int userIdInt = Integer.parseInt(userId);  // Convert userId from String to int
            pstmt.setInt(1, userIdInt);  // Set the userId parameter

            ResultSet resultFeedbacks = pstmt.executeQuery();

            // Mengisi resultTable dengan data
            tableResult.setModel(DbUtils.resultSetToTableModel(resultFeedbacks));
            
            // Mengisi inputId dengan id dari resultSet yang sama
            resultFeedbacks.beforeFirst(); // Pindahkan cursor ke sebelum baris pertama

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
        pageTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableResult = new javax.swing.JTable();
        pageTitle1 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(245, 245, 245));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(915, 606));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        pageTitle.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        pageTitle.setForeground(new java.awt.Color(127, 127, 127));
        pageTitle.setText("History Data");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pageTitle))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pageTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pageTitle1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        pageTitle1.setForeground(new java.awt.Color(127, 127, 127));
        pageTitle1.setText("Your Result History");

        btnRefresh.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setPreferredSize(new java.awt.Dimension(100, 40));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pageTitle1)
                .addGap(359, 359, 359))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(pageTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        loadAllData();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel pageTitle;
    private javax.swing.JLabel pageTitle1;
    private javax.swing.JTable tableResult;
    // End of variables declaration//GEN-END:variables
}
