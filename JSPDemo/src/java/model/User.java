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
public class User {
    
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String listMusic;
    public User(String firstName, String lastName,
            String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public User(String firstName, String lastName, String emailAddress, String listMusic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.listMusic = listMusic;
    }

    public String getListMusic() {
        return listMusic;
    }

    public void setListMusic(String listMusic) {
        this.listMusic = listMusic;
    }
    

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
