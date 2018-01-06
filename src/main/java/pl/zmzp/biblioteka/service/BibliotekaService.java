package pl.zmzp.biblioteka.service;

import org.springframework.security.core.GrantedAuthority;
import pl.zmzp.biblioteka.dto.Book;
import pl.zmzp.biblioteka.dto.User;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

public interface BibliotekaService {

    List<User> getAllUsers();
    List<User> getUsersByPesel(String pesel);
    User getUserByNazwaUzy(String nazwa_uzy);
    boolean checkIfUserExists(String nazwa_uzy);
    void saveNewUser(User user);
    List<Book> getAllBooks();
    boolean login(String nazwa_uzy, String haslo);
    List<Book> getAvailableBooks();
    public List<Book> getUserBorrowedBooks(Integer user_id);
    public void userBorrowBook(Integer user_id, Integer book_id);
    public void userReturnBook(Integer user_id, Integer book_id);
    void deleteBook(Integer book_id);
    //boolean checkIfBookExists(String tytul, String nazwiskoAutora);
    void saveNewBook(Book book);
    Collection<? extends GrantedAuthority> getLoggedUserRolesFormSession(HttpSession httpSession);
}
