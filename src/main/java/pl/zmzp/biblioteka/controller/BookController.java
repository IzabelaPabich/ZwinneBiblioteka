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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.zmzp.biblioteka.dto.BookBorrow;

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
      
        return "bookstoreModerator";
    }
    
    @RequestMapping("/my_bookstore")
    public String user_bookstore( Model model, @RequestParam (value="search_text", required = false, defaultValue = "") String search_text) {
        
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
        model.addAttribute("action","/my_bookstore");
      
        return "bookstoreUser";
    }
    
    @RequestMapping("/my_borrows")
    public String user_borrows(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //final List<Book > borrowedBooks = bibliotekaService.getUserBorrowedBooks(bibliotekaService.getUserByNazwaUzy(auth.getName()).getId_uzytkownika());
        final List<BookBorrow> borrowedBooks = bibliotekaService.getUserBorrowedBooks(bibliotekaService.getUserByNazwaUzy(auth.getName()));
        model.addAttribute("books", borrowedBooks);
        model.addAttribute("action","/my_borrows");
        
        return "my_borrows";
    }
    
    @RequestMapping("/borrows")
    public String borrows(Model model) {
        //final List<Book > borrowedBooks = bibliotekaService.getAllBorrowedBooks();
        final List<Book> books = bibliotekaService.getAllBookBorrows();
        model.addAttribute("books", books);
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
        bibliotekaService.moderatorReturnBook(id);
        return "redirect:/borrows";
    }
    
    @RequestMapping("/book/{id}")
    public String bookdetails(@PathVariable("id") Integer id, Model model) {
        Book book = bibliotekaService.getBookById(id);
        BookBorrow bb = bibliotekaService.getBookBorrowByBook(book);
        if(bb != null)
            book.setDostepna(false);
        else
            book.setDostepna(true);
        
        List<User> users = bibliotekaService.getAllUsers();
        model.addAttribute("book", book);
        model.addAttribute("bookBorrow", bb);
        model.addAttribute("users", users);
        model.addAttribute("action_user", "/book/"+id.toString());
        return "bookDetails";
    }
    
    @RequestMapping(value = "/book/{id}", method = RequestMethod.POST)
    public String bookdetailsborrow(@PathVariable("id") Integer id, Model model, @RequestParam (value="user", required = false, defaultValue = "") Integer user) {
        Book book = bibliotekaService.getBookById(id);
        User reader = bibliotekaService.getUserById(user);
        if(book != null && reader != null)
        {
            bibliotekaService.userBorrowBook(reader, book);
        }
        return "redirect:/book/"+id.toString();
    }
}
