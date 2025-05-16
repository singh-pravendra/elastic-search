package com.elastic.controller;

import com.elastic.beans.User;
import com.elastic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public String save(@RequestBody User user) throws Exception {
        return service.add(user);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable String id) throws Exception {
        return service.fetch(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws Exception {
        service.delete(id);
    }
}
