package pl.zmzp.biblioteka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lukasz on 08.10.17.
 */
@Controller
public class WelcomeController {
    
    @RequestMapping("/hello")
    public String hello( Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "welcome";
    }
}
