/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.checkout;

import controller.checkout.BillControl;
import controller.dao.SearchBookRoomDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Bill;
import model.BookRoom;
import view.BillDialog;
import java.util.concurrent.TimeUnit;
import view.CheckoutFrm;

/**
 *
 * @author lamit
 */
public class CheckOutControl {
    public long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
    private CheckoutFrm checkoutFrm;
    ArrayList<BookRoom> listBookRooms = new ArrayList<>();
    SearchBookRoomDao dao;
    public CheckOutControl(CheckoutFrm checkoutFrm) {
        this.checkoutFrm = checkoutFrm;
        dao = new SearchBookRoomDao();
        checkoutFrm.setAction(new ButtonSearchCheckout(), new ButtonCheckout());
    }
    class ButtonSearchCheckout implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            listBookRooms = dao.getListBookRoomCheckOut(checkoutFrm.getSearchKey());
            checkoutFrm.addToTable(listBookRooms);
        }
        
    }
    class ButtonCheckout implements ActionListener{
        
        
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            int index = checkoutFrm.getSelectedRow();
            if(index >= 0 && index < listBookRooms.size()){
                BookRoom br = listBookRooms.get(index);
                br.setTimeCheckout(Calendar.getInstance().getTime());
                if(dao.updateBookRoomCheckOut(br)){
                    JOptionPane.showMessageDialog(checkoutFrm, "Checkout Successfully");
                    BillDialog billDialog = new BillDialog(checkoutFrm, true);
                    Date date = new Date();
                    long diffInMillies = br.getTimeCheckout().getTime() - br.getTimeCheckin().getTime();
                    long hour = TimeUnit.HOURS.convert(diffInMillies,TimeUnit.MILLISECONDS);
                    System.out.println(hour);
                    Bill bill = new Bill(br, hour*br.getRoom().getPricePerHour() , date);
                    
                    BillControl billControl = new BillControl(billDialog);
                    billControl.setBill(bill);
                    billDialog.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(checkoutFrm, "Checkout Failed");
                }
            }
        }
        
    }
}
