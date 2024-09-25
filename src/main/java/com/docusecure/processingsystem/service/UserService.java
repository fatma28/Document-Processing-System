package com.docusecure.processingsystem.service;


import com.docusecure.processingsystem.dao.UserRepository;
import com.docusecure.processingsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

/*
    @Autowired
    private PasswordEncoder passwordEncoder;
*/


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

//    public void registerUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }
}




