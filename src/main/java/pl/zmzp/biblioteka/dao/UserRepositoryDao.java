package pl.zmzp.biblioteka.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.zmzp.biblioteka.dto.BookBorrow;
import pl.zmzp.biblioteka.dto.Roles;
import pl.zmzp.biblioteka.dto.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepositoryDao extends JpaRepository<User,Integer>{
    List<User> findUserByPesel(String pesel);
    User findUserByNazwaUzy(String nazwa_uzy);
    User findUserByRoles(Roles roles);
    User findUserByBookBorrows(BookBorrow bookBorrow);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM uzytkownica WHERE id_uzytkowika = ?1", nativeQuery = true)
    void deleteUser(Integer user_id);
}
