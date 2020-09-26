/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.changeinfo;

import controller.changeinfo.ChangeInfoDialogControl;
import controller.dao.ChangeInfoRoomDao;
import controller.dao.GetAllDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.EnumChange;
import model.Room;
import view.ChangeInfoRoomDialog;
import view.EditInfoRoomFrm;

/**
 *
 * @author lamit
 */
public class ChangeInfoRoomControl implements EventInteface{
    private GetAllDao getAllDao;
    private EditInfoRoomFrm editInfoRoomFrm;
    private ArrayList<Room> listRoom = new ArrayList<>();
    public ChangeInfoRoomControl(EditInfoRoomFrm editInfoRoomFrm) {
        this.editInfoRoomFrm = editInfoRoomFrm;
        getAllDao = new GetAllDao();
        listRoom = getAllDao.getAllRoom();
        editInfoRoomFrm.setListRoom(listRoom);
        editInfoRoomFrm.setAction(new AddAction(), new UpdateAction(), new DeleteAction());
    }

    @Override
    public void reloadDataRoom() {
        listRoom = getAllDao.getAllRoom();
        editInfoRoomFrm.setListRoom(listRoom);
    }
    class AddAction implements ActionListener{
        public ChangeInfoRoomControl getParent(){
            return ChangeInfoRoomControl.this;
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            ChangeInfoRoomDialog changeInfoRoomDialog = new ChangeInfoRoomDialog(editInfoRoomFrm, true);
            changeInfoRoomDialog.setTitleButton("Add Room");
            ChangeInfoDialogControl control = new ChangeInfoDialogControl(changeInfoRoomDialog,
                    EnumChange.INSERT,getParent());
            changeInfoRoomDialog.setVisible(true);
        }
        
    }
    class UpdateAction implements ActionListener{
        public ChangeInfoRoomControl getParent(){
            return ChangeInfoRoomControl.this;
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(editInfoRoomFrm.getIndexSelected()>=0 && editInfoRoomFrm.getIndexSelected()<listRoom.size()){
                ChangeInfoRoomDialog changeInfoRoomDialog = new ChangeInfoRoomDialog(editInfoRoomFrm, true);
                changeInfoRoomDialog.setTitleButton("Update Room");
                changeInfoRoomDialog.setRoomDisplay(listRoom.get(editInfoRoomFrm.getIndexSelected()));
                ChangeInfoDialogControl control = new ChangeInfoDialogControl(changeInfoRoomDialog,
                        EnumChange.UPDATE,
                        getParent());
                changeInfoRoomDialog.setVisible(true);
            }
        }
        
    }
    class DeleteAction implements ActionListener{
        public ChangeInfoRoomControl getParent(){
            return ChangeInfoRoomControl.this;
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(editInfoRoomFrm.getIndexSelected()>=0 && editInfoRoomFrm.getIndexSelected()<listRoom.size()){
                ChangeInfoRoomDialog changeInfoRoomDialog = new ChangeInfoRoomDialog(editInfoRoomFrm, true);
                changeInfoRoomDialog.setTitleButton("Delete Room");
                changeInfoRoomDialog.setRoomDisplay(listRoom.get(editInfoRoomFrm.getIndexSelected()));
                ChangeInfoDialogControl control = new ChangeInfoDialogControl(changeInfoRoomDialog,
                        EnumChange.DELETE,
                        getParent());
                changeInfoRoomDialog.setVisible(true);
            }
        }
        
    }
}
