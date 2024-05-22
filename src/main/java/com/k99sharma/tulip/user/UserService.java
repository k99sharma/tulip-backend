package com.k99sharma.tulip.user;

import com.k99sharma.tulip.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

public interface UserService {
    public UserDTO getUserById(Long userId) throws UserNotFoundException;
}
