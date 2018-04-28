package ru.tecforce.cinema.service;

import ru.tecforce.cinema.model.User;

import java.util.List;

/**
 * Interface for store {@link User}
 *
 * @version 1.0
 */
public interface UserService
{
    /**
     * save {@link User} in DB.
     */
    void save(User user);

    /**
     * return {@link User} by username.
     *
     * @param username name of {@link User}.
     */
    User findByUsername(String username);

    /**
     * return {@link List} of {@link User} for rating. Best 10 players.
     */
    List<User> findTop10ByOrderByRating();

    /**
     * update {@link User} rating by username and last game rating.
     *
     * @param username name of {@link User}
     * @param lastGameRating rating in last game
     */
    void updateRating(int lastGameRating, String username);
}
