package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.ProductInstance;
import com.swproject.swiis.Entity.User;
import com.swproject.swiis.Repositories.ProductInstanceRepo;
import com.swproject.swiis.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;
    @Autowired
    ProductInstanceRepo productInstanceRepo;

    //-----------------------------SignUp---------------------------------
    @CrossOrigin
    @PostMapping("/SignUp")
    public boolean checkSignUp (@RequestBody User normalUser)
    {
        if(!userRepo.existsById(normalUser.getUserName()))
        {
            userRepo.save(normalUser);
            return true;
        }
        return  false;
    }
    //------------------------------Login---------------------------------
    @CrossOrigin
    @PostMapping("/Login")
    public User checkLogin(@RequestBody User user)
    {
        User tempUser;
        if(userRepo.existsById(user.getUserName())) {
            tempUser = userRepo.findById(user.getUserName()).get();
            if (tempUser.getUserName().equals(user.getUserName()) && tempUser.getPassWord().equals(user.getPassWord())) {
                return  tempUser;
            } else {
                return null;
            }
        }
        return null;
    }
    //------------------------- Buy ---------------------------------------
    /*@CrossOrigin
    @PostMapping("/buy")
    public lll buyProduct(@RequestBody ProductInstance productInstance , int Quantity){
        if(Quantity <= productInstance.getQuantity()){
            ProductInstance toCart = productInstance;
            toCart.setQuantity(Quantity);

        }
    }*/
}
