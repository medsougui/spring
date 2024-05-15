package com.med.ani.service;

import com.med.ani.entities.Role;
import com.med.ani.entities.User;
public interface UserService {
void deleteAllusers();
void deleteAllRoles();
User saveUser(User user);
User findUserByUsername (String username);
Role addRole(Role role);
User addRoleToUser(String username, String rolename);
}
