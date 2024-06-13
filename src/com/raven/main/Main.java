/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.main;

import com.raven.event.EventMenuSelected;
import com.raven.form.Form_Teachers;
import com.raven.form.Form_Students;
import com.raven.form.Form_Quizes;
import com.raven.form.Form_Questions;
import com.raven.form.Form_Home;
import com.raven.form.Form_Users;
import com.raven.form.Form_Feedbacks;
import com.raven.form.Login;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author RAVEN
 */
public class Main extends javax.swing.JFrame {
    
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
    

    /**
     * Creates new form Main
     */
    private Form_Home home;
    private Form_Teachers formTeachers;
    private Form_Students formStudents;
    private Form_Users formUsers;
    private Form_Quizes formQuizes;
    private Form_Questions formQuestions;
    private Form_Feedbacks formFeedbacks;

    public Main() {
        
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        home = new Form_Home();
        formUsers = new Form_Users();
        formTeachers = new Form_Teachers();
        formStudents = new Form_Students();
        formQuizes = new Form_Quizes();
        formQuestions = new Form_Questions();
        formFeedbacks= new Form_Feedbacks();
        
        menu.initMoving(Main.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    setForm(home);
                } else if (index == 1) {
                    setForm(formUsers);
                } else if (index == 2) {
                    setForm(formTeachers);
                } else if (index == 3) {
                    setForm(formStudents);
                }else if (index == 4) {
                    setForm(formQuizes);
                }else if (index == 5) {
                    setForm(formQuestions);
                }else if (index == 6) {
                    setForm(formFeedbacks);
                }else if (index == 7) {
                    setVisible(false);
                    Login loginPage = new Login();
                    loginPage.setLocationRelativeTo(null); // Center the Login JFrame
                    loginPage.setVisible(true);
                }
            }
        });
        //  set when system open start with home form
        setForm(new Form_Home());
    }
    
    public Main(String userIdParam, String usernameParam, String nameParam /*, other fields */){
        
        this.userId = userIdParam;
        this.username = usernameParam;
        this.name = nameParam;
        // Initialize other fields

        // Initialize your GUI components here
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        String fullName = getFullName();
        String userId = getUserId();
        String username = getUsername();
        
        home = new Form_Home(userId,username,fullName);
        formUsers = new Form_Users();
        formTeachers = new Form_Teachers();
        formStudents = new Form_Students();
        formQuizes = new Form_Quizes();
        formQuestions = new Form_Questions();
        formFeedbacks= new Form_Feedbacks();
        
        menu.initMoving(Main.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    setForm(home);
                } else if (index == 1) {
                    setForm(formUsers);
                } else if (index == 2) {
                    setForm(formTeachers);
                } else if (index == 3) {
                    setForm(formStudents);
                }else if (index == 4) {
                    setForm(formQuizes);
                }else if (index == 5) {
                    setForm(formQuestions);
                }else if (index == 6) {
                    setForm(formFeedbacks);
                }else if (index == 7) {
                    setVisible(false);
                    Login loginPage = new Login();
                    loginPage.setLocationRelativeTo(null); // Center the Login JFrame
                    loginPage.setVisible(true);
                }
            }
        });
        //  set when system open start with home form
        setForm(new Form_Home(userId,username,fullName));
        
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.raven.swing.PanelBorder();
        menu = new com.raven.component.Menu();
        header2 = new com.raven.component.Header();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(242, 242, 242));

        header2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Header header2;
    private javax.swing.JPanel mainPanel;
    private com.raven.component.Menu menu;
    private com.raven.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
