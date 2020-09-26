/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.bookroom;

import controller.dao.SearchClientDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.AddClientDialog;

/**
 *
 * @author lamit
 */
public class AddClientControl {
    private AddClientDialog addClientDialog;
    SearchClientDao searchClientDao;
    public AddClientControl(AddClientDialog addClientDialog) {
        this.addClientDialog = addClientDialog;
        searchClientDao = new SearchClientDao();
        addClientDialog.setAction(new ButtonAddClient(), new ButtonCancel());
    }
    class ButtonAddClient implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(searchClientDao.addClient(addClientDialog.getClient())){
                JOptionPane.showMessageDialog(addClientDialog, "Add Client Sucessfully");
            }
            else{
                JOptionPane.showMessageDialog(addClientDialog, "Add Client Unsucessfully");
            }
            addClientDialog._dispose();
        }
        
    }
    class ButtonCancel implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            addClientDialog._dispose();
        }
        
    }
}
