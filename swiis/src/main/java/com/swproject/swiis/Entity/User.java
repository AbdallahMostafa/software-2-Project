package com.swproject.swiis.Entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User
{
    @OneToOne
    private Cart cart;

    @Id
    private String userName;

    private String name ,passWord,email,type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User(String name, String userName, String passWord, String email, String type) {
        //super();
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.type = type;
    }

    public User() {
        this.name = "";
        this.userName = "";
        this.passWord = "";
        this.email = "";
        this.type = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
