package com.swproject.swiis.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "productInstance")
public class ProductInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private double price;
    private int counter, quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public ProductInstance(double price, Product product, Store store, Cart cart, int counter, int quantity) {
        this.price = price;
        this.product = product;
        this.store = store;
        this.cart = cart;
        this.counter = counter;
        this.quantity = quantity;
    }





    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductInstance(double price, Product product, Store store, int counter) {
        this.price = price;
        this.product = product;
        this.store = store;
        this.counter = counter;
    }

    public int getCounter() {
        return counter++;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public ProductInstance(){
        this.cart = new Cart();
        this.counter = 0;
        this.price = 0;
        this.product = new Product();
        this.store = new Store();
        this.quantity = 0;
    };

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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
