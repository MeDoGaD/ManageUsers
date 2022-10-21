package com.cis.manageAccounts.users;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Document(collection = "users")
public class User {

    @Id
    private String userID;
    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message ="Email is required" )
    private String email;
    @NotNull(message = "City is required")
    private String city;
    @NotNull
    @Size(min =5,message = "Phone must be at least 5 numbers")
    private String phone;
    private long timeStamp;

    public User(String userID, String name, String email, String city, String phone) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.city = city;
        this.phone = phone;
        this.timeStamp=System.currentTimeMillis();
    }

    public User() {
        this.timeStamp=System.currentTimeMillis();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
