package fr.epsi.dao;

import fr.epsi.model.Admin;
import fr.epsi.model.CreditCard;
import fr.epsi.model.User;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.PersistenceException;
import java.util.Arrays;

public class UserDaoTest {

    @Test
    public void insertUser() {
        User user = new User();
        user.setFirstname("Alex");
        user.setLastname("Bouillet");

        long id = new UserDao().save(user);

        User u = new UserDao().get(id);
        Assert.assertEquals("Alex", u.getFirstname());
    }

    @Test(expected = PersistenceException.class)
    public void uniqueEmail() {
        User user1 = new User();
        user1.setFirstname("Alex");
        user1.setLastname("Bouillet");
        user1.setEmail("bouillet.alex@gmail.com");

        User user2 = new User();
        user2.setFirstname("Test");
        user2.setLastname("Test");
        user2.setEmail("bouillet.alex@gmail.com");

        new UserDao().save(user1);
        new UserDao().save(user2);
    }

    @Test
    public void getUser() {
        User u = new UserDao().get(1L);
        System.out.println(u.getFirstname());
    }

    @Test
    public void insertAdmin() {
        Admin admin = new Admin();
        admin.setFirstname("admin");
        admin.setLastname("admin");
        admin.setEmail("admin@gmail.com");

        long id = new AdminDao().save(admin);
        Admin a = new AdminDao().get(id);

        Assert.assertEquals("admin", a.getFirstname());
    }



}
