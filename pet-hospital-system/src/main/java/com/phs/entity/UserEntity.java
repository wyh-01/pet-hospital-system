package com.phs.entity;

/**
 * Created by wyh on 2023/3/22
 */
public class UserEntity {

    private int id;
    private String userName;
    private String password;
    private int role;

    public UserEntity(){}
    public UserEntity(String userName, String password, int role){
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
