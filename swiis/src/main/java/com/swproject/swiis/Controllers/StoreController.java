package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.Store;
import com.swproject.swiis.Repositories.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StoreController {

    @Autowired
    StoreRepo storeRepo;
    @GetMapping("/AddStoreToSystem")
    public String create(Model model, @ModelAttribute Store store) {
        model.addAttribute("store", new Store());
        return "AddStoreToSystem";
    }

    @PostMapping("/AddStoreToSystem")
    public String Add(Model model, @ModelAttribute Store store)
    {
        store.setStoreName(store.getStoreName().toLowerCase());
        if(!storeRepo.existsById(store.getStoreName()))
        {
            storeRepo.save(store);
            return "AddStoreToSystem";
        }
        else
        {
            return "StoreError";
        }
    }
/*
    @GetMapping("/StoreProducts")
    public String showget(Model model, @ModelAttribute Store store) {
        model.addAttribute("store", new Store());
        return "StoreProducts";
    }

    @PostMapping("/StoreProducts")
    public String showpost(Model model, @ModelAttribute Store store)
    {
        store.setStoreName(store.getStoreName().toLowerCase());
        if(!storeRepo.existsById(store.getStoreName()))
        {
            storeRepo.save(store);
            return "AddStoreToSystem";
        }
        else
        {
            return "StoreError";
        }
    }
*/

}
