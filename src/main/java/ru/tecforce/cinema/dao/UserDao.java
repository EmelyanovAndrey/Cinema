package ru.tecforce.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.tecforce.cinema.model.User;

import java.util.List;

/**
 * Data Access Object for {@link User}.
 *
 * @version 1.0
 */
public interface UserDao extends JpaRepository<User, Long>
{
    /**
     * return {@link User} by username.
     *
     * @param username name of {@link User}.
     */
    User findByUsername(String username);

}
