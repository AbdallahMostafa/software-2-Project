package com.swproject.swiis.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class StoreOwner extends User{

    @OneToMany(targetEntity = Store.class, cascade = CascadeType.ALL)
    private Set<Store> stores;

    @OneToMany(targetEntity = SuggestedStores.class, cascade = CascadeType.ALL)
    private Set<SuggestedStores> suggestedStores;

    public StoreOwner(String name, String userName, String passWord, String email,String type) {
        super();
        /*this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.type = type;*/
        this.suggestedStores = new HashSet<SuggestedStores>();
        this.stores = new HashSet<Store>();
    }

    public StoreOwner() {
        /*his.email = "";
        this.name = "";
        this.passWord = "";
        this.userName ="";
        this.type = "";*/
        this.stores = new HashSet<Store>();
        this.suggestedStores = new HashSet<SuggestedStores>();
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
