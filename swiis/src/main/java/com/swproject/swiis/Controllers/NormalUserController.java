package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.Store;
import com.swproject.swiis.Entity.SuggestedStores;
import com.swproject.swiis.Repositories.ProductRepo;
import com.swproject.swiis.Repositories.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class NormalUserController {

    @Autowired
    StoreRepo storeRepo;

    @Autowired
    ProductRepo productRepo;

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


            return "BuyProduct";
        }
        else
            return "StoreError";
    }

}
