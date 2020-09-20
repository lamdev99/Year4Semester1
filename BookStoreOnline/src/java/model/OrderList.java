/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author lamit
 */
public class OrderList implements Serializable{
    private int id;
    private ArrayList<Book> listBook;

    public OrderList(int id, ArrayList<Book> listBook) {
        this.id = id;
        this.listBook = listBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Book> getListBook() {
        return listBook;
    }

    public void setListBook(ArrayList<Book> listBook) {
        this.listBook = listBook;
    }
    
}
