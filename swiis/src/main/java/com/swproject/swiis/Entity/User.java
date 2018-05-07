package com.swproject.swiis.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "user")
public class User
{
    @Id
    private String userName;

    private String name ,passWord,email;

    public User(String name, String userName, String passWord, String email) {
        //super();
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
    }
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Cart> cart;

    @OneToMany(mappedBy = "storeOwner",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Store> stores;

    @OneToMany( mappedBy = "storeOwner",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<SuggestedStores> suggestedStores;

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public Set<SuggestedStores> getSuggestedStores() {
        return suggestedStores;
    }

    public void setSuggestedStores(Set<SuggestedStores> suggestedStores) {
        this.suggestedStores = suggestedStores;
    }

    public User() {
        this.name = "";

        this.userName = "";
        this.passWord = "";
        this.email = "";
        this.cart = new HashSet<Cart>();
        this.suggestedStores = new HashSet<SuggestedStores>();
        this.stores = new HashSet<Store>();
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

    public Set<Cart> getCart() {
        return cart;
    }

    public void setCart(Set<Cart> cart) {
        this.cart = cart;
    }
}
