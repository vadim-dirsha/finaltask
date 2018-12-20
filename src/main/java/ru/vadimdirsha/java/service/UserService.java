/**
 * Vadim Dirsha
 * Copyright (c) 2018 Java Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package ru.vadimdirsha.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vadimdirsha.java.dao.UserDAO;
import ru.vadimdirsha.java.dao.dao_impl.UserImplDAO;
import ru.vadimdirsha.java.exception.RegisterNewUserException;
import ru.vadimdirsha.java.model.User;


/**
 * @author = Vadim Dirsha
 */
@Service
public class UserService {

    private UserImplDAO userDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserDao(UserImplDAO userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUserAccount(User user) throws RegisterNewUserException {

        String pass = passwordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        try {
            userDao.insert(user);
        } catch (DuplicateKeyException e) {

            throw new RegisterNewUserException("RegisterNewUserException");
        }

        return user;
    }
}
