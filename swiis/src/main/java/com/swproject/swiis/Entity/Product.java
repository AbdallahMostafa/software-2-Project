package com.swproject.swiis.Entity;

import javax.persistence.*;

@Entity
public class Product {
    private String productName, productCategory,productType,type;
    /*@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    */
    @Id
    private String ID;
    private double productPrice;
    @ManyToOne
    Brand brand;

    public String getID() {
        return ID;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product()
    {
        this.productCategory = "";
        this.productName = "";
        this.productPrice = 0.0;
        this.productType = "";
        this.type = "";
        this.brand = new Brand();
    }
    public Product(String productName, String productCategory, String productType, double productPrice , String type, Brand brand) {
        super();
        this.productName = productName;
        this.productCategory = productCategory;
        this.productType = productType;
        this.productPrice = productPrice;
        this.type = type;
        this.brand = brand;
    }
    //brandName

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductCategory() {
        return productCategory;
    }
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }




}
