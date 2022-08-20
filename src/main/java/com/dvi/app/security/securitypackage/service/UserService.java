package com.dvi.app.security.securitypackage.service;

import com.dvi.app.security.securitypackage.models.Role;
import com.dvi.app.security.securitypackage.models.User;

import java.util.List;

public interface UserService {
    User findUserByUsername(String unsername);
    List<User> findAllUsers();
    User saveUser(User user);
    User createUser(String username,String Password);
    Role createRole(String roleName);
    User addRoleToUser(String username,String role);
    Role findRobeByName(String name);
    Role saveRole(Role role);
}
