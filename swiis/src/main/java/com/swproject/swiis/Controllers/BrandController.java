package com.swproject.swiis.Controllers;

import com.swproject.swiis.Entity.Brand;
import com.swproject.swiis.Repositories.BrandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BrandController {
    @Autowired
    BrandRepo brandRepo;
    @GetMapping("/AddBrandToSystem")
    public String create(Model model, @ModelAttribute Brand brand) {
        model.addAttribute("brand", new Brand());
        return "AddBrandToSystem";
    }

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
    }
}
