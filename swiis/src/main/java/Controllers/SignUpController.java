package Controllers;

import Entity.NormalUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignUpController {
    @RequestMapping("/singup")
    String getUrl (@ModelAttribute NormalUser normal)
    {
        return "SignUp";
    }

}
