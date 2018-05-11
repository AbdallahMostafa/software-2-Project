package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.Store;
import com.swproject.swiis.Entity.SuggestedStores;
import com.swproject.swiis.Repositories.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class StoreController {

    //-----------------------Repository-----------------------
    @Autowired
    StoreRepo storeRepo;

    public Set<Store> generateSet(Iterable<Store> iterable)
    {
        Set<Store> storeList = new HashSet<Store>();
        for(Store store : iterable)
        {
            storeList.add(store);
        }
        return storeList;
    }
    @CrossOrigin
    @PostMapping("/showStoresOfSystem")
    public Set<Store> showStores()
    {
        Iterable<Store > storeIterable = storeRepo.findAll();
        Set<Store> storeSet = generateSet(storeIterable);
        return storeSet;
    }
}
