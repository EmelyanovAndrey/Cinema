package ru.tecforce.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.tecforce.cinema.dao.UserDao;
import ru.tecforce.cinema.model.Role;
import ru.tecforce.cinema.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link UserDetailsService}.
 *
 * @version 1.0
 */
public class UserDetailsServiceImpl implements UserDetailsService
{
    /**
     * Data Access Object for {@link User}.
     */
    @Autowired
    private UserDao userDao;

    /**
     * Return {@link org.springframework.security.core.userdetails.User} by name of {@link User}
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userDao.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : user.getRoles())
        {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
