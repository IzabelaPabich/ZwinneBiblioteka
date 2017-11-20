package pl.zmzp.biblioteka.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zmzp.biblioteka.dto.Book;
import pl.zmzp.biblioteka.dto.BookBorrow;
import pl.zmzp.biblioteka.dto.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Alebazi on 2017-10-30.
 */

public interface BookBorrowsRepositoryDao extends JpaRepository<BookBorrow, Integer> {
    BookBorrow findBookBorrowsByKsiazka( Book book);
    List<BookBorrow> findBookBorrowsByUzytkownik(User user);
}
