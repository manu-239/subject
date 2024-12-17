package com.sms.subject.controller;

import com.sms.subject.entity.User;
import com.sms.subject.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathParam("id") Long id){
        return userService.deleteUser(id);
    }
}
