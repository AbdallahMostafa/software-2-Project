package com.swproject.swiis.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Brand {
    @Id
    private String name;
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL, mappedBy = "brand")
    private Set<Product> products;

    public Brand() {
        name="";
        products=new HashSet<Product>();
    }

    public Brand(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
