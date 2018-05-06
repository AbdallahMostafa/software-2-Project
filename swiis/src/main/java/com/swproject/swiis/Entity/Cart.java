package com.swproject.swiis.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {

    @Id
    private int cartId;
    private int boughtProducts;
    @OneToMany
    private Set<ProductInstance> productInstance;


    @ManyToOne
    private User user;

    public int getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(int boughtProducts) {
        this.boughtProducts = boughtProducts;
    }

    public Cart() {
        this.productInstance = new HashSet<ProductInstance>();

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Set<ProductInstance> getProductInstance() {
        return productInstance;
    }

    public void setProductInstance(Set<ProductInstance> productInstance) {
        this.productInstance = productInstance;
    }
}
