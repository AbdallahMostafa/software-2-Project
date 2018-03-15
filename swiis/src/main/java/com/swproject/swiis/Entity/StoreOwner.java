package com.swproject.swiis.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class StoreOwner {

    private String name,passWord,email,type;
    @Id
    private String userName;

    @OneToMany(targetEntity = Store.class, cascade = CascadeType.ALL, mappedBy = "storeOwner")
    private Set<Store> stores;

    @OneToMany(targetEntity = SuggestedStores.class, cascade = CascadeType.ALL, mappedBy = "storeOwner")
    private Set<SuggestedStores> suggestedStores;

    public StoreOwner(String name, String userName, String passWord, String email,String type)
    {
        super();
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.type = type;
        this.suggestedStores = new HashSet<SuggestedStores>();
        this.stores = new HashSet<Store>();
    }

    public StoreOwner() {
        this.email = "";
        this.name = "";
        this.passWord = "";
        this.userName ="";
        this.type = "";
        this.stores = new HashSet<Store>();
        this.suggestedStores = new HashSet<SuggestedStores>();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }
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
}
