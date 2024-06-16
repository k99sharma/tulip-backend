package com.k99sharma.tulip.user.pojo;

import lombok.*;

import java.util.Objects;

/**
 * User POJO
 * Class to be used in api response for sending user data.
 */
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @Override
    public boolean equals(Object o){
        if(!(o instanceof User))
            return false;

        // type casting object
        User user = (User) o;

        if(!user.getUsername().equals(this.username))
            return false;

        if(!user.getEmail().equals(this.email))
            return false;

        if(!user.getPassword().equals(this.password))
            return false;

        if(!user.getFirstName().equals(this.firstName))
            return false;

        if(!user.getLastName().equals(this.lastName))
            return false;

        return true;
    }

    @Override
    public int hashCode(){
        int result = Objects.hashCode(this.username);
        result += 31 * Objects.hashCode(this.email);
        result += 31 * Objects.hashCode(this.password);
        result += 31 * Objects.hashCode(this.firstName);
        result += 31 * Objects.hashCode(this.lastName);

        return result;
    }
}
