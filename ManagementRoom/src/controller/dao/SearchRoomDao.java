/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Room;

/**
 *
 * @author lamit
 */
public class SearchRoomDao extends MainDao{

    public SearchRoomDao() {
        super();
    }
    
    public ArrayList<Room> searchRoom(Room room, Date timeStart, Date timeEnd){
        ArrayList<Room> listRoom = new ArrayList<>();
        try {
            PreparedStatement pre = super.getConnection().prepareStatement(MainSQLStatement.SEARCH_ROOM_AVAILABLE);
            pre.setObject(1, timeStart.toInstant().atZone(ZoneId.of("Asia/Ho_Chi_Minh")).toLocalDate());
            pre.setObject(2, timeEnd.toInstant().atZone(ZoneId.of("Asia/Ho_Chi_Minh")).toLocalDate());
            pre.setInt(3, room.getRank());
            pre.setString(4, room.getDes());
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
            }else{
                PreparedStatement pre1 = super.getConnection().prepareStatement(MainSQLStatement.SEARCH_ROOM);
                pre1.setInt(1, room.getRank());
                pre1.setString(2, room.getDes());
                ResultSet rs1 = pre1.executeQuery();
                while(rs1.next()){
                    Room room1 = new Room(rs1.getInt(1), rs1.getString(2), rs1.getInt(3), rs1.getInt(4), rs1.getString(5));
                    listRoom.add(room1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchRoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRoom;
    }
}
