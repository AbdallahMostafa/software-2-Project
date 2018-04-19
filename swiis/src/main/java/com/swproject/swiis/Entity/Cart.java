package com.swproject.swiis.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity
public class Cart {

    @OneToOne(cascade = CascadeType.ALL)
    private NormalUser normalUser;

    public NormalUser getNormalUser() {
        return normalUser;
    }

    public void setNormalUser(NormalUser normalUser) {
        this.normalUser = normalUser;
    }

    public Set<ProductInstance> getProductInstance() {
        return productInstance;
    }

    public void setProductInstance(Set<ProductInstance> productInstance) {
        this.productInstance = productInstance;
    }

    @ManyToMany(cascade = CascadeType.ALL)

    private Set<ProductInstance> productInstance;
}
