package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.Admin;
import com.swproject.swiis.Repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @Autowired
    AdminRepo adminRepo;
    @GetMapping("/AdminLogin")
    public String url(Model model, @ModelAttribute Admin admin)
    {
        model.addAttribute("admin",new Admin());
        return "AdminLogin";
    }
    @PostMapping("/AdminLogin")
    public String get (Model model,@ModelAttribute Admin admin)
    {
        System.out.print(adminRepo.existsById(admin.getUserName()));
        if(adminRepo.existsById(admin.getUserName()))
        {

            return "Welcome";
        }
        else
        {
            return "ErrorLogin";
        }
    }
}
