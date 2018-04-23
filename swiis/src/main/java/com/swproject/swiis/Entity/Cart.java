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

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    private User user;

    public Cart() {
        this.productInstance = new HashSet<ProductInstance>();

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<ProductInstance> getProductInstance() {
        return productInstance;
    }

    public void setProductInstance(Set<ProductInstance> productInstance) {
        this.productInstance = productInstance;
    }
}
