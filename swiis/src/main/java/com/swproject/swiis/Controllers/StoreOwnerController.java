package com.swproject.swiis.Controllers;

import com.sun.scenario.effect.impl.prism.PrDrawable;
import com.swproject.swiis.Entity.*;
import com.swproject.swiis.Repositories.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController

public class StoreOwnerController {
    @Autowired
    BrandRepo brandRepo;

    @Autowired
    ProductInstanceRepo productInstanceRepo;

    @Autowired
    SuggestedStoresRepo suggestedStoresRepo;

    @Autowired
    StoreRepo storeRepo;

    @Autowired
    ProductRepo productRepo;

    private Set<Product> generateList(Iterable<Product> iterable)
    {
        Set<Product> products = new HashSet<Product>();
        for(Product product : iterable)
        {
            products.add(product);
        }
        return products;
    }
    /*@GetMapping("/AssignProductToStore")
    public  String create (Model model)
    {
        Iterable<Brand> brandIterable = brandRepo.findAll();
        List<Brand> brandList = generateList(brandIterable);
        model.addAttribute("brand", brandList);
        return "AssignProductToStore";
    }*/
    @CrossOrigin
    @PostMapping("/ShowProduct")
    public Set<Product> ShowProduct()
    {
        Iterable<Product> productIterable = productRepo.findAll();
        Set<Product> products = generateList(productIterable);
        return products;
    }
    /*@CrossOrigin
    @PostMapping("/AssignProductToStore")
    public  boolean AddProductToStore(@RequestBody ProductInstance productInstance , @RequestBody Store store)
    {
        if(storeRepo.existsById(store.getStoreName()) && productInstanceRepo.existsById(productInstance.getId()))
        {
            productInstance.setStore(store);
            productInstanceRepo.save(productInstance);
            return true;
        }
        return false;
    }*/
    @CrossOrigin
    @PostMapping("/AssignProductToStore")
    public  boolean AssignProductToStore(@RequestBody RequestBodyObjects requestBodyObjects)
    {
        if((storeRepo.existsById(requestBodyObjects.getStore().getStoreName())) && (!productInstanceRepo.existsById(requestBodyObjects.getProductInstance().getId())))
        {
            productInstanceRepo.save(requestBodyObjects.getProductInstance());
            return true;
        }
        return false;
    }
    //---------------------- suggest store -----------------------
    @CrossOrigin
    @PostMapping("/SuggestStore")
    public boolean Add(@RequestBody RequestBodyObjects requestBodyObjects)
    {
        if(!suggestedStoresRepo.existsById(requestBodyObjects.getSuggestedStores().getStoreName()))
        {
            requestBodyObjects.getSuggestedStores().setStoreOwner(requestBodyObjects.getUser());
            suggestedStoresRepo.save(requestBodyObjects.getSuggestedStores());
            return true;
        }
        else
        {
            return false;
        }
    }
}
class RequestBodyObjects
{

    private User user;
    private Store store;
    private SuggestedStores suggestedStores;
    private ProductInstance productInstance;
    private Product product;
    private Brand brand;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductInstance getProductInstance() {
        return productInstance;
    }

    public void setProductInstance(ProductInstance productInstance) {
        this.productInstance = productInstance;
    }

    public SuggestedStores getSuggestedStores() {
        return suggestedStores;
    }

    public void setSuggestedStores(SuggestedStores suggestedStores) {
        this.suggestedStores = suggestedStores;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}