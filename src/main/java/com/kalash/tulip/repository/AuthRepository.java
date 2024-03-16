package com.kalash.tulip.repository;

import com.kalash.tulip.pojo.UserPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<UserPojo, Long> {
    public UserPojo save(UserPojo user);
}
