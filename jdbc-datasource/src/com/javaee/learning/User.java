package com.javaee.learning;

public class User {
    private int id;
    private String username;
    private String PASSWORD;

    /*必须有空的构造函数*/
    public User() {
    }

    public User(int id, String username, String PASSWORD) {
        this.id = id;
        this.username = username;
        this.PASSWORD = PASSWORD;
    }

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

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + PASSWORD + '\'' +
                '}';
    }
}
