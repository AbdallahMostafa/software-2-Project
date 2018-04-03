package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.Store;
import com.swproject.swiis.Repositories.ProductInstanceRepo;
import com.swproject.swiis.Repositories.ProductRepo;
import com.swproject.swiis.Repositories.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

public class ProductInstanceController {
/*
    @Autowired
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

    @GetMapping("/showProduct")
    public String showProducts(Model model)
    {
        Iterable<Store> stores = storeRepo.findAll();
        ArrayList<Store> StoresList = generateList(stores);
        model.addAttribute("storeslist", StoresList);
        model.addAttribute("store",new Store());
        return "chooseStore";
    }
*/

}
