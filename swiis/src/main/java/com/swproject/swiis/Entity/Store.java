package com.swproject.swiis.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Store {
    private String storeLocation,type;
    @Id
    private String storeName;

    @ManyToOne
    private StoreOwner storeOwner;

    @OneToMany(targetEntity = ProductInstance.class, cascade = CascadeType.ALL, mappedBy = "store")
    private Set<ProductInstance> productInstance;
    
    public Store(String storeLocation, String storeName, String type,StoreOwner storeOwner) {
        this.storeLocation = storeLocation;
        this.storeName = storeName;
        this.type = type;
        this.storeOwner = storeOwner;
        productInstance = null;
    }

    public Store() {
        this.storeLocation = "";
        this.storeName = "";
        this.type = "";
        this.storeOwner = new StoreOwner();
        this.productInstance = null;
    }


    public void setProductInstance(ProductInstance productInstance) {
        this.productInstance.add(productInstance);
    }

    public Set<ProductInstance> getProdcutInstance() {return productInstance;}

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
