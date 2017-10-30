package pl.zmzp.biblioteka.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zmzp.biblioteka.dto.BookBorrow;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alebazi on 2017-10-30.
 */

public interface BookBorrowsRepositoryDao extends JpaRepository<BookBorrow, Integer> {


}
