package com.swproject.swiis.Controllers;

import ch.qos.logback.classic.turbo.TurboFilter;
import com.swproject.swiis.Entity.NormalUser;
import com.swproject.swiis.Entity.StoreOwner;
import com.swproject.swiis.Repositories.NormalUserRepo;
import com.swproject.swiis.Repositories.StoreOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    StoreOwnerRepo storeOwnerRepo;

    @Autowired
    NormalUserRepo normalUserRepo;

    /*@RequestMapping("/HomePage")
    public String log() {
        return "HomePage";
    }*/
    //-----------------------------SignUp---------------------------------
    /*@GetMapping("/SignUp")
    public String singUp(Model model,@ModelAttribute NormalUser normalUser)
    {
        model.addAttribute("normalUser",new NormalUser());
        return "SignUp";
    }*/
    @CrossOrigin
    @PostMapping("/SignUp")
    public boolean checkSignUp (@RequestBody NormalUser normalUser)
    {
        if(!normalUserRepo.existsById(normalUser.getUserName()) || !storeOwnerRepo.existsById(normalUser.getUserName()))
        {
           if(normalUser.getType().equals("0"))
           {
               normalUserRepo.save(normalUser);
               return true;
           }
           else
           {
               //StoreOwner storeOwner;
               //storeOwner = new StoreOwner(normalUser.getName() , normalUser.getUserName(),normalUser.getPassWord(),normalUser.getEmail(),normalUser.getType());
               storeOwnerRepo.save(normalUser);
               return true;
           }
        }else
        {
            return false;
        }
    }
    //------------------------------Login---------------------------------
    /*@GetMapping("/Login")
    public String login(Model model, @ModelAttribute NormalUser normalUser)
    {
        model.addAttribute("normal",new NormalUser());
        return "Login";
    }*/
    @CrossOrigin
    @PostMapping("/Login")
    public boolean checkLogin(String userName, String password, HttpServletRequest session)
    {
        boolean normalUser = false;
        boolean storeOwner = false;
        NormalUser tempUser;
        if(normalUserRepo.existsById(userName)) {
            tempUser = normalUserRepo.findById(userName).get();
            if (tempUser.getUserName().equals(userName) && tempUser.getPassWord().equals(password)) {
                //session.getSession().setAttribute("customer", tempUser);
                NormalUser temp = (NormalUser) session.getSession().getAttribute("customer");
                normalUser = true;
                return  normalUser;
            } else {
                return false;
            }
        }
        else if(storeOwnerRepo.existsById(userName))
        {
            tempUser = storeOwnerRepo.findById(userName).get();
            if(tempUser.getUserName().equals(userName) && tempUser.getPassWord().equals(password)) {
                session.getSession().setAttribute("storeOwner", tempUser);
                //System.out.println((StoreOwner) session.getSession().getAttribute("storeOwner"));
                storeOwner = true;
                return storeOwner;
            }
        }
        return false;
    }
}
