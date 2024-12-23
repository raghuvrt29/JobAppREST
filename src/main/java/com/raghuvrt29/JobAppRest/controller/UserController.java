package com.raghuvrt29.JobAppRest.controller;

import com.raghuvrt29.JobAppRest.model.User;
import com.raghuvrt29.JobAppRest.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping
    public String register(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        service.saveUser(user);
        return "Successfully Registered";
    }

    @PostMapping
    public String login(@RequestBody User user){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if(authentication.isAuthenticated()){
            return "Successfully Logged in";
        }
        else{
            return "Login failed";
        }

    }

}
