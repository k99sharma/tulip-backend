package com.k99sharma.tulip.user.dto;

import lombok.*;

import java.util.Objects;

/**
 * User DTO
 * Class to be used user-related date transfer between controller and service layer.
 */
@Data
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    @Override
    public boolean equals(Object o){
        if(! (o instanceof UserDTO))
            return false;

        // type case object
        UserDTO userDTO = (UserDTO) o;

        if(!Objects.equals(userDTO.id, this.id))
            return false;

        if(!userDTO.getUsername().equals(this.username))
            return false;

        if(!userDTO.getEmail().equals(this.email))
            return false;

        if(!userDTO.getFirstName().equals(this.firstName))
            return false;

        if(!userDTO.getLastName().equals(this.lastName))
            return false;

        if(!userDTO.getPassword().equals(this.password))
            return false;

        return true;
    }

    @Override
    public int hashCode(){
        int result = Long.hashCode(id);
        result += 31 * Objects.hashCode(username);
        result += 31 * Objects.hashCode(email);
        result += 31 * Objects.hashCode(firstName);
        result += 31 * Objects.hashCode(lastName);
        result += 31 * Objects.hashCode(password);

        return result;
    }
}
