package pl.zmzp.biblioteka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.zmzp.biblioteka.dto.Book;
import pl.zmzp.biblioteka.dto.User;
import pl.zmzp.biblioteka.service.BibliotekaService;

import java.util.List;

/**
 * Created by Alebazi on 2017-12-15.
 */
public class AdminPanelController {


    @Autowired
    BibliotekaService bibliotekaService;

    @RequestMapping(value = "books_management", method = RequestMethod.GET)
    public String booksManagement(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        final List<Book > allBooks = bibliotekaService.getAllBooks();
        model.addAttribute("books", allBooks);
        model.addAttribute("new_book","/new_book");
        model.addAttribute("delete_book","/delete_book");

        return "books_management";
    }

    @RequestMapping(value = "/delete_book", method = RequestMethod.POST)
    public String borrow(Model model, @RequestParam (value="id", required=true, defaultValue="0") Integer id) {
        bibliotekaService.deleteBook(id);
        return "redirect:/books_management";
    }

}
