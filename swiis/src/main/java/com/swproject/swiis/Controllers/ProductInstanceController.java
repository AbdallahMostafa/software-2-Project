package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.ProductInstance;
import com.swproject.swiis.Entity.Store;
import com.swproject.swiis.Repositories.ProductInstanceRepo;
import com.swproject.swiis.Repositories.ProductRepo;
import com.swproject.swiis.Repositories.StoreRepo;
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
            Store store = storeRepo.findById(storeName).get();
            Set<ProductInstance> storeset = store.getProdcutInstance();
            for(ProductInstance productInstance : storeset )
            {
                System.out.println(productInstance.getStore().getStoreOwner().getName());
            }
            return store.getProdcutInstance();
       }
       return null;
    }
}
