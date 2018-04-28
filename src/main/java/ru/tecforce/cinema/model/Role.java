package ru.tecforce.cinema.model;

import javax.persistence.*;
import java.util.Set;

/**
 * JavaBean object that represents role of {@link User}.
 * Class for Spring Security.
 *
 * @version 1.0
 */
@Entity
@Table(name = "roles", schema = "bullcow")
public class Role
{

    /**
     * Identification of {@link Role}. Generation by DB.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * Name of {@link Role}.
     */
    @Column(name = "name")
    private String name;


    /**
     * Set User of this {@link Role}.
     */
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


    /**
     * Constructor
     */
    public Role()
    {
    }


    /**
     * return identification of {@link Role}.
     */
    public Long getId()
    {
        return id;
    }


    /**
     * set identification of {@link Role}.
     *
     * @param id identification of {@link Role}.
     */
    public void setId(Long id)
    {
        this.id = id;
    }


    /**
     * return name of {@link Role}.
     */
    public String getName()
    {
        return name;
    }


    /**
     * set name of {@link Role}.
     *
     * @param name name of {@link Role}.
     */
    public void setName(String name)
    {
        this.name = name;
    }


    /**
     * return {@link Set} {@link User} of this {@link Role}.
     */
    public Set<User> getUsers()
    {
        return users;
    }


    /**
     * set {@link Set} {@link User} of this {@link Role}.
     *
     * @param users {@link Set} of {@link User}.
     */
    public void setUsers(Set<User> users)
    {
        this.users = users;
    }


    @Override
    public String toString()
    {
        return "Role{" + "id=" + id + ", name='" + name + '\'' + ", users=" + users + '}';
    }
}
