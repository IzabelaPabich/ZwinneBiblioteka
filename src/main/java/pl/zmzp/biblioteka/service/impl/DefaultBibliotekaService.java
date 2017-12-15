package pl.zmzp.biblioteka.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.zmzp.biblioteka.dao.BookRepositoryDao;
import pl.zmzp.biblioteka.dao.UserRepositoryDao;
import pl.zmzp.biblioteka.dto.Book;
import pl.zmzp.biblioteka.dto.User;
import pl.zmzp.biblioteka.service.BibliotekaService;

import java.util.List;
import java.util.Optional;
import pl.zmzp.biblioteka.dao.BookBorrowsRepositoryDao;

@Service
public class DefaultBibliotekaService implements BibliotekaService {


    @Autowired
    UserRepositoryDao userRepositoryDao;

    @Autowired
    BookRepositoryDao bookRepositoryDao;

    @Autowired
    BookBorrowsRepositoryDao bookBorrowsRepositoryDao;

    @Override
    public List<User> getAllUsers() {
        return userRepositoryDao.findAll();
    }

    @Override
    public List<User> getUsersByPesel(String pesel) {
        return userRepositoryDao.findUserByPesel(pesel);
    }

    @Override
    public User getUserByNazwaUzy(String nazwa_uzy) {
        return userRepositoryDao.findUserByNazwaUzy(nazwa_uzy);
    }

    @Override
    public boolean checkIfUserExists(String nazwa_uzy) {
        return getUserByNazwaUzy(nazwa_uzy) != null;
    }

    @Override
    public void saveNewUser(User user) {
        userRepositoryDao.save(user);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepositoryDao.findAll();
    }

    @Override
    public boolean login(String nazwa_uzy, String haslo) {
        final User userByNazwaUzy = userRepositoryDao.findUserByNazwaUzy(nazwa_uzy);
        if(userByNazwaUzy != null && StringUtils.equals(haslo, userByNazwaUzy.getHaslo())){
            return true;
        }
        return false;
    }

    @Override
    public List<Book> getAvailableBooks() {
        return bookRepositoryDao.findAvailableBooks();
    }
    
    @Override
    public List<Book> getUserBorrowedBooks(Integer user_id) {
        return bookRepositoryDao.findUserBorrowedBooks(user_id);
    }
    
    @Override
    public void userBorrowBook(Integer user_id, Integer book_id) {
        bookBorrowsRepositoryDao.userBorrowBook(user_id, book_id);
    }
    
    @Override
    public void userReturnBook(Integer user_id, Integer book_id) {
        bookBorrowsRepositoryDao.userReturnBook(user_id, book_id);
    }

    @Override
    public List<Book> findAvailableBookByText(String search_string) {
        return bookRepositoryDao.findAvailableBooksByText(search_string);
    }
    


}
