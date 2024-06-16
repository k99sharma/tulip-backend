package com.k99sharma.tulip.user.repository;

import com.k99sharma.tulip.user.exception.UserNotFoundException;
import com.k99sharma.tulip.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public UserEntity findUserById(Long userId) throws UserNotFoundException;
    public UserEntity findUserByUsername(String username) throws UserNotFoundException;
    public List<UserEntity> findAll();
    @Query(Queries.IS_USERNAME_VALID)
    public Boolean isUsernameValid(@Param("username") String username);

    @Query(Queries.IS_EMAIL_VALID)
    public Boolean isEmailValid(@Param("email") String email);

    public Integer deleteUserById(Long userId) throws UserNotFoundException;
}
