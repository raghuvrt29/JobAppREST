package com.raghuvrt29.JobAppRest.service;

import com.raghuvrt29.JobAppRest.model.User;
import com.raghuvrt29.JobAppRest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public User saveUser(User user){
        return repo.save(user);
    }

}
