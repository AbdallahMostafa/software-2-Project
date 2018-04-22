package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.Product;
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
    public Set<ProductInstance> generateProductSet(Iterable<ProductInstance> iterable)
    {
        Set<ProductInstance> storeList = new HashSet<ProductInstance>();
        for(ProductInstance productInstance : iterable)
        {
            storeList.add(productInstance);
        }
        return storeList;
    }
    @CrossOrigin
    @PostMapping("/showProductOfStore")
    public Set<ProductInstance> showProduct(String storeName)
    {
       if(storeRepo.existsById(storeName))
       {
           Iterable<ProductInstance> storeIterable = productInstanceRepo.findAll();
           Set<ProductInstance> storeSet = generateProductSet(storeIterable);
           return storeSet;
       }
       return null;
    }
}
