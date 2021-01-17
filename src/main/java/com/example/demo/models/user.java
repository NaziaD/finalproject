package com.example.demo.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class user {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "admin")
    private Boolean admin;

    public user() {}

    public user(String id, String username, String password, Boolean admin){
        this.id = id;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admini) {
        this.admin = admin;
    }
}
