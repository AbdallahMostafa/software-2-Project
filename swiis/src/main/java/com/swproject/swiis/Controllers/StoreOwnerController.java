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
    @PostMapping("/ShowProductOfSystem")
    public Set<Product> showStores()
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
    public  boolean AddProductToStore(@RequestBody RequstBodyObjects requstBodyObjects)
    {
        if(storeRepo.existsById(requstBodyObjects.getStore().getStoreName()) && productInstanceRepo.existsById(requstBodyObjects.getProductInstance().getId()))
        {
            requstBodyObjects.getProductInstance().setStore(requstBodyObjects.getStore());
            productInstanceRepo.save(requstBodyObjects.getProductInstance());
            return true;
        }
        return false;
    }
    //---------------------- suggest store -----------------------
    @CrossOrigin
    @PostMapping("/SuggestStore")
    public boolean Add(@RequestBody RequstBodyObjects requstBodyObjects)
    {
        if(!suggestedStoresRepo.existsById(requstBodyObjects.getSuggestedStores().getStoreName()))
        {
            requstBodyObjects.getSuggestedStores().setStoreOwner(requstBodyObjects.getStoreOwner());
            suggestedStoresRepo.save(requstBodyObjects.getSuggestedStores());
            return true;
        }
        else
        {
            return false;
        }
    }
}
class RequstBodyObjects
{

    private User storeOwner;
    private Store store;
    private SuggestedStores suggestedStores;
    private ProductInstance productInstance;

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
    public User getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(User storeOwner) {
        this.storeOwner = storeOwner;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}