package com.flipkartclone.service;

import com.flipkartclone.dao.UserDAO;
import com.flipkartclone.model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public void register(User user) throws Exception {
        userDAO.registerUser(user);
    }

    public User login(String email, String password) throws Exception {
        return userDAO.login(email, password);
    }
}