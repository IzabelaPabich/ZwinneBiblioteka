package pl.zmzp.biblioteka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.zmzp.biblioteka.dto.Book;
import pl.zmzp.biblioteka.dto.User;
import pl.zmzp.biblioteka.service.BibliotekaService;

import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lukasz on 20.11.17.
 */
@Controller
public class BookController {
    
    
    
    @Autowired
    BibliotekaService bibliotekaService;
    
    @RequestMapping("/bookstore")
    public String bookstore( Model model, @RequestParam (value="search_text", required = false, defaultValue = "") String search_text) {
        
        //final List<Book > allBooks = bibliotekaService.getAllBooks();
        if(search_text.length() == 0)
        {
            final List<Book > availableBooks = bibliotekaService.getAvailableBooks();
            model.addAttribute("books", availableBooks);
        }
        else
        {
            final List<Book > foundBooks = bibliotekaService.findAvailableBookByText(search_text);
            //final List<Book > foundBooks = bibliotekaService.getAvailableBooks();
            model.addAttribute("books", foundBooks);
        }
        model.addAttribute("action","/bookstore");
      
        return "bookstore";
    }
    
    @RequestMapping("/my_borrows")
    public String user_borrows(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final List<Book > borrowedBooks = bibliotekaService.getUserBorrowedBooks(bibliotekaService.getUserByNazwaUzy(auth.getName()).getId_uzytkownika());
        model.addAttribute("books", borrowedBooks);
        model.addAttribute("action","/my_borrows");
        
        return "my_borrows";
    }
    
    @RequestMapping("/borrows")
    public String borrows(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final List<Book > borrowedBooks = bibliotekaService.getUserBorrowedBooks(bibliotekaService.getUserByNazwaUzy(auth.getName()).getId_uzytkownika());
        model.addAttribute("books", borrowedBooks);
        model.addAttribute("action","/return_book");
        
        return "borrows";
    }
    
    @RequestMapping(value = "/borrow_book", method = RequestMethod.POST)
    public String borrow(Model model, @RequestParam (value="id", required=true, defaultValue="0") Integer id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        bibliotekaService.userBorrowBook(bibliotekaService.getUserByNazwaUzy(auth.getName()).getId_uzytkownika(), id);
        return "redirect:/bookstore";
    }
    
    @RequestMapping(value = "/return_book", method = RequestMethod.POST)
    public String returnbook(Model model, @RequestParam (value="id", required=true, defaultValue="0") Integer id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        bibliotekaService.userReturnBook(bibliotekaService.getUserByNazwaUzy(auth.getName()).getId_uzytkownika(), id);
        return "redirect:/borrows";
    }
}
