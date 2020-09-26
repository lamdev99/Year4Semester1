/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author lamit
 */
public class Bill {
    private int id;
    private BookRoom br;
    private long total;
    private Date payDate;

    public Bill() {
    }
    
    public Bill(BookRoom br, long total, Date payDate) {
        this.br = br;
        this.total = total;
        this.payDate = payDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookRoom getBr() {
        return br;
    }

    public void setBr(BookRoom br) {
        this.br = br;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
    
    public void setBookRoom(BookRoom br){
        this.total = br.getRoom().getPricePerHour();
    }
}
