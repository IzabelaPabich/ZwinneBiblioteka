package pl.zmzp.biblioteka.service;

import org.springframework.security.core.GrantedAuthority;
import pl.zmzp.biblioteka.dto.Book;
import pl.zmzp.biblioteka.dto.User;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;
import pl.zmzp.biblioteka.dto.BookBorrow;

public interface BibliotekaService {

    List<User> getAllUsers();
    List<User> getUsersByPesel(String pesel);
    User getUserByNazwaUzy(String nazwa_uzy);
    boolean checkIfUserExists(String nazwa_uzy);
    void saveNewUser(User user);
    List<Book> getAllBooks();
    boolean login(String nazwa_uzy, String haslo);
    List<Book> getAvailableBooks();
    List<Book> findAvailableBookByText(String search_string);
    public List<Book> getUserBorrowedBooks(Integer user_id);
    public List<BookBorrow> getUserBorrowedBooks(User user);
    public void userBorrowBook(Integer user_id, Integer book_id);
    public void userBorrowBook(User user, Book book);
    public void userReturnBook(Integer user_id, Integer book_id);
    public void moderatorReturnBook(Integer book_id);
    void deleteBook(Integer book_id);
    //boolean checkIfBookExists(String tytul, String nazwiskoAutora);
    void saveNewBook(Book book);
    void deleteUser(Integer user_id);
    Collection<? extends GrantedAuthority> getLoggedUserRolesFormSession(HttpSession httpSession);
    public List<Book> getAllBorrowedBooks();
    
    Book getBookById(Integer id);
    BookBorrow getBookBorrowByBook(Book book);
    User getUserById(Integer id);
    
    public List<Book> getAllBookBorrows();
}
