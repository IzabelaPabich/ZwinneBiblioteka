package pl.zmzp.biblioteka.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zmzp.biblioteka.dto.Book;

import java.util.List;

/**
 * Created by Alebazi on 2017-10-30.
 */
public interface BookRepositoryDao extends JpaRepository<Book, Integer > {

}
