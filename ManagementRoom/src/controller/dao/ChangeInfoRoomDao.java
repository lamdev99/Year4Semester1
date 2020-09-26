/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Room;

/**
 *
 * @author lamit
 */
public class ChangeInfoRoomDao extends MainDao{
    Connection conn;
    public ChangeInfoRoomDao() {
        super();
        conn = super.getConnection();
    }
    public void insertRoom(Room room){
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(MainSQLStatement.INSERT_ROOM);
            preparedStatement.setString(1,room.getNameRoom());
            preparedStatement.setInt(2, room.getRank());
            preparedStatement.setInt(3, room.getPricePerHour());
            preparedStatement.setString(4, room.getDes());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChangeInfoRoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateRoom(Room room){
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(MainSQLStatement.UPDATE_ROOM);
            preparedStatement.setString(1,room.getNameRoom());
            preparedStatement.setInt(2, room.getRank());
            preparedStatement.setInt(3, room.getPricePerHour());
            preparedStatement.setString(4, room.getDes());
            preparedStatement.setInt(5, room.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChangeInfoRoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void deleteRoom(Room room){
        try {
            System.out.println(room.getId());
            PreparedStatement preparedStatement = conn.prepareStatement(MainSQLStatement.DELETE_ROOM);
            preparedStatement.setInt(1, room.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChangeInfoRoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
