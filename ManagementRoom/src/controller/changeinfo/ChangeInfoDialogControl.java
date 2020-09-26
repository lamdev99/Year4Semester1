/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.changeinfo;

import controller.dao.ChangeInfoRoomDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.EnumChange;
import model.Room;
import view.ChangeInfoRoomDialog;

/**
 *
 * @author lamit
 */
public class ChangeInfoDialogControl {
    private ChangeInfoRoomDialog changeInfoRoomDialog;
    private ChangeInfoRoomDao changeInfoRoomDao;
    private EnumChange enumChange;
    EventInteface ei;
    public ChangeInfoDialogControl(ChangeInfoRoomDialog changeInfoRoomDialog, EnumChange enumChange,
            EventInteface ei) {
        this.changeInfoRoomDialog = changeInfoRoomDialog;
        this.ei = ei;
        changeInfoRoomDao = new ChangeInfoRoomDao();
        this.enumChange = enumChange;
        changeInfoRoomDialog.setAction(new ButtonActionDialog(), new ButtonCancel());
    }
    
    class ButtonActionDialog implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("Event");
            Room room = changeInfoRoomDialog.getRoom();
            switch(enumChange){
                case INSERT:{
                    changeInfoRoomDao.insertRoom(room);
                    changeInfoRoomDialog._dispose();
                    ei.reloadDataRoom();
                    break;
                }
                case UPDATE:{
                    changeInfoRoomDao.updateRoom(room);
                    changeInfoRoomDialog._dispose();
                    ei.reloadDataRoom();
                    break;
                }
                case DELETE:{
                    changeInfoRoomDao.deleteRoom(room);
                    changeInfoRoomDialog._dispose();
                    ei.reloadDataRoom();
                    break;
                }
                default: break;
            }
        }
        
    }
    class ButtonCancel implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            changeInfoRoomDialog._dispose();
        }
        
    }
}
