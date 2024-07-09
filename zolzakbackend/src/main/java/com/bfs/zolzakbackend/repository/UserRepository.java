package com.bfs.zolzakbackend.repository;

import com.bfs.zolzakbackend.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("select u from Users u where u.username = :username and u.password = :password")
    Optional<Users> findByUsernameAndPassword(String username, String password);
}
