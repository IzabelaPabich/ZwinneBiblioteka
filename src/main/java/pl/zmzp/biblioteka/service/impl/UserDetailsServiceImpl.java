package pl.zmzp.biblioteka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.zmzp.biblioteka.dao.RolesRepositoryDao;
import pl.zmzp.biblioteka.dao.UserRepositoryDao;
import pl.zmzp.biblioteka.dto.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    public static final String UZYTKOWNIK = "UZYTKOWNIK";

    @Autowired
    UserRepositoryDao userRepositoryDao;

    @Autowired
    RolesRepositoryDao rolesRepositoryDao;

    @Override
    public UserDetails loadUserByUsername(String nazwa_uzy) throws UsernameNotFoundException {
        final User user = userRepositoryDao.findUserByNazwaUzy(nazwa_uzy);

        if(user != null) {
            final List<SimpleGrantedAuthority> authorities = rolesRepositoryDao.findRolesByUsers(user).stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
            if(authorities.isEmpty()){
                authorities.add(new SimpleGrantedAuthority(UZYTKOWNIK));
            }
            return new org.springframework.security.core.userdetails.User(
                    user.getNazwaUzy(),
                    user.getHaslo(),
                    authorities);
        }
        throw new UsernameNotFoundException("Nie znaleziono użytkownika '" + nazwa_uzy + "'.");
    }
}
