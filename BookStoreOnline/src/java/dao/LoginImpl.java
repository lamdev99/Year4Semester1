/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Address;
import model.Customer;

/**
 *
 * @author lamit
 */
public class LoginImpl extends SummaryDao implements LoginDao {

    public LoginImpl() {
        super();
    }

    @Override
    public Customer login(Account account) {
        Customer customer = null;
        try {

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = super.getConnection()
                    .prepareStatement("select * from accountt where username = ? and _password = ? ");
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            int idAcc = 0;
            if (rs.next() != false) {
                System.out.println("Go here");
                String firstName, lastName, street, district;
                int idAddress, numhome;
                idAcc = rs.getInt(1);
                System.out.println(idAcc);
                preparedStatement = super.getConnection()
                        .prepareStatement("select c.firstname,c.lastname,"
                                + "a.numhome,a.street,a.district "
                                + " from customer as c"
                                + " inner join address as a "
                                + " on a.id = c.idaddress "
                                + " where idacc = ?");
                preparedStatement.setInt(1, idAcc);
                ResultSet rs1 = preparedStatement.executeQuery();
                while (rs1.next()) {
                    firstName = rs1.getString(1);
                    lastName = rs1.getString(2);
                    numhome = rs1.getInt(3);
                    street = rs1.getString(4);
                    district = rs1.getString(5);
                    Address address = new Address(numhome, street, district);
                    customer = new Customer(idAcc, firstName, lastName, account, address);
                }
            } else {
                return customer;
            }

        } catch (Exception e) {
            // process sql exception
            e.printStackTrace();
        }
        return customer;

    }

}
