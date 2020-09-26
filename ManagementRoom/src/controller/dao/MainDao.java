/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lamit
 */
public class MainDao {
    private Connection conn;
    private String jdbcURL = "jdbc:mysql://localhost:3306/manageroom?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "6868";
    public MainDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername,
                    jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return conn;
    }
}
