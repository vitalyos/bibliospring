/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bbu.bibliospring.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author zsvitalyos
 */
@Entity
@Table (name = "BS_USER")
public class User extends BaseEntity {
    
    @Column (name = "firstName", nullable = false, length = 64)
    private String firstName;
    
    @Column (name = "lastName", nullable = false, length = 64)
    private String lastName;
    
    @Column (name = "userName", unique = true, nullable = false, length = 64)
    private String userName;
    
    @Column (name = "password", nullable = false, length = 128)
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
