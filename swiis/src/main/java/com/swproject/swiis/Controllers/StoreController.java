package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.Product;
import com.swproject.swiis.Entity.ProductInstance;
import com.swproject.swiis.Entity.Store;
import com.swproject.swiis.Repositories.ProductInstanceRepo;
import com.swproject.swiis.Repositories.ProductRepo;
import com.swproject.swiis.Repositories.StoreRepo;
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
public class StoreController {

    @Autowired
    StoreRepo storeRepo;
    ProductRepo productRepo;
    ProductInstanceRepo productInstanceRepo;

    private String hashFunction(String passwordToHash, String  salt){
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

    @PostMapping("/GetProductViews")
    public int GetViews(Model model, @ModelAttribute ProductInstance productInstance)
    {
        if(productInstanceRepo.existsById(productInstance.getID()))
        {
            productInstanceRepo.findById(productInstance.getID());
            return productInstance.getViews();
        }
        else
        {
            return "ProductError";
        }
    }

    @GetMapping("/GetProductPurchased")
    public int GetProPurchased(Model model, @ModelAttribute ProductInstance productInstance , @ModelAttribute Store store , @ModelAttribute Product product)
    {
        product.setProductName(product.getProductName().toLowerCase());
        String hash = hashFunction(product.getProductName(), store.getStoreName());
        productInstance.setID(hash);
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

    @GetMapping("/SoldOutProducts")
    public String SoldOutProducts(Model model, @ModelAttribute Product product , @ModelAttribute ProductInstance productInstance , @ModelAttribute Store store)
    {
        product.setProductName(product.getProductName().toLowerCase());
        String hash = hashFunction(product.getProductName(), store.getStoreName());
        productInstance.setID(hash);
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
