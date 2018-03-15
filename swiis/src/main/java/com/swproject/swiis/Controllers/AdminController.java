package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.Admin;
import com.swproject.swiis.Entity.Store;
import com.swproject.swiis.Entity.SuggestedStores;
import com.swproject.swiis.Repositories.AdminRepo;
import com.swproject.swiis.Repositories.StoreRepo;
import com.swproject.swiis.Repositories.SuggestedStoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AdminRepo adminRepo;

    @Autowired
    SuggestedStoresRepo suggestedStoresRepo;

    @Autowired
    StoreRepo storeRepo;

    private List<SuggestedStores> generateList(Iterable<SuggestedStores> iterable)
    {
        List<SuggestedStores> brandList = new ArrayList<SuggestedStores>();
        for(SuggestedStores suggestedStores : iterable)
        {
            brandList.add(suggestedStores);
        }
        return brandList;
    }

    //-----------------------Login---------------------------
    @GetMapping("/AdminLogin")
    public String url(Model model, @ModelAttribute Admin admin)
    {
        model.addAttribute("admin",new Admin());
        return "AdminLogin";
    }
    @PostMapping("/AdminLogin")
    public String get (Model model,@ModelAttribute Admin admin)
    {
        if(adminRepo.existsById(admin.getUserName()))
        {

            return "Welcome";
        }
        else
        {
            return "ErrorLogin";
        }
    }
    //-------------------------Verify------------------------
    @GetMapping("/AcceptStore")
    public String showStores(Model model)
    {
        Iterable<SuggestedStores> suggestedStores =suggestedStoresRepo.findAll();
        List<SuggestedStores> suggestedStoresList = generateList(suggestedStores);
        model.addAttribute("stores", suggestedStoresList);
        return "AcceptStore";
    }
    @PostMapping("/AcceptStore")
    public String AddStore(Model model,@ModelAttribute SuggestedStores suggestedStores)
    {
           if(suggestedStoresRepo.existsById("7amda"))
           {
               Store store = new Store(suggestedStores.getStoreLocation(),suggestedStores.getStoreName(),suggestedStores.getType(),suggestedStores.getStoreOwner());
               storeRepo.save(store);
               suggestedStoresRepo.delete(suggestedStores);
               return "AcceptStore";
           }
           else
               return "ErrorLogin";
    }
}
