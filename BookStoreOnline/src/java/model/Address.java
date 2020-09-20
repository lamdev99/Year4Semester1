/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author lamit
 */
public class Address implements Serializable{
    private int id;

    
    private int numHome;
    private String street;
    private String district;
    public Address(int id, int numHome, String street, String district) {
        this.id = id;
        this.numHome = numHome;
        this.street = street;
        this.district = district;
    }
    public Address(int numHome, String street, String district) {
        this.numHome = numHome;
        this.street = street;
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumHome() {
        return numHome;
    }

    public void setNumHome(int numHome) {
        this.numHome = numHome;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    
    
}
