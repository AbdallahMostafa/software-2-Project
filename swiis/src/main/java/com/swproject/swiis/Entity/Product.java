package com.swproject.swiis.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
    private String productName, productCategory,productType;
    @Id
    private String ID;
    private double maxProductPrice,minProductPrice;
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
        this.minProductPrice = 0.0;
        this.maxProductPrice=1e9;
        this.productType = "";
        this.type = "";
        this.brand = new Brand();
    }
    private Product(String productName, String productCategory, String productType, double minProductPrice, double maxProductPrice , String type, Brand brand) {
        super();
        this.productName = productName;
        this.productCategory = productCategory;
        this.productType = productType;
        this.minProductPrice = minProductPrice;
        this.maxProductPrice = maxProductPrice;
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
    public double getMaxProductPrice() {
        return maxProductPrice;
    }
    public double getMinProductPrice() { return minProductPrice; }

    private String type;


}
