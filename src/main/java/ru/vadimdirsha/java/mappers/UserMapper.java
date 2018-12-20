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
package ru.vadimdirsha.java.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.vadimdirsha.java.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author = Vadim Dirsha
 */
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User result = new User();
        result.setId(rs.getLong("id"));
        result.setFirstName(rs.getString("firstName"));
        result.setLastName(rs.getString("lastName"));
        result.setUsername(rs.getString("userName"));
        result.setRole(rs.getString("role"));
        return result;
    }
}
