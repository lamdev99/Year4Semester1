/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Account;
import model.Customer;

/**
 *
 * @author lamit
 */
public interface LoginDao {
    Customer login(Account account);
}
