package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.Brand;
import com.swproject.swiis.Entity.SuggestedStores;
import com.swproject.swiis.Repositories.BrandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class BrandController {
    @Autowired
    BrandRepo brandRepo;

    public Set<Brand> generateList(Iterable<Brand> iterable)
    {
        Set<Brand> brandSet = new HashSet<Brand>();
        for(Brand brand : iterable)
        {
            brandSet.add(brand);
        }
        return brandSet;
    }
    /*@GetMapping("/AddBrandToSystem")
    public String create(Model model, @ModelAttribute Brand brand) {
        model.addAttribute("brand", new Brand());
        return "AddBrandToSystem";
    }*/

    @CrossOrigin
    @GetMapping("/showBrands")
    public Set<Brand> show()
    {
        Iterable<Brand> brands = brandRepo.findAll();
        Set<Brand> brandSet = generateList(brands);
        return brandSet;
    }
    /*
    @CrossOrigin
    @PostMapping("/AddBrandToSystem")
    public String Add(Model model, @ModelAttribute Brand brand)
    {

        if(!brandRepo.existsById(brand.getName()))
        {
            brandRepo.save(brand);
            return "AddProductToSystem";
        }
        else
        {
            return "ProductError";
        }
    }*/
}
