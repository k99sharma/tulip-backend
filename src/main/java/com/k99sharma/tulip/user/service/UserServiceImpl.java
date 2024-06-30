package com.k99sharma.tulip.user.service;

import com.k99sharma.tulip.user.dto.UserDTO;
import com.k99sharma.tulip.user.entity.UserEntity;
import com.k99sharma.tulip.user.exception.UserNotFoundException;
import com.k99sharma.tulip.user.mapper.UserMapper;
import com.k99sharma.tulip.user.pojo.UserUpdateRequest;
import com.k99sharma.tulip.user.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User service to handle user business logic.
 */
@Service
public class UserServiceImpl implements UserService {
    // user repository to handle user db related operations
    private final UserRepository repository;

    // user mapper
    private final UserMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;

    public UserServiceImpl(UserRepository repository, UserMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Business logic to get user details using user id.
     *
     * @param userId user id of user.
     * @return UserDTO object.
     * @throws UserNotFoundException in case user is not found.
     */
    @Override
    public UserDTO getUserById(Long userId) {
        UserEntity user = repository.findUserById(userId);

        if(user == null)
            throw new UserNotFoundException("User not found.");

        return mapper.toUserDTO(user);
    }

    /**
     * Business logic to get user details using username.
     *
     * @param username username of user.
     * @return UserDTO object.
     * @throws UserNotFoundException in case user is not found.
     */
    @Override
    public UserDTO getUserByUsername(String username) throws UserNotFoundException {
        UserEntity user = repository.findUserByUsername(username);

        if(user == null)
            throw new UserNotFoundException("User not found.");

        return mapper.toUserDTO(user);
    }

    /**
     * Business logic to get all users details
     *
     * @return List of UserDTO object.
     */
    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = repository.findAll();

        if(users == null || users.isEmpty())
            return new ArrayList<>();

        return users.stream().map(mapper::toUserDTO).collect(Collectors.toList());
    }

    /**
     * Business logic to check username validity.
     *
     * @param username username of user.
     * @return Boolean validity of username.
     */
    @Override
    public Boolean isUsernameValid(String username) {
        return repository.isUsernameValid(username);
    }

    /**
     * Business logic to check validity of email.
     *
     * @param email email of user.
     * @return Boolean validity of email.
     */
    @Override
    public Boolean isEmailValid(String email) {
        return repository.isEmailValid(email);
    }

    /**
     * Business logic to delete user using user id.
     *
     * @param userId user id of user.
     * @return Boolean validity of user deletion operation.
     * @throws UserNotFoundException in case user is not found.
     */
    @Override
    public Boolean deleteUserById(Long userId) throws UserNotFoundException {
        Integer deleted = repository.deleteUserById(userId);

        if(deleted == 0)
            throw new UserNotFoundException("User not found.");

        return deleted == 1;
    }

    /**
     * Business logic to update user using user id.
     *
     * @param id user id of user.
     * @param updateDetails details of the user to be updated.
     * @return UserDTO object.
     * @throws UserNotFoundException in case user is not found.
     */
    @Override
    public UserDTO updateUserById(Long id, UserUpdateRequest updateDetails) throws UserNotFoundException{
        UserEntity userEntity = repository.findById(id)
                .map(user -> {
                    if(updateDetails.getFirstName() != null)
                        user.setFirstName(updateDetails.getFirstName());

                    if(updateDetails.getLastName() != null)
                        user.setLastName(updateDetails.getLastName());

                    if(updateDetails.getUsername() != null)
                        user.setUsername(updateDetails.getUsername());

                    return repository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException("User not found."));

        return mapper.toUserDTO(userEntity);
    }
}
