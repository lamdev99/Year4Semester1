/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BookRoom;

/**
 *
 * @author lamit
 */
public class BookRoomDao extends MainDao{

    public BookRoomDao() {
        super();
    }
    public boolean insertBookRoom(BookRoom br){
        try {
            PreparedStatement pre = super.getConnection().prepareStatement(MainSQLStatement.INSERT_BOOKROOM);
            pre.setInt(1, br.getRoom().getId());
            pre.setInt(2, br.getClient().getId());
//            pre.setObject(3, br.getTimeCreate().toInstant().atZone(ZoneId.of("Asia/Ho_Chi_Minh")).toLocalDate());
//            pre.setObject(4, br.getTimeStart().toInstant().atZone(ZoneId.of("Asia/Ho_Chi_Minh")).toLocalDate());
//            pre.setObject(5, br.getTimeEnd().toInstant().atZone(ZoneId.of("Asia/Ho_Chi_Minh")).toLocalDate());
            pre.setLong(3, br.getTimeCreate().getTime());
            pre.setLong(4, br.getTimeStart().getTime());
            pre.setLong(5, br.getTimeEnd().getTime());
            System.out.println(br.getTimeStart().toString());
            pre.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
}
