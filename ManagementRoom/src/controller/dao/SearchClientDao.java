/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Client;

/**
 *
 * @author lamit
 */
public class SearchClientDao extends MainDao{

    public SearchClientDao() {
        super();
    }
    
    public ArrayList<Client> searchClient(String key){
        ArrayList<Client> listClient = new ArrayList<>();
        try {
            PreparedStatement pre = super.getConnection().prepareStatement(MainSQLStatement.SEARCH_CLIENT);
            pre.setString(1, "%"+key+"%");
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nameClient = rs.getString("fullname");
                int idNumber = rs.getInt("idnumber");
                String typeCard = rs.getString("typeCard");
                String address = rs.getString("address");
                String des = rs.getString("des");
                Client client
                         = new Client(id,nameClient, idNumber, typeCard, address, des);
                listClient.add(client);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listClient;
    }
    public boolean addClient(Client client){
        try {
            PreparedStatement pre = super.getConnection().prepareStatement(MainSQLStatement.INSERT_CLIENT);
            pre.setString(1, client.getNameClient());
            pre.setInt(2, client.getIdNumber());
            pre.setString(3, client.getTypeCard());
            pre.setString(4, client.getAddress());
            pre.setString(5, client.getDes());
            pre.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
}
