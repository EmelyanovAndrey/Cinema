package ru.tecforce.cinema.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * JavaBean domain object that represents a User.
 *
 * @version 1.0
 */
@Entity
@Table(name = "users", schema = "bullcow")
public class User
{
    /**
     * Identification of {@link User}. Generation by DB
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * Name of {@link User}.
     */
    @Column(name = "username")
    private String username;


    /**
     * {@link User} password. Encoded by String Security. {@link org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder}
     */
    @Column(name = "password")
    private String password;


    /**
     * {@link User} date of birth.
     */
    @Column(name = "birthday")
    private LocalDate birthday;


    /**
     * Confirm password. Not store in DB. For login form.
     */
    @Transient
    private String confirmPassword;


    /**
     * {@link Set} {@link Role} of current {@link User}
     */
    @ManyToMany
    @JoinTable(name = "cinema.user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    /**
     * return identification of {@link User}.
     */
    public Long getId()
    {
        return id;
    }


    /**
     * set identification of {@link User}.
     *
     * @param id identification of {@link User}.
     */
    public void setId(Long id)
    {
        this.id = id;
    }


    /**
     * return name of {@link User}.
     */
    public String getUsername()
    {
        return username;
    }


    /**
     * set name of {@link User}.
     *
     * @param username name of {@link User}.
     */
    public void setUsername(String username)
    {
        this.username = username;
    }


    /**
     * return password of {@link User}.
     */
    public String getPassword()
    {
        return password;
    }


    /**
     * set password of {@link User}.
     *
     * @param password password of {@link User}.
     */
    public void setPassword(String password)
    {
        this.password = password;
    }


    /**
     * return day of birth of {@link User}.
     */
    public LocalDate getBirthday()
    {
        return birthday;
    }


    /**
     * set day of birth of {@link User}.
     *
     * @param birthday {@link User} day of birth.
     */
    public void setBirthday(LocalDate birthday)
    {
        this.birthday = birthday;
    }


    /**
     * return Confirm Password of {@link User}.
     */
    public String getConfirmPassword()
    {
        return confirmPassword;
    }


    /**
     * set Confirm Password of {@link User}.
     *
     * @param confirmPassword confirmPassword for login {@link User}.
     */
    public void setConfirmPassword(String confirmPassword)
    {
        this.confirmPassword = confirmPassword;
    }


    /**
     * return {@link Set} {@link Role} of this {@link User}.
     */
    public Set<Role> getRoles()
    {
        return roles;
    }


    /**
     * set {@link Set} {@link Role} of this {@link User}.
     *
     * @param roles {@link Set} of {@link Role}.
     */
    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }
}
