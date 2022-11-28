package com.rupesh.practice.springboot.controller;

import com.rupesh.practice.springboot.model.AppUser;
import com.rupesh.practice.springboot.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    AppUserService appUserService;

    @GetMapping("/all")
    public List<AppUser> getAllUsers(){
        return appUserService.getAllUsers();
    }
}
