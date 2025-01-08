package com.fitness.dao;

import com.fitness.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void testAddAndGetUser() {
        UserDao userDao = new UserDao();
        User user = new User(1, "John Doe", 25, 70.5);

        userDao.addUser(user);
        List<User> users = userDao.getAllUsers();

        assertEquals(1, users.size());
        assertEquals("John Doe", users.get(0).getName());
    }

    @Test
    void testDeleteUser() {
        UserDao userDao = new UserDao();
        User user = new User(1, "John Doe", 25, 70.5);

        userDao.addUser(user);
        userDao.deleteUser(1);

        assertTrue(userDao.getAllUsers().isEmpty());
    }
}
