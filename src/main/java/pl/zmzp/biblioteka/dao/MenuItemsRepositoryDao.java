package pl.zmzp.biblioteka.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.zmzp.biblioteka.dto.Book;
import pl.zmzp.biblioteka.dto.BookBorrow;
import pl.zmzp.biblioteka.dto.Roles;
import pl.zmzp.biblioteka.dto.User;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.List;

@Repository
public interface MenuItemsRepositoryDao extends JpaRepository<MenuItem, Integer> {

    List<MenuItem> findMenuItemsByRoles(Roles roles);
}
