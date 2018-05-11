package com.swproject.swiis.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brand")
@JsonIdentityInfo(
        scope = Brand.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "brandId")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int brandId;

    private String brandName;

    @JsonIgnore
    @OneToMany(mappedBy = "brand",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Product> products;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public Brand() {
        brandName="";
        products=new HashSet<Product>();
    }

    public Brand(String name, Set<Product> products) {
        this.brandName = name;
        this.products = products;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", products=" + products +
                '}';
    }
}
