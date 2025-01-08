package com.fitness.dao;

import com.fitness.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
