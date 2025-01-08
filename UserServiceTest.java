package com.fitness.service;

import com.fitness.dao.UserDao;
import com.fitness.model.User;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void testRegisterUser() {
        UserDao mockDao = mock(UserDao.class);
        UserService userService = new UserService(mockDao);
        User user = new User(1, "Jane Doe", 28, 65.0);

        userService.registerUser(user);
        verify(mockDao, times(1)).addUser(user);
    }

    @Test
    void testGetUserDetails() {
        UserDao mockDao = mock(UserDao.class);
        UserService userService = new UserService(mockDao);
        User user = new User(1, "Jane Doe", 28, 65.0);

        when(mockDao.getUserById(1)).thenReturn(user);
        User fetchedUser = userService.getUserDetails(1);

        assertEquals("Jane Doe", fetchedUser.getName());
    }
}
