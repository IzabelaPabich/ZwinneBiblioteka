package pl.zmzp.biblioteka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.zmzp.biblioteka.dao.UserRepositoryDao;
import pl.zmzp.biblioteka.dto.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepositoryDao userRepositoryDao;

    @Override
    public UserDetails loadUserByUsername(String nazwa_uzy) throws UsernameNotFoundException {
        final User user = userRepositoryDao.findUserByNazwaUzy(nazwa_uzy);

        if(user != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new org.springframework.security.core.userdetails.User(
                    user.getNazwaUzy(),
                    user.getHaslo(),
                    authorities);
        }
        throw new UsernameNotFoundException("Nie znaleziono użytkownika '" + nazwa_uzy + "'.");
    }
}
