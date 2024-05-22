package com.k99sharma.tulip.user;

import lombok.*;

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
}
