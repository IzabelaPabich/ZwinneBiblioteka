package pl.zmzp.biblioteka.service;

import pl.zmzp.biblioteka.dto.User;

import java.util.List;

public interface BibliotekaService {

    List<User> getAllUsers();
    List<User> getUsersByPesel(String pesel);
}