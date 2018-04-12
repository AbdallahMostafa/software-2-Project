package com.swproject.swiis.Entity;

import javax.persistence.*;

@Entity
public class ProductInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    double price;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Store store;
    private int counter;

    public ProductInstance(double price, Product product, Store store, int counter) {
        this.price = price;
        this.product = product;
        this.store = store;
        this.counter = counter;
    }
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

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
