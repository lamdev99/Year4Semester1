/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.checkout;

import controller.dao.BillDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Bill;
import view.BillDialog;

/**
 *
 * @author lamit
 */
public class BillControl {
    private BillDialog dialog;
    BillDao dao;
    Bill bill = new Bill();
    public BillControl(BillDialog dialog) {
        this.dialog = dialog;
        dao = new BillDao();
        dialog.setAction(new ConfirmAction());
    }
    public void setBill(Bill bill){
        this.bill = bill;
        dialog.setBill(bill);
    }
        
    class ConfirmAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(dao.insertBill(bill)){
                dialog._dispose();
            }else{
                dialog._dispose();
            }
        }
        
    }
}
