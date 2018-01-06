package com.ikki.cloud.userCustomer.entity;

import java.io.Serializable;

public class User implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8893583370255576061L;
    
    private int id;
    private String username;
    private String password;
    private boolean gender;
    
    public User() {
        super();
    }

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
    
/*    public User(int id, String username, String password, boolean gender) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }*/

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isGender() {
        return gender;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    
}
