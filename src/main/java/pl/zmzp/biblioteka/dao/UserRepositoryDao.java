package pl.zmzp.biblioteka.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zmzp.biblioteka.dto.BookBorrow;
import pl.zmzp.biblioteka.dto.Roles;
import pl.zmzp.biblioteka.dto.User;

import java.util.List;

@Repository
public interface UserRepositoryDao extends JpaRepository<User,Integer>{
    List<User> findUserByPesel(String pesel);
    User findUserByNazwaUzy(String nazwa_uzy);
    User findUserByRoles(Roles roles);
    User findUserByBookBorrows(BookBorrow bookBorrow);
}
