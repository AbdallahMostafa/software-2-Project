package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.Product;
import com.swproject.swiis.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
public class ProductController {
    @Autowired
    ProductRepo productRepo;

    /*@GetMapping("/AddProductToSystem")
    public String create(Model model, @ModelAttribute Product product) {
        model.addAttribute("product", new Product());
        return "AddProductToSystem";
    }*/
    @CrossOrigin
    @PostMapping("/AddProductToSystem")
    public boolean Add(@RequestBody Product product)
    {
        product.setProductName(product.getProductName().toLowerCase());
        if(!productRepo.existsById(product.getProductName()))
        {
            if(product.getProductType().equals("0")) {
                System.out.println(product.getBrand().getBrandName());
                productRepo.save(product);
                return true;
            }
            else {
                productRepo.save(product);
            }
        }
        return false;

    }
}
