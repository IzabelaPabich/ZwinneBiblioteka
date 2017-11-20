package pl.zmzp.biblioteka.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zmzp.biblioteka.dto.Roles;
import pl.zmzp.biblioteka.dto.User;

import java.util.List;

/**
 * Created by lukasz on 20.11.17.
 */
public interface RolesRepositoryDao extends JpaRepository<Roles, Integer> {
    List<Roles> findRolesByUsers(User user);
}
