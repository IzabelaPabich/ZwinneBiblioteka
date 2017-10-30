package pl.zmzp.biblioteka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.zmzp.biblioteka.dao.BookRepositoryDao;
import pl.zmzp.biblioteka.dao.UserRepositoryDao;
import pl.zmzp.biblioteka.dto.Book;
import pl.zmzp.biblioteka.dto.User;
import pl.zmzp.biblioteka.service.BibliotekaService;

import java.util.List;

@Service
public class DefaultBibliotekaService implements BibliotekaService {


    @Autowired
    UserRepositoryDao userRepositoryDao;

    @Autowired
    BookRepositoryDao bookRepositoryDao;


    @Override
    public List<User> getAllUsers() {
        return userRepositoryDao.findAll();
    }

    @Override
    public List<User> getUsersByPesel(String pesel) {
        return userRepositoryDao.findUserByPesel(pesel);
    }

    @Override
    public List<User> getUserByNazwaUzy(String nazwa_uzy) {
        return userRepositoryDao.findUserByNazwaUzy(nazwa_uzy);
    }

    @Override
    public boolean checkIfUserExists(String nazwa_uzy) {
        return !getUserByNazwaUzy(nazwa_uzy).isEmpty();
    }

    @Override
    public void saveNewUser(User user) {
        userRepositoryDao.save(user);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepositoryDao.findAll();
    }


}
