package com.swproject.swiis.Entity;

import javax.persistence.*;

@Entity
@Table(name = "suggestedStores")
public class SuggestedStores {
    private String storeLocation,type;
    @Id
    private String storeName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userName_id")
    private User storeOwner;

    public User getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(User storeOwner) {
        this.storeOwner = storeOwner;
    }

    public SuggestedStores(String storeLocation, String storeName, String type) {
        this.storeLocation = storeLocation;
        this.storeName = storeName;
        this.type = type;
    }

    public SuggestedStores() {
        this.storeLocation = "";
        this.storeName = "";
        this.type = "";
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}

