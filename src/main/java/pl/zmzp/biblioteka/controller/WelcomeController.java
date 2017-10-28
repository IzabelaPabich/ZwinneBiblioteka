package pl.zmzp.biblioteka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.zmzp.biblioteka.dao.UserRepositoryDao;
import pl.zmzp.biblioteka.dto.User;
import pl.zmzp.biblioteka.service.BibliotekaService;

import java.util.List;

/**
 * Created by lukasz on 08.10.17.
 */
@Controller
public class WelcomeController {


    @Autowired
    BibliotekaService bibliotekaService;
    
    @RequestMapping("/hello")
    public String hello( Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        final List<User> allUsers = bibliotekaService.getAllUsers();
        model.addAttribute("users", allUsers);
        model.addAttribute("name", name);
        return "welcome";
    }
}
