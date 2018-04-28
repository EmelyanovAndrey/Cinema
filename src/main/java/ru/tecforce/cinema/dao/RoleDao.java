package ru.tecforce.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tecforce.cinema.model.Role;

/**
 * Data Access Object for {@link Role}.
 *
 * @version 1.0
 */
public interface RoleDao extends JpaRepository<Role, Long>
{
}
