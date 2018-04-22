package com.swproject.swiis.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {

    @Id
    int id;

    @OneToMany(targetEntity = ProductInstance.class,cascade = CascadeType.ALL)
    private Set<ProductInstance> productInstance;

    @OneToMany
    private NormalUser normalUser;

    public Cart() {
        this.productInstance = new HashSet<ProductInstance>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NormalUser getNormalUser() {
        return normalUser;
    }

    public void setNormalUser(NormalUser normalUser) {
        this.normalUser = normalUser;
    }

    public Set<ProductInstance> getProductInstance() {
        return productInstance;
    }

    public void setProductInstance(Set<ProductInstance> productInstance) {
        this.productInstance = productInstance;
    }
}
