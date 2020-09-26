/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.dao.MainSQLStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lamit
 */
public class BookRoom {
    private int id;
    private Room room;
    private Client client;
    private Date timeStart;
    private Date timeEnd;
    private Date timeCreate;
    private Date timeCheckin;
    private Date timeCheckout;

    public BookRoom(Room room, Client client, Date timeCreate, Date timeEnd, Date timeStart) {
        this.room = room;
        this.client = client;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.timeCreate = timeCreate;
    }

    public BookRoom(int id,Room room, Client client, Date timeStart, Date timeEnd, Date timeCreate, Date timeCheckin) {
        this.id = id;
        this.room = room;
        this.client = client;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.timeCreate = timeCreate;
        this.timeCheckin = timeCheckin;
    }

    
    
    public BookRoom(int id,Room room, Client client, Date timeCreate, Date timeStart, Date timeEnd) {
        this.id = id;
        this.room = room;
        this.client = client;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.timeCreate = timeCreate;
    }
    

    public BookRoom(Room room, Client client, Date timeStart, Date timeEnd) {
        this.room = room;
        this.client = client;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }
    public BookRoom(Room room, Client client) {
        this.room = room;
        this.client = client;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    public Date getTimeCheckin() {
        return timeCheckin;
    }

    public void setTimeCheckin(Date timeCheckin) {
        this.timeCheckin = timeCheckin;
    }

    public Date getTimeCheckout() {
        return timeCheckout;
    }

    public void setTimeCheckout(Date timeCheckout) {
        this.timeCheckout = timeCheckout;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public String changeDateToString(Date date){
        SimpleDateFormat simpleDateFormat
                = new SimpleDateFormat(MainSQLStatement.SIMPLE_DATE_FORMAT);
        return simpleDateFormat.format(date);
    }
    public Object[] toObjects(){
        return new Object[]{client.getNameClient(),room.getNameRoom(),changeDateToString(timeCreate),
            changeDateToString(timeStart),changeDateToString(timeEnd)};
    }
    public Object[] toObjects1(){
        return new Object[]{client.getNameClient(),room.getNameRoom(),changeDateToString(timeCreate),
            changeDateToString(timeStart),changeDateToString(timeEnd),changeDateToString(getTimeCheckin())};
    }
    
}
