package pl.zmzp.biblioteka.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import pl.zmzp.biblioteka.dto.Book;

import java.sql.Date;
import java.util.List;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Alebazi on 2017-10-30.
 */
@Repository
public interface BookRepositoryDao extends JpaRepository<Book, Integer > {

    //@Query("SELECT new pl.zmzp.biblioteka.dto.Book(k.id_ksiazki, k.nazwa_ksiazki, k.imiona_autora, k.nazwisko_autora, k.kategoria, k.data_wydania) FROM Book AS k LEFT JOIN k.wypozyczenie")
    @Query("SELECT new pl.zmzp.biblioteka.dto.Book(k.id_ksiazki, k.nazwa_ksiazki, k.imiona_autora, k.nazwisko_autora, k.kategoria, k.data_wydania, bb.uzytkownik.id_uzytkownika) FROM BookBorrow AS bb RIGHT JOIN bb.ksiazka k ORDER BY k.nazwa_ksiazki ASC")
    List<Book> findAvailableBooks();
    
    @Query("SELECT new pl.zmzp.biblioteka.dto.Book(k.id_ksiazki, k.nazwa_ksiazki) FROM Book AS k where k.id_ksiazki IN(SELECT DISTINCT w.ksiazka FROM BookBorrow AS w where w.uzytkownik.id_uzytkownika = ?1)") 
    List<Book> findUserBorrowedBooks(Integer id);
    
    //@Query("SELECT new pl.zmzp.biblioteka.dto.Book(k.id_ksiazki, k.nazwa_ksiazki, k.imiona_autora, k.nazwisko_autora, k.kategoria, k.data_wydania, 0) FROM Book AS k where k.id_ksiazki NOT IN(SELECT DISTINCT w.ksiazka FROM BookBorrow AS w) AND k.nazwa_ksiazki LIKE %?1%")// OR (k.nazwisko_auto LIKE %?1%) ) OR (k.imiona_auto LIKE %?1%))") 
    @Query("SELECT new pl.zmzp.biblioteka.dto.Book(k.id_ksiazki, k.nazwa_ksiazki, k.imiona_autora, k.nazwisko_autora, k.kategoria, k.data_wydania, bb.uzytkownik.id_uzytkownika) FROM BookBorrow AS bb RIGHT JOIN bb.ksiazka k where k.nazwa_ksiazki LIKE %?1% ORDER BY k.nazwa_ksiazki ASC")
    List<Book> findAvailableBooksByText(String search_string);

    //@Query("SELECT new pl.zmzp.biblioteka.dto.Book(k.id_ksiazki, k.nazwa_ksiazki, k.imiona_autora, k.nazwisko_autora, k.data_wydania, k.kategoria) FROM Book AS k")
    List<Book> findAll();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ksiazki WHERE id_ksiazki = ?1", nativeQuery = true)
    void deleteBook(Integer book_id);

    //@Query("SELECT new pl.zmzp.biblioteka.dto.Book(k.nazwa_ksiazki, k.nazwisko_autora) FROM Book AS k WHERE k.id_ksiazki = ?1 AND k.nazwisko_autora = ?2")
    //List<Book> findBook(String tytul, String nazwiskoAutora);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ksiazki (id_ksiazki, nazwa_ksiazki, imiona_autora, nazwisko_autora, data_wydania, kategoria) " +
            "VALUES(?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void saveBook(String nazwa_ksiazki, String imiona_autora, String nazwisko_autora, Date data_wydania, String kategoria);
    
    @Query("SELECT new pl.zmzp.biblioteka.dto.Book(k.id_ksiazki, k.nazwa_ksiazki) FROM Book AS k where k.id_ksiazki IN(SELECT DISTINCT w.ksiazka FROM BookBorrow AS w)") 
    List<Book> findAllBorrowedBooks();
}
