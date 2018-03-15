package com.swproject.swiis.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Store {
    private String storeLocation,type;
    @Id
    private String storeName;
    //storeType


    public Store(String storeLocation, String storeName, String type) {
        this.storeLocation = storeLocation;
        this.storeName = storeName;
        this.type = type;
    }

    public Store() {
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

       public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
