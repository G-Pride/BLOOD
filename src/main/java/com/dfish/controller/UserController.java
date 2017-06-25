package com.dfish.controller;

import com.dfish.domain.entity.User;
import com.dfish.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/4/23 0023.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    public Boolean create(@RequestBody User user) {
        repository.save(user);
        return true;
    }



}


