package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.NormalUser;
import com.swproject.swiis.Entity.StoreOwner;
import com.swproject.swiis.Repositories.NormalUserRepo;
import com.swproject.swiis.Repositories.StoreOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    StoreOwnerRepo storeOwnerRepo;

    @Autowired
    NormalUserRepo normalUserRepo;

    @GetMapping("/SignUp")
    public String url(Model model,@ModelAttribute NormalUser normalUser)
    {
        model.addAttribute("normalUser",new NormalUser());
        return "SignUp";
    }
    @PostMapping("/SignUp")
    public String get (Model model,@ModelAttribute NormalUser normalUser)
    {
        if(!normalUserRepo.existsById(normalUser.getUserName()) || !storeOwnerRepo.existsById(normalUser.getUserName()))
        {
           if(normalUser.getType().equals("0"))
           {
               normalUserRepo.save(normalUser);
           }
           else
           {
               StoreOwner storeOwner;
               storeOwner = new StoreOwner(normalUser.getName() , normalUser.getName(),normalUser.getPassWord(),normalUser.getEmail(),normalUser.getType());
               storeOwnerRepo.save(storeOwner);
           }
           return "SignUp";
        }else
        {
            return "ErrorLogin";
        }
    }

}
