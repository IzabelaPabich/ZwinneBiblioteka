package pl.zmzp.biblioteka.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.zmzp.biblioteka.dto.Book;
import pl.zmzp.biblioteka.dto.NewBookForm;
import pl.zmzp.biblioteka.dto.User;
import pl.zmzp.biblioteka.service.BibliotekaService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Alebazi on 2017-12-15.
 */
@Controller
public class AdminPanelController {


    @Autowired
    BibliotekaService bibliotekaService;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "/books_management", method = RequestMethod.GET)
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

    @RequestMapping(value = "/add_book", method = RequestMethod.POST)
    public String registration(@ModelAttribute(name = "newBookForm") @Valid NewBookForm newBookForm, BindingResult bindingResult, Model model) {
//        if(bibliotekaService.checkIfBookExists(newBookForm.getTytul(), newBookForm.getNazwiskoAutora())) {
//            model.addAttribute("bookAlreadyExists", "Książka tego autora o takim tytule już istnieje");
//        } else {
            final Book newBook = modelMapper.map(newBookForm, Book.class);
            bibliotekaService.saveNewBook(newBook);
//        }

        return "redirect:/books_management";
    }

}
