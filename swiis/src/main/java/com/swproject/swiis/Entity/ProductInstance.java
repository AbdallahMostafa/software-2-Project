package com.swproject.swiis.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductInstance {
    private Product product;
    private int quantity;
    private int purchased;
    @Id
    private String ID;
    private double productPrice;
    private int views;

    public String getID() { return ID; }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ProductInstance()
    {
        this.productPrice = 0.0;
        this.product=product;
        this.quantity=0;
        this.views=0;
        this.purchased=0;
    }
    public ProductInstance(Product product, double productPrice, int quantity) {
        super();
        this.product = product;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.views=0;
        this.purchased=0;
    }
    //brandName

    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() { return  quantity ;}
    public void setQuantity(int quantity) { this.quantity=quantity; }

    public void setProduct(Product product) { this.product = product; }
    public Product getProduct() { return product; }

    public int getViews() { return views; }
    public void setViews() { this.views++; }

    public int getPurchased() {return purchased; }
    public void setPurchased() { this.purchased++; }
}
