package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.Brand;
import com.swproject.swiis.Repositories.BrandRepo;
import com.swproject.swiis.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class StoreOwnerController {
    @Autowired
    BrandRepo brandRepo;

    @Autowired
    ProductRepo productRepo;

    @GetMapping("/AssignProductToStore")
    public  String create (Model model){
        model.addAttribute("brands", new ArrayList<Brand>());
        Iterable<Brand> brands = brandRepo.findAll();
        return "AssignProductToStore";
    }
}
