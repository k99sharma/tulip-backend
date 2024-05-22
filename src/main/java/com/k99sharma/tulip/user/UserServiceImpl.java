package com.k99sharma.tulip.user;

import com.k99sharma.tulip.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    private final Mapper mapper;

    public UserServiceImpl(UserRepository repository, Mapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        UserEntity userEntity = repository.findUserById(userId);

        if(userEntity == null)
            throw new UserNotFoundException("User not found.");

        return mapper.toUserDTO(userEntity);
    }
}
