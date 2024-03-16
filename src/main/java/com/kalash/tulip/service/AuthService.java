package com.kalash.tulip.service;

import com.kalash.tulip.pojo.UserPojo;
import com.kalash.tulip.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthRepository repository;

    @Autowired
    public AuthService(AuthRepository authRepository) {
        this.repository = authRepository;
    }

    public void saveUser(UserPojo user){
        repository.save(user);
    }
}
