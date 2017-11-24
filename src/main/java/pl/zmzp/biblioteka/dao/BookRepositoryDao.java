package pl.zmzp.biblioteka.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zmzp.biblioteka.dto.Book;

import java.util.List;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Alebazi on 2017-10-30.
 */
@Repository
public interface BookRepositoryDao extends JpaRepository<Book, Integer > {

    @Query("SELECT new pl.zmzp.biblioteka.dto.Book(k.id_ksiazki, k.nazwa_ksiazki) FROM Book AS k where k.id_ksiazki NOT IN(SELECT DISTINCT w.ksiazka FROM BookBorrow AS w)") 
    List<Book> findAvailableBooks();
    
    @Query("SELECT new pl.zmzp.biblioteka.dto.Book(k.id_ksiazki, k.nazwa_ksiazki) FROM Book AS k where k.id_ksiazki IN(SELECT DISTINCT w.ksiazka FROM BookBorrow AS w where w.uzytkownik.id_uzytkownika = ?1)") 
    List<Book> findUserBorrowedBooks(Integer id);
}
