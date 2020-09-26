/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Room;

/**
 *
 * @author lamit
 */
public class GetAllDao extends MainDao{

    public GetAllDao() {
        super();
    }
    public ArrayList<Room> getAllRoom(){
        ArrayList<Room> listRoom = new ArrayList<>();
        try {
            Statement s = super.getConnection().createStatement();
            ResultSet rs = s.executeQuery(MainSQLStatement.SELECT_ALL);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("nameroom");
                int rank = rs.getInt("_rank");
                int pricePerHour = rs.getInt("priceperhour");
                String des = rs.getString("des");
                Room r = new Room(id,name, rank, pricePerHour, des);
                listRoom.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetAllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRoom;
    }
}
