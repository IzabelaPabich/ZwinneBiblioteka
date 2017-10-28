package pl.zmzp.biblioteka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zmzp.biblioteka.dao.UserRepositoryDao;
import pl.zmzp.biblioteka.dto.User;
import pl.zmzp.biblioteka.service.BibliotekaService;

import java.util.List;

@Service
public class DefaultBibliotekaService implements BibliotekaService{


    @Autowired
    UserRepositoryDao userRepositoryDao;


    @Override
    public List<User> getAllUsers() {
        return userRepositoryDao.findAll();
    }

    @Override
    public List<User> getUsersByPesel(String pesel) {
        return userRepositoryDao.findUserByPesel(pesel);
    }
}
