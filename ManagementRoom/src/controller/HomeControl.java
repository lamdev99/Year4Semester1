/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.checkin.CheckInControl;
import controller.checkout.CheckOutControl;
import controller.bookroom.SearchClientControl;
import controller.changeinfo.ChangeInfoRoomControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CheckinFrm;
import view.CheckoutFrm;
import view.EditInfoRoomFrm;
import view.HomeManagement;
import view.SearchClientFrm;

/**
 *
 * @author lamit
 */
public class HomeControl {
    private HomeManagement homeManagement;

    public HomeControl(HomeManagement homeManagement) {
        this.homeManagement = homeManagement;
        homeManagement.setAction(new EditRoomControl(), new BookRoomControl(), new CheckInControlAction(), new CheckoutControlAction());
    }
    class EditRoomControl implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            EditInfoRoomFrm editInfoRoomFrm = new EditInfoRoomFrm();
            editInfoRoomFrm.setVisible(true);
            ChangeInfoRoomControl changeInfoRoomControl = new ChangeInfoRoomControl(editInfoRoomFrm);
        }
        
    }
    class BookRoomControl implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            SearchClientFrm searchClientFrm = new SearchClientFrm();
            SearchClientControl s = new SearchClientControl(searchClientFrm);
            searchClientFrm.setVisible(true);
        }
        
    }
    class CheckInControlAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            CheckinFrm checkinFrm = new CheckinFrm();
            CheckInControl checkInControl = new CheckInControl(checkinFrm);
            checkinFrm.setVisible(true);
        }
        
    }
    class CheckoutControlAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            CheckoutFrm checkoutFrm = new CheckoutFrm();
            CheckOutControl checkOutControl
                     = new CheckOutControl(checkoutFrm);
            checkoutFrm.setVisible(true);
        }
        
    }
}
