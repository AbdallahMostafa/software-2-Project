package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.ProductInstance;
import com.swproject.swiis.Entity.Store;
import com.swproject.swiis.Entity.SuggestedStores;
import com.swproject.swiis.Entity.User;
import com.swproject.swiis.Repositories.ProductInstanceRepo;
import com.swproject.swiis.Repositories.StoreRepo;
import com.swproject.swiis.Repositories.SuggestedStoresRepo;
import com.swproject.swiis.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;
    @Autowired
    ProductInstanceRepo productInstanceRepo;
    @Autowired
    StoreRepo storeRepo;
    @Autowired
    SuggestedStoresRepo suggestedStoresRepo;

    public Set<Store> getStores(Iterable<Store> storeIterable)
    {
        Set<Store> storeSet = new HashSet<Store>();
        for(Store store : storeIterable)
        {
            storeSet.add(store);
        }
        return storeSet;
    }

    public Set<SuggestedStores> getSuggestedStores(Iterable<SuggestedStores> storeIterable)
    {
        Set<SuggestedStores> storeSet = new HashSet<SuggestedStores>();
        for(SuggestedStores suggestedStores : storeIterable)
        {
            storeSet.add(suggestedStores);
        }
        return storeSet;
    }
    //-----------------------------SignUp---------------------------------
    @CrossOrigin
    @PostMapping("/SignUp")
    public boolean checkSignUp (@RequestBody User normalUser)
    {
        if(!userRepo.existsById(normalUser.getUserName()))
        {
            userRepo.save(normalUser);
            return true;
        }
        return  false;
    }
    //------------------------------Login---------------------------------
    @CrossOrigin
    @PostMapping("/Login")
    public User checkLogin(@RequestBody User user)
    {
        User tempUser;
        if(userRepo.existsById(user.getUserName()))
        {
            tempUser = userRepo.findById(user.getUserName()).get();
            if (tempUser.getUserName().equals(user.getUserName()) && tempUser.getPassWord().equals(user.getPassWord()))
            {
                Iterable<Store> iterable = storeRepo.findAll();
                Set<Store> storeSet = getStores(iterable);
                for(Store store : storeSet)
                {
                    if(tempUser.getUserName().equals(store.getStoreOwner().getUserName()))
                    {
                        tempUser.getStores().add(store);
                    }
                }

                Iterable<SuggestedStores> suggestedStoresIterable = suggestedStoresRepo.findAll();
                Set<SuggestedStores> suggestedStoresSet = getSuggestedStores(suggestedStoresIterable);
                for(SuggestedStores suggestedStores : suggestedStoresSet)
                {
                    if(tempUser.getUserName().equals(suggestedStores.getStoreOwner().getUserName()))
                    {
                        tempUser.getSuggestedStores().add(suggestedStores);
                    }
                }

                return  tempUser;
            }
        }
        return null;
    }
    //------------------------- Buy ---------------------------------------
}
