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
import model.BookRoom;
import model.Client;
import model.Room;

/**
 *
 * @author lamit
 */
public class SearchBookRoomDao extends MainDao{

    public SearchBookRoomDao() {
        super();
    }
    
    public ArrayList<BookRoom> getListBookRoomCheckIn(String key){
        ArrayList<BookRoom> listBookRooms = new ArrayList<>();
        try {
            PreparedStatement pre = super.getConnection().prepareStatement(MainSQLStatement.SEARCH_BOOK_ROOM_CHECK_IN);
            pre.setString(1, "%"+key+"%");
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                System.out.println("YES");
                System.out.println(rs.getInt("r.nameroom"));
                Client client =
                        new Client(rs.getInt("c.id"), rs.getString("c.fullname") 
                                , rs.getInt("c.idnumber"), rs.getString("c.typeCard"), 
                                rs.getString("c.address"), rs.getString("c.des"));
                Room room = 
                        new Room(rs.getInt("r.id"), rs.getString("r.nameroom"), rs.getInt("r._rank")
                                , rs.getInt("r.priceperhour"), rs.getString("r.des"));
                BookRoom br =
                        new BookRoom(rs.getInt("br.id"),
                                room, client, 
                                new Date(rs.getLong("br.timeCreate")),
                                new Date(rs.getLong("br.timeStart")), 
                                new Date(rs.getLong("br.timeEnd")));
                listBookRooms.add(br);
                System.out.println(br.toString());
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listBookRooms;
    }
    public ArrayList<BookRoom> getListBookRoomCheckOut(String key){
        ArrayList<BookRoom> listBookRooms = new ArrayList<>();
        try {
            PreparedStatement pre = super.getConnection().prepareStatement(MainSQLStatement.SEARCH_BOOK_ROOM_CHECK_IN);
            pre.setString(1, "%"+key+"%");
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Client client =
                        new Client(rs.getInt("c.id"), rs.getString("c.fullname") 
                                , rs.getInt("c.idnumber"), rs.getString("c.typeCard"), 
                                rs.getString("c.address"), rs.getString("c.des"));
                Room room = 
                        new Room(rs.getInt("r.id"), rs.getString("r.nameroom"), rs.getInt("r._rank")
                                , rs.getInt("r.priceperhour"), rs.getString("r.des"));
                BookRoom br =
                        new BookRoom(rs.getInt("br.id"),
                                room, client, 
                                new Date(rs.getLong("br.timeCreate")),
                                new Date(rs.getLong("br.timeStart")), 
                                new Date(rs.getLong("br.timeEnd")),
                                new Date(rs.getLong("br.timeCheckin")));
                listBookRooms.add(br);
                System.out.println(br.getTimeCheckin());
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listBookRooms;
    }
    public boolean updateBookRoomCheckIn(BookRoom br){
        try {
            PreparedStatement pre = super.getConnection().prepareStatement(MainSQLStatement.UPDATE_BOOK_ROOM_CHECK_IN);
            pre.setLong(1, br.getTimeCheckin().getTime());
            pre.setInt(2, br.getId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    public boolean updateBookRoomCheckOut(BookRoom br){
        try {
            PreparedStatement pre = super.getConnection().prepareStatement(MainSQLStatement.UPDATE_BOOK_ROOM_CHECK_OUT);
            pre.setLong(1, br.getTimeCheckout().getTime());
            pre.setInt(2, br.getId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
}
