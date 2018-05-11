package com.swproject.swiis.Entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int cartId;

    private int boughtProducts;

    @JsonIgnore
    @OneToMany(mappedBy = "cart",fetch = FetchType.EAGER)
    private Set<ProductInstance> productInstance;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userName_id")
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

    public Cart(int boughtProducts, Set<ProductInstance> productInstance, User user) {
        this.boughtProducts = boughtProducts;
        this.productInstance = productInstance;
        this.user = user;
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
