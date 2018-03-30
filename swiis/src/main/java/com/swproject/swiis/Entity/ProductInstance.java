package com.swproject.swiis.Entity;

import javax.persistence.*;

@Entity
public class ProductInstance {
    private Product product;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    double price;
    @ManyToOne
    private Store store;

    public ProductInstance(){};
    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public double getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Store getStore() {
        return store;
    }
}
