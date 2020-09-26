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
public class Client {
    private int id;
    private String nameClient;
    private int idNumber;
    private String typeCard;
    private String address;
    private String des;

    public Client(int id, String nameClient, int idNumber, String typeCard, String address, String des) {
        this.id = id;
        this.nameClient = nameClient;
        this.idNumber = idNumber;
        this.typeCard = typeCard;
        this.address = address;
        this.des = des;
    }

    
    public Client(String nameClient, int idNumber, String typeCard, String address, String des) {
        this.nameClient = nameClient;
        this.idNumber = idNumber;
        this.typeCard = typeCard;
        this.address = address;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(String typeCard) {
        this.typeCard = typeCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    public Object[] toObjects(){
        return new Object[]{nameClient,idNumber,typeCard,address,des};
    }
}
