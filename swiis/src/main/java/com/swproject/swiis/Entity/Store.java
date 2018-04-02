package com.swproject.swiis.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Store {
    private String storeLocation,type;
    @Id
    private String storeName;

    //storeType
    @ManyToOne
    private StoreOwner storeOwner;
    @OneToMany
    private ProductInstance productInstance;
    
    public Store(String storeLocation, String storeName, String type,StoreOwner storeOwner) {
        this.storeLocation = storeLocation;
        this.storeName = storeName;
        this.type = type;
        this.storeOwner = storeOwner;
    }

    public Store() {
        this.storeLocation = "";
        this.storeName = "";
        this.type = "";
        this.storeOwner = new StoreOwner();
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) { this.type = type; }

    public StoreOwner getStoreOwner() { return storeOwner; }

    public void setStoreOwner(StoreOwner storeOwner) { this.storeOwner = storeOwner; }
}
