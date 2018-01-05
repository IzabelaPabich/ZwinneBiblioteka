package pl.zmzp.biblioteka.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zmzp.biblioteka.dao.BookRepositoryDao;
import pl.zmzp.biblioteka.dao.UserRepositoryDao;
import pl.zmzp.biblioteka.dto.Book;
import pl.zmzp.biblioteka.dto.MenuItem;
import pl.zmzp.biblioteka.dto.User;
import pl.zmzp.biblioteka.service.BibliotekaService;

import java.util.*;

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
    
    public void userReturnBook(Integer user_id, Integer book_id) {
        bookBorrowsRepositoryDao.userReturnBook(user_id, book_id);
    }

    @Override
    public void deleteBook(Integer book_id) {
        bookRepositoryDao.deleteBook(book_id);
    }

    @Override
    public void saveNewBook(Book book) {
        bookRepositoryDao.save(book);
//        bookRepositoryDao.saveBook(book.getNazwa_ksiazki(), book.getImiona_autora(), book.getNazwisko_autora(), new java.sql.Date(book.getData_wydania().getTime()), book.getKategoria());
    }

    @Override
    public void deleteUser(Integer user_id) {
        userRepositoryDao.deleteUser(user_id);
    }

    @Override
    public List<MenuItem> getMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("mainpage", "Strona główna"));
        menuItems.add(new MenuItem("bookstore", "Katalog książek"));
        menuItems.add(new MenuItem("borrows", "Moje wypożyczenia"));
//        List<MenuItem> menuItems = findMenuItemsByRoles("");
        return menuItems;
    }
}
