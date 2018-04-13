package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.ProductInstance;
import com.swproject.swiis.Entity.Store;
import com.swproject.swiis.Repositories.ProductInstanceRepo;
import com.swproject.swiis.Repositories.ProductRepo;
import com.swproject.swiis.Repositories.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class NormalUserController {
    /*@Autowired
    StoreRepo storeRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ProductInstanceRepo productInstanceRepo;

    private ArrayList<Store> generateList(Iterable<Store> iterable)
    {
        ArrayList<Store> storeList = new ArrayList<Store>();
        for(Store stores : iterable)
        {
            storeList.add(stores);
        }
        return storeList;
    }

    @GetMapping("/chooseStore")
    public String showStores(Model model)
    {
        Iterable<Store> stores = storeRepo.findAll();
        ArrayList<Store> StoresList = generateList(stores);
        model.addAttribute("storeslist", StoresList);
        model.addAttribute("store",new Store());
        return "chooseStore";
    }
    @PostMapping("/chooseStore")
    public String chooseStore(Model model,@ModelAttribute Store store)
    {
        if(storeRepo.existsById(store.getStoreName()))
        {
            Optional<Store> tempStore = storeRepo.findById(store.getStoreName());
            model.addAttribute("productlist" , tempStore.get().getProdcutInstance());
            return "ShowProduct";
        }
        else
            return "StoreError";
    }*/
}
