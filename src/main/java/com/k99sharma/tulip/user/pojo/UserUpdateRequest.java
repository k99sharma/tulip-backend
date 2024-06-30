package com.k99sharma.tulip.user.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserUpdateRequest {
    private String firstName;
    private String lastName;
    private String username;
}
