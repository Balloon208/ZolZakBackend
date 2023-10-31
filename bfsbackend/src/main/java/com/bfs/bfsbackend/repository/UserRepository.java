package com.bfs.bfsbackend.repository;

import com.bfs.bfsbackend.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {

}
