package com.rupesh.practice.springboot.service;

import com.rupesh.practice.springboot.model.AppUser;
import com.rupesh.practice.springboot.model.Role;

public interface AppUserService {
    AppUser saveAppUser(AppUser appUser);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);
}
