package com.stock.chart.user.controllers;

import com.stock.chart.user.entities.User;
import com.stock.chart.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping("/login")
    public String[] loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }

    @PostMapping("/check")
    public boolean checkToken(@RequestBody String token) {
        return userService.checkToken(token);
    }

    @PostMapping("/logout")
    public void logoutUser(@RequestBody User user) {
        userService.logoutUser(user);
    }

}
