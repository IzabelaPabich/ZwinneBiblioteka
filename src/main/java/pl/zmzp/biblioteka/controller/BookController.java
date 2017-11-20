package pl.zmzp.biblioteka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lukasz on 20.11.17.
 */
@Controller
public class BookController {
    
    @RequestMapping("/bookstore")
    public String bookstore(Model model) {
        return "bookstore";
    }
    
    @RequestMapping("/borrows")
    public String borrows(Model model) {
        return "borrows";
    }
}
