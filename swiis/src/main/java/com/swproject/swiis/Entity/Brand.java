package com.swproject.swiis.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Brand {
    @Id
    private String brandName;
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    private Set<Product> products;

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
