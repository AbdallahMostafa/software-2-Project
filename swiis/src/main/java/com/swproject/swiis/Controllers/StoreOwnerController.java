package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.Brand;
import com.swproject.swiis.Repositories.BrandRepo;
import com.swproject.swiis.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StoreOwnerController {
    @Autowired
    BrandRepo brandRepo;

    @Autowired
    ProductRepo productRepo;
    private List<Brand> generateList(Iterable<Brand> iterable)
    {
        List<Brand> brandList = new ArrayList<Brand>();
        for(Brand brand : iterable)
        {
            brandList.add(brand);
        }
        return brandList;
    }
    @GetMapping("/AssignProductToStore")
    public  String create (Model model)
    {
        Iterable<Brand> brandIterable = brandRepo.findAll();
        List<Brand> brandList = generateList(brandIterable);
        model.addAttribute("brand", brandList);
        return "AssignProductToStore";
    }
    @PostMapping("/AssignProductToStore")
    public  String show(Model model , @ModelAttribute Brand brand)
    {
        return "AssignProductToStore";
    }
}
