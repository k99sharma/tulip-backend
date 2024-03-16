package com.kalash.tulip.util;

import com.kalash.tulip.dto.UserDTO;
import com.kalash.tulip.pojo.UserPojo;

public class Mapper {
    // mapper to map User to UserDTO
    public static UserDTO toUserDTO(UserPojo user){
        UserDTO userDTO = new UserDTO();

        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());

        return userDTO;
    }

    // mapper to map UserDTO to User
    public static UserPojo toUser(UserDTO userDTO){
        UserPojo user = new UserPojo();

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());

        return user;
    }
}
