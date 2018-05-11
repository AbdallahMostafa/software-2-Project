package com.swproject.swiis.Controllers;

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

    //-----------------------Repository-----------------------

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

    @Autowired
    UserRepo userRepo;

    @Autowired
    CartRepo cartRepo;

    private Set<Product> generateList(Iterable<Product> iterable)
    {
        Set<Product> products = new HashSet<Product>();
        for(Product product : iterable)
        {
            products.add(product);
        }
        return products;
    }
    //----------------------Add Product to store------------------------
    @CrossOrigin
    @PostMapping("/ShowProduct")
    public Set<Product> ShowProduct()
    {
        Iterable<Product> productIterable = productRepo.findAll();
        Set<Product> products = generateList(productIterable);
        return products;
    }
    @CrossOrigin
    @PostMapping("/AssignProductToStore")
    public  boolean AssignProductToStore(@RequestBody RequestBodyObjects requestBodyObjects)
    {
        System.out.println(requestBodyObjects.getStore().getStoreName());
        System.out.println(requestBodyObjects.getProduct().getProductName());
        if((storeRepo.existsById(requestBodyObjects.getStore().getStoreName())) && (!productInstanceRepo.existsById(requestBodyObjects.getProductInstance().getId())))
        {
            requestBodyObjects.getProductInstance().setCart(null);
            requestBodyObjects.getProductInstance().setProduct(requestBodyObjects.getProduct());
            requestBodyObjects.getProductInstance().setStore(requestBodyObjects.getStore());
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
    //----------------------Add Collaborators to store------------------------
    @CrossOrigin
    @PostMapping("/AddCollaborators")
    public boolean AddCollaborators(@RequestBody RequestBodyObjects requestBodyObjects)
    {
        if(userRepo.existsById(requestBodyObjects.getCollaborator()))
        {
            User tempUser = userRepo.findById(requestBodyObjects.getCollaborator()).get();
            if(tempUser.getUserName().equals(requestBodyObjects.getCollaborator()))
            {
                for(Store store : requestBodyObjects.getUser().getStores())
                {

                }
            }
        }
        return false;
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

    private String collaborator;

    private int boughtProducts;

    public int getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(int boughtProducts) {
        this.boughtProducts = boughtProducts;
    }

    public String getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(String collaborator) {
        this.collaborator = collaborator;
    }

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