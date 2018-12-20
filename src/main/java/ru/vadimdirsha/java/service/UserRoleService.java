package ru.vadimdirsha.java.service;

import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    private static final String[] roles = new String[]{
            "Student",
            "Professor",
    };

    private static final String[] descriptions = new String[]{
            "Student",
            "Professor",
    };

    public String[] getRoleList() {
        return roles;
    }

    public String getRoleDescription(String role) {
        for (int i = 0; i < roles.length; i++) {
            if (roles[i].equals(role)) {
                return descriptions[i];
            }
        }
        return null;
    }
}
