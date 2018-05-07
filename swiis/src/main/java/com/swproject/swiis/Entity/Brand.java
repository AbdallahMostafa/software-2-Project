package com.swproject.swiis.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int brandId;

    private String brandName;

    @OneToMany(mappedBy = "brand",cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
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
}
