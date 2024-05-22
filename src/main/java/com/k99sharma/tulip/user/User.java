package com.k99sharma.tulip.user;

import lombok.*;

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
}
