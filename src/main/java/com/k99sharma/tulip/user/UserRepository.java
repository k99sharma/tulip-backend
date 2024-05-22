package com.k99sharma.tulip.user;

import com.k99sharma.tulip.exception.UserNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public UserEntity findUserById(Long userId) throws UserNotFoundException;
}
