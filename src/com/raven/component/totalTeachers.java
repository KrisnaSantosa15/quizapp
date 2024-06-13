/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.component;

import com.raven.model.Model_Card;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author rifdahhr
 */
public class totalTeachers extends javax.swing.JPanel {

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    private Color color1;
    private Color color2;
    
    public totalTeachers() {
        initComponents();
        setOpaque(false);
        color1 = new Color(135, 173, 211, 128);
        color2 = new Color(135, 173, 211, 128);
    }

    public void setData(Model_Card data) {
        //lbIcon.setIcon(data.getIcon());
        lbIcon.setText(data.getTitle());
        lbDescription.setText(data.getDescription());
        lbValues.setText(data.getValues());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbValues = new javax.swing.JLabel();
        lbDescription = new javax.swing.JLabel();

        lbIcon.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbIcon.setForeground(new java.awt.Color(255, 255, 255));
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-business-man-50.png"))); // NOI18N

        lbValues.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbValues.setForeground(new java.awt.Color(102, 102, 102));
        lbValues.setText("546");

        lbDescription.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbDescription.setForeground(new java.awt.Color(153, 153, 153));
        lbDescription.setText("Total Teachers");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbIcon)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescription)
                    .addComponent(lbValues))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIcon)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbValues)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(135, 173, 211, 128));
//        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
//        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbValues;
    // End of variables declaration//GEN-END:variables
}
