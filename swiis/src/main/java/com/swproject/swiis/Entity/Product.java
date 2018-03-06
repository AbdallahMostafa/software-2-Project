package com.swproject.swiis.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    private String productName, productCategory,productType;
    private double productPrice;

    @Id
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
    }
    public Product(String productName, String productCategory, String productType, double productPrice ,String type) {
        super();
        this.productName = productName;
        this.productCategory = productCategory;
        this.productType = productType;
        this.productPrice = productPrice;
        this.type = type;
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

    private String type;


}
