package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.NormalUser;
import com.swproject.swiis.Repositories.NormalUserRepo;
import com.swproject.swiis.Repositories.StoreOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    StoreOwnerRepo storeOwnerRepo;

    @Autowired
    NormalUserRepo normalUserRepo;

    @GetMapping("/Login")
    public String url(Model model, @ModelAttribute NormalUser normalUser)
    {
        model.addAttribute("normal",new NormalUser());
        return "Login";
    }
    @PostMapping("/Login")
    public String get (Model model,@ModelAttribute NormalUser normalUser)
    {
        if(normalUserRepo.existsById(normalUser.getUserName()))
        {
            return "Welcome";
        }
        if(storeOwnerRepo.existsById(normalUser.getUserName()))
        {
            return "Welcome";
        }else
        {
            return "ErrorLogin";
        }
    }
}
