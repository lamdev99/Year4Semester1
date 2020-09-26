/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.dao.LoginDao;
import controller.dao.MainDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.User;
import view.HomeManagement;
import view.LoginFrm;

/**
 *
 * @author lamit
 */
public class LoginControl{
    LoginFrm loginFrm;
    LoginDao loginDao;
    public LoginControl(LoginFrm loginFrm) {
        this.loginDao = new LoginDao();
        this.loginFrm = loginFrm;
        loginFrm.setAction(new ButtonAction());
    }
    class ButtonAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            User user = loginFrm.getUser();
            if(loginDao.checkLogin(user)){
                JOptionPane.showMessageDialog(loginFrm, "Login Sucessful");
                HomeManagement homeManagement
                         = new HomeManagement();
                homeManagement.setVisible(true);
                HomeControl homeControl = new HomeControl(homeManagement);
                
            }else{
                JOptionPane.showMessageDialog(loginFrm, "Check your login!!");
            }
        }
        
    }
}
