/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.bookroom;

import controller.dao.BookRoomDao;
import controller.dao.MainSQLStatement;
import controller.dao.SearchRoomDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import model.BookRoom;
import model.Client;
import model.Room;
import view.BookRoomFrm;

/**
 *
 * @author lamit
 */
public class BookRoomControl {
    ArrayList<Room> listRoom = new ArrayList<>();
    private BookRoomFrm bookRoomFrm;
    SearchRoomDao searchRoomDao;
    BookRoomDao bookRoomDao;
    private Client client;
    public BookRoomControl(BookRoomFrm bookRoomFrm, Client client) {
        this.bookRoomFrm = bookRoomFrm;
        this.client = client;
        bookRoomFrm.setClient(client);
        searchRoomDao = new SearchRoomDao();
        bookRoomDao = new BookRoomDao();
        bookRoomFrm.setAction(new ButtonSearchRoom(), new ButtonBook());
    }
    class ButtonSearchRoom implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            listRoom = searchRoomDao.searchRoom(bookRoomFrm.getRoom(), bookRoomFrm.getTimeStart(), 
                    bookRoomFrm.getTimeEnd());
            if(listRoom.size() == 0){
                JOptionPane.showMessageDialog(bookRoomFrm, "Room is not valid");
            }else{
                bookRoomFrm.addToTable(listRoom);
            }
        }
        
    }
    class ButtonBook implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            int index = bookRoomFrm.getSelectedRow();
            if(index >=0 && index < listRoom.size()){
                Room roomChoose = listRoom.get(index);
                Date timeCreate = new Date();
                BookRoom br = new BookRoom(roomChoose, client, timeCreate, bookRoomFrm.getTimeStart(), 
                        bookRoomFrm.getTimeEnd());
                if(bookRoomDao.insertBookRoom(br)){
                    JOptionPane.showMessageDialog(bookRoomFrm, "Book Room Successfully");
                }else{
                    JOptionPane.showMessageDialog(bookRoomFrm, "Book Room Failes");
                }
            }
        }
        
    }
    
}
