package com.willbe.lifeos.model;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Creation date: 10/12/15
 *
 * @author Vitalii Siryi
 */
public class UserModel {

    @Id
    private String id;

    private String name;
    private String password;
    private String description;

    public UserModel() {
    }

    public UserModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserDetails convertToUserDetails(){
        Collection<? extends GrantedAuthority> authorities = new ArrayList<>();
        return new User(name, password, authorities);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
