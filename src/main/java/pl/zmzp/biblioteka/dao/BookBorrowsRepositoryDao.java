package pl.zmzp.biblioteka.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zmzp.biblioteka.dto.Book;
import pl.zmzp.biblioteka.dto.BookBorrow;
import pl.zmzp.biblioteka.dto.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Alebazi on 2017-10-30.
 */
@Repository
public interface BookBorrowsRepositoryDao extends JpaRepository<BookBorrow, Integer> {
    BookBorrow findBookBorrowsByKsiazka( Book book);
    List<BookBorrow> findBookBorrowsByUzytkownik(User user);
    
//    @org.springframework.data.jpa.repository.Query("INSERT INTO BookBorrow AS bb (bb.uzytkownik.id_uzytkownika, bb.ksiazka.id_ksiazki)VALUES (?1, ?2)") 
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO wypozyczenia (FK_UZYTKOWNIK, FK_KSIAZKA) VALUES(?1, ?2)", nativeQuery = true)
    void userBorrowBook(Integer user_id, Integer book_id);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM wypozyczenia WHERE FK_UZYTKOWNIK = ?1 AND FK_KSIAZKA = ?2", nativeQuery = true)
    void userReturnBook(Integer user_id, Integer book_id);
}
