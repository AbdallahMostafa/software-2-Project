package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.Product;
import com.swproject.swiis.Entity.ProductInstance;
import com.swproject.swiis.Entity.Store;
import com.swproject.swiis.Repositories.ProductInstanceRepo;
import com.swproject.swiis.Repositories.ProductRepo;
import com.swproject.swiis.Repositories.StoreRepo;
import javafx.scene.layout.StackPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductInstanceController {

    @Autowired
    StoreRepo storeRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ProductInstanceRepo productInstanceRepo;

    private Set<Store> generateSet(Iterable<Store> iterable)
    {
        Set<Store> storeSet = new HashSet<Store>();
        for(Store store : iterable)
        {
            storeSet.add(store);
        }
        return storeSet;
    }
    public Set<ProductInstance> generateProductSet(Iterable<ProductInstance> iterable)
    {
        Set<ProductInstance> storeList = new HashSet<ProductInstance>();
        for(ProductInstance productInstance : iterable)
        {
            storeList.add(productInstance);
        }
        return storeList;
    }
    /*@PostMapping("/getProduct")
    public Set<ProductInstance> showProducts()
    {
        Iterable<Store> storeIterable = storeRepo.findAll();
        Set<Store> storeSet = generateSet(storeIterable);
        Set<ProductInstance> productInstanceSet = new HashSet<ProductInstance>();
        for (Store store : storeSet)
        {

        }
        return storeSet;
    }*/

    @CrossOrigin
    @PostMapping("/showProductOfStore")
    public Set<ProductInstance> showProduct(String storeName)
    {
       if(storeRepo.existsById(storeName))
       {
           /*Iterable<ProductInstance> productInstanceIterable = productInstanceRepo.findAll();
           Set<ProductInstance> productInstanceSet = generateProductSet(productInstanceIterable);
           for( ProductInstance productInstance : productInstanceSet)*/
           Iterable<ProductInstance> storeIterable = productInstanceRepo.findAll();
           Set<ProductInstance> storeSet = generateProductSet(storeIterable);
           for (ProductInstance store : storeSet) {
               /*for (ProductInstance productInstance : store.getProdcutInstance())
               {
                   System.out.println(productInstance.getProduct().getProductName());
               }
               System.out.println(store.getStoreName());
               System.out.println(store.getStoreOwner().getName());
           }*/
          /* System.out.println(tempstore.getProdcutInstance());
           Set<ProductInstance> storeset = tempstore.getProdcutInstance();
         for(ProductInstance productInstance : storeset )
           {
                System.out.println(productInstance.getProduct().getProductName());
                System.out.println(productInstance.getProduct().getID());
                System.out.println(productInstance.getProduct().getBrand());
           }*/
           }
           return storeSet;
           //return productInstanceSet;*/
       }
       return null;
    }
}
