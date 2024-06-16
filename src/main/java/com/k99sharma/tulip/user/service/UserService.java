package com.k99sharma.tulip.user.service;

import com.k99sharma.tulip.user.exception.UserNotFoundException;
import com.k99sharma.tulip.user.dto.UserDTO;

import java.util.List;

/**
 * Service interface for handling for user-related operations.
 */
public interface UserService {
    public UserDTO getUserById(Long userId) throws UserNotFoundException;
    public UserDTO getUserByUsername(String username) throws UserNotFoundException;
    public List<UserDTO> getAllUsers();
    public Boolean isUsernameValid(String username);
    public Boolean isEmailValid(String email);
    public Boolean deleteUserById(Long userId) throws UserNotFoundException;
}
