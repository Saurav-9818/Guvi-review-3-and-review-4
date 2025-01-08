package com.fitness.service;

import com.fitness.dao.UserDao;
import com.fitness.model.User;

public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserDetails(int id) {
        return userDao.getUserById(id);
    }

    public void registerUser(User user) {
        userDao.addUser(user);
    }

    public void removeUser(int id) {
        userDao.deleteUser(id);
    }
}
