package com.swproject.swiis.Entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "store")
public class Store {
    private String storeLocation,type;
    @Id
    private String storeName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "userName_id")
    private User storeOwner;

    @JsonIgnore
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private Set<ProductInstance> productInstance;

    public Store(String storeLocation, String storeName, String type,User storeOwner) {
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
        this.storeOwner = new User();
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

    public User getStoreOwner() { return storeOwner; }

    public void setStoreOwner(User storeOwner) { this.storeOwner = storeOwner; }
}
