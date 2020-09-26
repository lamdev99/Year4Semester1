/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.bookroom;

import view.AddClientDialog;
import controller.dao.SearchClientDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Client;
import view.BookRoomFrm;
import view.SearchClientFrm;

/**
 *
 * @author lamit
 */
public class SearchClientControl {
    private ArrayList<Client> listClients = new ArrayList<>();
    private Client clientChoose;
    private SearchClientFrm searchClientFrm;
    SearchClientDao searchClientDao;
    public SearchClientControl(SearchClientFrm searchClientFrm) {
        this.searchClientFrm = searchClientFrm;
        searchClientDao = new SearchClientDao();
        searchClientFrm.setAction(new ButtonSearchAction(), new ButtonAddAction(), new ButtonChooseRoom());
    }
    class ButtonChooseRoom implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(searchClientFrm.getSelectedRow() >=0 && searchClientFrm.getSelectedRow() < listClients.size()){
                BookRoomFrm bookRoomFrm = new BookRoomFrm();
                BookRoomControl bookRoomControl = new BookRoomControl(bookRoomFrm,
                        listClients.get(searchClientFrm.getSelectedRow()) );
                bookRoomFrm.setVisible(true);
            }
        }
        
    }
    class ButtonSearchAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String key = searchClientFrm.getKeySearch();
            listClients = searchClientDao.searchClient(key);
            searchClientFrm.setListClient(listClients);
        }
        
    }
    class ButtonAddAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            AddClientDialog addClientDialog = new AddClientDialog(searchClientFrm, true);
            new AddClientControl(addClientDialog);
            addClientDialog.setVisible(true);
        }
        
    }
}
