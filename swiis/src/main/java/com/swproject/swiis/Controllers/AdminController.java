package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.Admin;
import com.swproject.swiis.Entity.Store;
import com.swproject.swiis.Entity.SuggestedStores;
import com.swproject.swiis.Repositories.AdminRepo;
import com.swproject.swiis.Repositories.StoreRepo;
import com.swproject.swiis.Repositories.SuggestedStoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class AdminController {
    @Autowired
    AdminRepo adminRepo;

    @Autowired
    SuggestedStoresRepo suggestedStoresRepo;

    @Autowired
    StoreRepo storeRepo;

    public Set<SuggestedStores> generateList(Iterable<SuggestedStores> iterable)
    {
        Set<SuggestedStores> storeList = new HashSet<SuggestedStores>();
        for(SuggestedStores suggestedStores : iterable)
        {
            storeList.add(suggestedStores);
        }
        return storeList;
    }

    //-----------------------Login---------------------------
    @CrossOrigin
    @PostMapping("/AdminLogin")
    public Admin get (@RequestBody Admin admin)
    {
        if(adminRepo.existsById(admin.getUserName())) {
            Admin tempadmin = adminRepo.findById(admin.getUserName()).get();
            if (tempadmin.getUserName().equals(admin.getUserName()) && tempadmin.getPassWord().equals(admin.getPassWord()))
                return tempadmin;
        }
        return null;
    }
    //-------------------------Verify------------------------
    @CrossOrigin
    @PostMapping("/ShowStores")
    public Set<SuggestedStores> showStores()
    {
        Iterable<SuggestedStores> suggestedStores = suggestedStoresRepo.findAll();
        Set<SuggestedStores> suggestedStoresList = generateList(suggestedStores);
        /*for(int i = 0; i < suggestedStoresList.size(); i++)
        {
            System.out.println(suggestedStoresList.get(i).getStoreName());
        }*/
        return suggestedStoresList;
    }
    @CrossOrigin
    @PostMapping("/AcceptStore")
    public boolean AddStore(String storeName)
    {
        if(suggestedStoresRepo.existsById(storeName))
        {
            SuggestedStores suggestedStores = suggestedStoresRepo.findById(storeName).get();
            Store store = new Store(suggestedStores.getStoreLocation(),suggestedStores.getStoreName(),suggestedStores.getType(),suggestedStores.getStoreOwner());
            storeRepo.save(store);
            suggestedStoresRepo.delete(suggestedStores);
            return true;
        }
        else
            return false;
    }
}
