package com.k99sharma.tulip.user.controller;

import com.k99sharma.tulip.shared.pojo.Deletion;
import com.k99sharma.tulip.shared.pojo.Validity;
import com.k99sharma.tulip.user.exception.UserNotFoundException;
import com.k99sharma.tulip.user.mapper.UserMapper;
import com.k99sharma.tulip.user.pojo.User;
import com.k99sharma.tulip.user.service.UserService;
import com.k99sharma.tulip.user.service.UserServiceImpl;
import com.k99sharma.tulip.utils.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


/**
 * UserController handles all user-related requests.
 * This includes fetching, updating, validating, and deleting users.
 */
@RestController
@RequestMapping(value = "/tulip/api/user")
public class UserController {
    // logger
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    // service layer to handle user business logic
    private final UserService userService;

    // user mapper
    private final UserMapper userMapper;

    public UserController(UserServiceImpl userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    /**
     * Retrieves user details using user id.
     *
     * @param userId user id of user.
     * @return User object.
     */
    @GetMapping(value = "/getById/{userId}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Long userId){
        try{
            logger.info("Received the request to get user with user id - {}.", userId);

            User user = userMapper.toUser(userService.getUserById(userId));

            ApiResponse<User> response = new ApiResponse<>(
                    true,
                    "User retrieved successfully.",
                    user
            );

            logger.info("The request to get user data is handled.");
            return ResponseEntity.ok(response);
        }catch(UserNotFoundException e){
            logger.error(e.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ApiResponse<>(false, "User not found.", null)
            );
        }catch(Exception e){
            logger.error(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ApiResponse<>(false, e.getMessage(), null)
            );
        }
    }

    /**
     * Retrieves user details using username.
     *
     * @param username username of user.
     * @return User object.
     */
    @GetMapping(value = "/getByUsername")
    public ResponseEntity<ApiResponse<User>> getUserByUsername(@RequestParam String username){
        try{
            logger.info("Received the request to get user by username");

            User user = userMapper.toUser(userService.getUserByUsername(username));
            ApiResponse<User> response = new ApiResponse<>(
                    true,
                    "User retrieved successfully",
                    user
            );

            logger.info("The request to get user by username is handled.");
            return ResponseEntity.ok(response);
        }catch(UserNotFoundException e){
            logger.error(e.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ApiResponse<>(false, "User not found.", null)
            );
        }catch(Exception e){
            logger.error(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ApiResponse<>(false, e.getMessage(), null)
            );
        }
    }

    /**
     * Retrieves list of users.
     *
     * @return List of User object.
     */
    @GetMapping(value = "/getAll")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers(){
        try{
            logger.info("Received the request to get all users");

            List<User> users = userService.getAllUsers().stream().map(userMapper::toUser).collect(Collectors.toList());
            ApiResponse<List<User>> response = new ApiResponse<>(
                    true,
                    "List of all available users",
                    users
            );

            logger.info("The request to get all users is handled.");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            logger.error(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ApiResponse<> (false, e.getMessage(), null)
            );
        }
    }

    /**
     * Checks the validity of username.
     *
     * @param username username of user.
     * @return Validity object.
     */
    @GetMapping(value = "/validate/username")
    public ResponseEntity<ApiResponse<Validity>> isUsernameValid(@RequestParam String username){
        try{
            logger.info("Received the request to check if username is valid - {}", username);
            Boolean checkValidity = userService.isUsernameValid(username);

            ApiResponse<Validity> response = new ApiResponse<>(
              true,
              checkValidity ? "Username is valid." : "Username is not valid.",
              new Validity(checkValidity)
            );

            logger.info("The request to check the validity of username is handled.");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            logger.error(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ApiResponse<>(false, e.getMessage(), null)
            );
        }
    }

    /**
     * Checks the validity of email.
     *
     * @param email email address of user.
     * @return Validity object.
     */
    @GetMapping(value = "/validate/email")
    public ResponseEntity<ApiResponse<Validity>> isEmailValid(@RequestParam String email){
        try{
            logger.info("Received the request to check if email is valid - {}", email);
            Boolean checkValidity = userService.isEmailValid(email);

            ApiResponse<Validity> response = new ApiResponse<>(
                    true,
                    checkValidity ? "Email is valid." : "Email is not valid.",
                    new Validity(checkValidity)
            );

            logger.info("The request to check the validity of email is handled.");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            logger.error(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ApiResponse<>(false, e.getMessage(), null)
            );
        }
    }

    /**
     * Deletes the user by user id.
     *
     * @param userId id of user.
     * @return Deletion object.
     */
    @DeleteMapping(value = "/deleteById/{userId}")
    public ResponseEntity<ApiResponse<Deletion>> deleteUserById(@PathVariable Long userId){
        try{
            logger.info("Received the request to delete the user by id - {}", userId);
            Boolean deleted = userService.deleteUserById(userId);

            ApiResponse<Deletion> response = new ApiResponse<>(
                    true,
                    "User is deleted.",
                    new Deletion(deleted)
            );

            logger.info("The request to delete the user is handled.");
            return ResponseEntity.ok(response);
        }catch(UserNotFoundException e){
            logger.error(e.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ApiResponse<>(false, "User not found.", null)
            );
        }catch(Exception e){
            logger.error(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ApiResponse<> (false, e.getMessage(), null)
            );
        }
    }
}
