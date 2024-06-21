package com.jdbc.tourism.controller;


import com.jdbc.tourism.entity.User;
import com.jdbc.tourism.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("tourism")
public class UserController {
    @Autowired
    private UserService userService;

     @ApiOperation(value = "Регисстрирует пользователя", notes = "Регистрация пользователя через логин почту и пароль")
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        User loggedUser = userService.loginUser(user.getUsername(), user.getPassword());
        if (loggedUser!= null) {
            return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
    }
}
