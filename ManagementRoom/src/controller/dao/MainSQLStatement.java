/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

/**
 *
 * @author lamit
 */
public interface MainSQLStatement {
    String SIMPLE_DATE_FORMAT = "dd/MM/yyyy hh:mm:ss";
    String CHECK_LOGIN = "SELECT * FROM tblUser where username = ? and _password = ?";
    String INSERT_ROOM = "INSERT into tblRoom(nameroom,_rank,priceperhour,des) values(?,?,?,?)";
    String UPDATE_ROOM = "UPDATE tblRoom set nameroom = ?, _rank = ?, priceperhour = ?, des = ? where id = ?";
    String DELETE_ROOM = "DELETE from tblRoom where id = ? ";
    String SELECT_ALL = "SELECT * from tblRoom";
    String SEARCH_CLIENT = "SELECT * FROM tblClient where fullname like ?";
    String SEARCH_ROOM_AVAILABLE = 
            "SELECT r.id,r.nameroom,r._rank,r.priceperhour,r.des FROM tblRoom as r "
            + ", tblBookRoom as br "
            + " where br.timeStart >= ? "
            + " and br.timeEnd <= ? "
            + " and _rank = ? and des = ? and r.id = br.idRoom";
    String SEARCH_ROOM = "SELECT * from tblRoom where _rank = ? and des = ?";
    String INSERT_BOOKROOM = "INSERT into tblBookRoom(idRoom,idClient,timeCreate,timeStart,timeEnd) "
    + " values(?,?,?,?,?)";
    String INSERT_CLIENT = "INSERT into tblClient(fullname,idnumber,typeCard,address,des) "
            + "values(?,?,?,?,?)";
    String SEARCH_BOOK_ROOM_CHECK_IN = "SELECT c.*,r.*,br.id,br.timeCreate,br.timeStart,br.timeEnd,br.timeCheckin from tblBookRoom as br "
            + "inner join tblRoom as r on br.idRoom = r.id "
            + "inner join tblClient as c on br.idClient = c.id "
            + "where c.fullname like ?";
    String UPDATE_BOOK_ROOM_CHECK_IN  = "UPDATE tblBookRoom set timeCheckin = ? where id = ?";
    String UPDATE_BOOK_ROOM_CHECK_OUT  = "UPDATE tblBookRoom set timeCheckout = ? where id = ?";
    String INSERT_BILL = "INSERT into tblBill(idBookRoom,total) values (?,?)";
}
