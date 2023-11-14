package com.bfs.bfsbackend.service;

import com.bfs.bfsbackend.domain.Users;
import com.bfs.bfsbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public Users registUser(Users user)
    {
        userRepository.save(user);
        return user;
    }

    public Users removeUser(String uuid)
    {
        Users user = userRepository.findById(uuid).orElseThrow(() -> new IllegalArgumentException("no such data"));
        userRepository.delete(user);

        return user;
    }

    public Users selectUser(String uuid) {
        Users user = userRepository.findById(uuid).orElseThrow(() -> new IllegalArgumentException("no such data"));
        return user;
    }
}
