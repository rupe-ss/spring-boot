package com.rupesh.practice.springboot.service;

import com.rupesh.practice.springboot.model.AppUser;
import com.rupesh.practice.springboot.model.Role;
import com.rupesh.practice.springboot.repository.AppUserRepository;
import com.rupesh.practice.springboot.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class AppUserServiceImpl implements AppUserService{

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    @Override
    public AppUser saveAppUser(AppUser appUser) {
        AppUser user;
        try{
            log.info("Adding new User {} to db", appUser.getUsername());
            user = appUserRepository.save(appUser);
        } catch (Exception exception){
            log.error("Couldn't save to database");
            throw new IllegalStateException("Couldn't save to database");
        }
        return user;
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Adding new role {} to db", role.getName());
        Role saveRole = roleRepository.save(role);
        return saveRole;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding new role {} to user {}", roleName, username);
        Optional<AppUser> user = appUserRepository.findByUsername(username);
        if(user == null){
            log.info("User {} not found", username);
            throw new IllegalStateException("User not found");
        } else {
            Role role = roleRepository.findByName(roleName);
            user.get().getRoles().add(role);
        }
    }
}
