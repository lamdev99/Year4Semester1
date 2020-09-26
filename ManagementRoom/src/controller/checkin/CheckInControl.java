/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.checkin;

import controller.dao.SearchBookRoomDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import model.BookRoom;
import view.CheckinFrm;

/**
 *
 * @author lamit
 */
public class CheckInControl {
    SearchBookRoomDao dao;
    private CheckinFrm checkinFrm;
    private ArrayList<BookRoom> listBookRooms = new ArrayList<>();
    public CheckInControl(CheckinFrm checkinFrm) {
        this.checkinFrm = checkinFrm;
        dao = new SearchBookRoomDao();
        checkinFrm.setAction(new ButtonSearchCheckin(), new ButtonCheckin());
    }
    class ButtonSearchCheckin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            listBookRooms = dao.getListBookRoomCheckIn(checkinFrm.getKeySearch());
            checkinFrm.addToTable(listBookRooms);
        }
        
    }
    class ButtonCheckin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            int index = checkinFrm.getSelectedRow();
            if(index >= 0 && index < listBookRooms.size()){
                BookRoom br = listBookRooms.get(index);
                br.setTimeCheckin(Calendar.getInstance().getTime());
                if(dao.updateBookRoomCheckIn(br)){
                    JOptionPane.showMessageDialog(checkinFrm, "Checkin Successfully");
                }else{
                    JOptionPane.showMessageDialog(checkinFrm, "Checkin Failed");
                }
            }
        }
        
    }
}
