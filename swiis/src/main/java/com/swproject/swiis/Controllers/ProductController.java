package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.Product;
import com.swproject.swiis.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class ProductController {
    @Autowired
    ProductRepo productRepo;
    // Hash Function
    private String hashFunction(String passwordToHash, String   salt){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }
    @GetMapping("/AddProductToSystem")
    public String create(Model model, @ModelAttribute Product product) {
        model.addAttribute("product", new Product());
        return "AddProductToSystem";
    }

    @PostMapping("/AddProductToSystem")
    public String Add(Model model, @ModelAttribute Product product)
    {
        product.setProductName(product.getProductName().toLowerCase());
        String hash = hashFunction(product.getProductName(), "abc");
        product.setID(hash);
        if(!productRepo.existsById(product.getID()))
        {
            productRepo.save(product);
            return "AddProductToSystem";
        }
        else
        {
            return "ProductError";
        }
    }
}
