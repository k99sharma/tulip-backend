package com.k99sharma.tulip.user.mapper;

import com.k99sharma.tulip.user.dto.UserDTO;
import com.k99sharma.tulip.user.entity.UserEntity;
import com.k99sharma.tulip.user.pojo.User;
import org.springframework.stereotype.Component;

/**
 * User mapper class.
 */
@Component
public class UserMapper {
    /**
     * Map user to user DTO
     *
     * @param user object
     * @return userDTO object
     */
    public UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());

        return userDTO;
    }

    /**
     * Map userDTO to user
     * @param userDTO object
     * @return user object
     */
    public User toUser(UserDTO userDTO){
        User user = new User();

        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());

        return user;
    }

    /**
     * Map user to user DTO
     *
     * @param user object
     * @return userDTO object
     */
    public UserDTO toUserDTO(UserEntity user){
        UserDTO userDTO = new UserDTO();

        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());

        return userDTO;
    }
}
