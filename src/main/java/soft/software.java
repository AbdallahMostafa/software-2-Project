package soft;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class software {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    
    @RequestMapping("/about")
    @ResponseBody
    
    String about() {
        return "abdo World!";
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(software.class, args);
    }
}