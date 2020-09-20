/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Account;
import model.Book;
import model.Order;

/**
 *
 * @author lamit
 */
public interface CreateOrderDao {
    void createDao(ArrayList<Book> listBook, Account account, Order order);
}
