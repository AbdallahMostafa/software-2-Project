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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    StoreOwnerRepo storeOwnerRepo;

    @Autowired
    NormalUserRepo normalUserRepo;

    @RequestMapping("/HomePage")
    public String log() {
        return "HomePage";
    }
    //-----------------------------SignUp---------------------------------
    @GetMapping("/SignUp")
    public String singUp(Model model,@ModelAttribute NormalUser normalUser)
    {
        model.addAttribute("normalUser",new NormalUser());
        return "SignUp";
    }
    @PostMapping("/SignUp")
    public String checkSignUp (Model model,@ModelAttribute NormalUser normalUser)
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
           return "Login";
        }else
        {
            return "ErrorLogin";
        }
    }
    //------------------------------Login---------------------------------
    @GetMapping("/Login")
    public String login(Model model, @ModelAttribute NormalUser normalUser)
    {
        model.addAttribute("normal",new NormalUser());
        return "Login";
    }
    @PostMapping("/Login")
    public String checkLogin(Model model, @ModelAttribute NormalUser normalUser, HttpServletRequest session)
    {
        if(normalUserRepo.existsById(normalUser.getUserName()))
        {
            NormalUser tempUser = normalUserRepo.findById(normalUser.getUserName()).get();
            if(tempUser.getUserName().equals(normalUser.getUserName()) && tempUser.getPassWord().equals(normalUser.getPassWord()))
            {
                session.getSession().setAttribute("customer", tempUser);
                NormalUser temp = (NormalUser) session.getSession().getAttribute("customer");
                //System.out.println((NormalUser)session.getSession().getAttribute("customer"));
                return "Welcome";
            }
            else
            {
                return "ErrorLogin";
            }
        }
        //System.out.println(storeOwnerRepo.existsById(normalUser.getUserName()));
        else if(storeOwnerRepo.existsById(normalUser.getUserName()))
        {
            StoreOwner tempStoreOwner = storeOwnerRepo.findById(normalUser.getUserName()).get();
            System.out.println(tempStoreOwner.getUserName() + " " + tempStoreOwner.getPassWord() + " " + normalUser.getUserName() + " "+ normalUser.getPassWord());
            if(tempStoreOwner.getUserName().equals(normalUser.getUserName()) && tempStoreOwner.getPassWord().equals(normalUser.getPassWord())) {
                session.getSession().setAttribute("storeOwner", tempStoreOwner);
                return "WelcomeOwner";
            }
        }
        return "ErrorLogin";
    }
}
