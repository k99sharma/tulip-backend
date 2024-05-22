package com.k99sharma.tulip.user;

import com.k99sharma.tulip.exception.UserNotFoundException;
import com.k99sharma.tulip.utils.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tulip/api/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService service;
    private final Mapper mapper;

    public UserController(UserServiceImpl service, Mapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/getById")
    public ResponseEntity<ApiResponse<User>> getUserById(@RequestParam Long userId){
        try{
            logger.info("Invoking UserController::getUserById");

            User user = mapper.toUser(service.getUserById(userId));

            logger.info("User retrieved successfully.");
            ApiResponse<User> response = new ApiResponse<>(
                    true,
                    "User retrieved successfully.",
                    user
            );

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
}
