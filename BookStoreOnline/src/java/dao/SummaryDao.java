/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lamit
 */
public class SummaryDao {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public SummaryDao() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SummaryDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/bookstoreonl?useSSL=false", "root", "6868");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
