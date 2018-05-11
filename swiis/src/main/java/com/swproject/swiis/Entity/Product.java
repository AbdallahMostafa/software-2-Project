package com.swproject.swiis.Entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    private String productName;

    private String productCategory,productType;

    private double productPriceMax,productPriceMin;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    Brand brand;

    @JsonIgnore
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<ProductInstance> productInstance;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<ProductInstance> getProductInstance() {
        return productInstance;
    }

    public void setProductInstance(Set<ProductInstance> productInstance) {
        this.productInstance = productInstance;
    }

    public Product()
    {
        this.productCategory = "";
        this.productName = "";
        this.productPriceMin = 0.0;
        this.productType = "";
        this.brand = new Brand();
    }
    public Product(String productName, String productCategory, String productType, double productPriceMin,double productPriceMax , String type, Brand brand) {
        super();
        this.productName = productName;
        this.productCategory = productCategory;
        this.productType = productType;
        this.productPriceMin = productPriceMin;
        this.productPriceMax= productPriceMax;
        this.brand = brand;
    }
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
