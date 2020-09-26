/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lamit
 */
public class Room {
    private int id;
    private String nameRoom;
    private int rank;
    private int pricePerHour;
    private String des;

    public Room(int rank, String des) {
        this.rank = rank;
        this.des = des;
    }
    
    public Room(int id, String nameRoom, int rank, int pricePerHour, String des) {
        this.id = id;
        this.nameRoom = nameRoom;
        this.rank = rank;
        this.pricePerHour = pricePerHour;
        this.des = des;
    }

    public Room(String nameRoom, int rank, int pricePerHour, String des) {
        this.nameRoom = nameRoom;
        this.rank = rank;
        this.pricePerHour = pricePerHour;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    public Object[] toObjects(){
        return new Object[]{nameRoom,rank,pricePerHour,des};
    }
}
