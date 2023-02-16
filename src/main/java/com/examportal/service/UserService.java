package com.examportal.service;

import com.examportal.entity.User;
import com.examportal.entity.UserRole;

import java.util.Set;

public interface UserService {

    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
}
