package com.kalash.tulip.controller.auth;

import com.kalash.tulip.dto.UserDTO;
import com.kalash.tulip.pojo.UserPojo;
import com.kalash.tulip.pojo.ResponsePojo;
import com.kalash.tulip.service.AuthService;
import com.kalash.tulip.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {
    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public ResponseEntity<ResponsePojo<UserDTO>> register(@RequestBody UserDTO userDTO){
        UserPojo user = Mapper.toUser(userDTO);

        // save user in db
        service.saveUser(user);

        ResponsePojo<UserDTO> response = new ResponsePojo<>(
                "success",
                "Registration successful."
        );

        return ResponseEntity.ok(response);
    }
}
