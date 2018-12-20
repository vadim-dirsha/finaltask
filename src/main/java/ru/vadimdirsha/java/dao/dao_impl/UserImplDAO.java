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
package ru.vadimdirsha.java.dao.dao_impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.vadimdirsha.java.dao.UserDAO;
import ru.vadimdirsha.java.model.User;

import java.util.List;

/**
 * @author = Vadim Dirsha
 */
@Repository
public class UserImplDAO implements UserDAO {

    public static Logger logger = LogManager.getLogger("ConfigurationLogger");

    @Autowired
    private NamedParameterJdbcTemplate template;

    public NamedParameterJdbcTemplate getTemplate() {
        return template;
    }

    @Override
    public long insert(User user) {
        // todo fix yellow
        String sql = "INSERT INTO users (firstName, lastName, role, username, password) " +
                "VALUES(:firstName, :lastName, :role, :username, :password)";

        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("firstName", user.getFirstName())
                .addValue("lastName", user.getLastName())
                .addValue("role", user.getRole())
                .addValue("username", user.getUsername())
                .addValue("password", user.getPassword());

        KeyHolder key = new GeneratedKeyHolder();
        this.getTemplate().update(sql, parameters, key);

        user.setId(key.getKey().longValue());

        return user.getId();
    }

    @Override
    public int update(User entity) {
        return 0;
    }

    @Override
    public long save(User entity) {
        return 0;
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public User findOne(User entity) {
        return null;
    }

    @Override
    public User findOneById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Long count() {
        return null;
    }
}
