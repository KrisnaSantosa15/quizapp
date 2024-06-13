/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.db;

import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author krisna
 */
public class db_connection {
    public static Connection connection;
    
    public static Connection ConfigureDatabase()throws SQLException {
        try {
            String url = "jdbc:mysql://localhost/quizapp";
            String user = "root";
            String pass = "root";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(url, user, pass);
            
//            JOptionPane.showMessageDialog(null, "Berhasil Koneksi");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Koneksi");
        }
        return connection;
    }
    
    public static void main(String[] args) throws SQLException {
        Connection C = db_connection.ConfigureDatabase();
    }
}
