/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Customer;

/**
 *
 * @author lamit
 */

public class RegisterImpl extends SummaryDao implements RegisterDao{

    public RegisterImpl() {
        super();
    }

    @Override
    public int registerCustomer(Customer customer) {
        int idAddress = 0, idAccount = 0;
        String INSERT_ADDRESS = "INSERT INTO address "
                + " (numhome,street,district) VALUES "
                + " (?,?,?) ";
        String INSERT_ACCOUNT = "INSERT INTO accountt "
                + " (username,_password) VALUES "
                + " (?,?)";
        String INSERT_USERS_SQL = "INSERT INTO customer " +
            "  (firstname, lastname, idacc, idaddress) VALUES " +
            " (?, ?, ?, ?);";

        int result = 0;

        try {
            
            PreparedStatement preparedStatement = super.getConnection().prepareStatement(INSERT_ADDRESS, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, customer.getAddress().getNumHome());
            preparedStatement.setString(2, customer.getAddress().getStreet());
            preparedStatement.setString(3, customer.getAddress().getDistrict());
            idAddress = preparedStatement.executeUpdate();
            System.out.println(idAddress);
            
            preparedStatement = super.getConnection().prepareStatement(INSERT_ACCOUNT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, customer.getAccount().getUsername());
            preparedStatement.setString(2, customer.getAccount().getPassword());
            idAccount = preparedStatement.executeUpdate();
            System.out.println(idAccount);

            
            preparedStatement = super.getConnection().prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setInt(3, idAccount);
            preparedStatement.setInt(4, idAddress);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
    
}