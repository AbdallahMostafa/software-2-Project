package com.swproject.swiis.Entity;

import javax.persistence.*;

@Entity
public class Product {
    private String productName, productCategory,productType,type;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private double productPriceMax,productPriceMin;
    @ManyToOne
    Brand brand;

    public long getID() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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
        this.productPriceMin = 0.0;
        this.productType = "";
        this.type = "";
        this.brand = new Brand();
    }
    public Product(String productName, String productCategory, String productType, double productPriceMin,double productPriceMax , String type, Brand brand) {
        super();
        this.productName = productName;
        this.productCategory = productCategory;
        this.productType = productType;
        this.productPriceMin = productPriceMin;
        this.productPriceMax= productPriceMax;
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
    public double getProductPriceMax() {
        return productPriceMax;
    }
    public double getProductPriceMin() {
        return productPriceMin;
    }

    public void setProductPriceMax(double productPrice) {
        this.productPriceMax = productPrice;
    }
    public void setProductPriceMin(double productPrice) {
        this.productPriceMin = productPrice;
    }




}
