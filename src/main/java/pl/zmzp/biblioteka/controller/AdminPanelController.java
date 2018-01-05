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
import pl.zmzp.biblioteka.dto.UserRegistrationForm;
import pl.zmzp.biblioteka.service.BibliotekaService;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        model.addAttribute("add_book","/add_book");
        model.addAttribute("delete_book","/delete_book");
        model.addAttribute("newBookForm", new NewBookForm());

        return "books_management";
    }

    @RequestMapping(value = "/delete_book", method = RequestMethod.POST)
    public String deleteBook(Model model, @RequestParam (value="id", required=true, defaultValue="0") Integer id) {
        bibliotekaService.deleteBook(id);
        return "redirect:/books_management";
    }

    @RequestMapping(value = "/add_book", method = RequestMethod.POST)
    public String addBook(@ModelAttribute(name = "newBookForm") NewBookForm newBookForm, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            return "redirect:/books_management";
        }

        final Book newBook = modelMapper.map(newBookForm, Book.class);
        java.sql.Date dateSql = new java.sql.Date(newBook.getData_wydania().getTime());
        newBook.setData_wydania(dateSql);
        System.out.println(newBook.getData_wydania());
        bibliotekaService.saveNewBook(newBook);

        return "redirect:/books_management";
    }

    @RequestMapping(value = "/users_management", method = RequestMethod.GET)
    public String usersManagement(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        final List<User> allUsers = bibliotekaService.getAllUsers();
        model.addAttribute("users", allUsers);
        model.addAttribute("add_user","/add_user");
        model.addAttribute("delete_user","/delete_user");
        model.addAttribute("userRegistrationForm", new UserRegistrationForm());

        return "users_management";
    }

    @RequestMapping(value = "/delete_user", method = RequestMethod.POST)
    public String deleteUser(Model model, @RequestParam (value="id", required=true, defaultValue="0") Integer id) {
        bibliotekaService.deleteUser(id);
        return "redirect:/users_management";
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public String addUser(@ModelAttribute(name = "userRegistrationForm")UserRegistrationForm userRegistrationForm, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            return "redirect:/users_management";
        }

        if(bibliotekaService.checkIfUserExists(userRegistrationForm.getNazwauzy())){
            model.addAttribute("userAlreadyExistsWarning", "Użytkownik o takiej nazwie już istnieje");
            return "redirect:/users_management";
        }

        final User newUser = modelMapper.map(userRegistrationForm, User.class);
        bibliotekaService.saveNewUser(newUser);

        return "redirect:/users_management";
    }
}
