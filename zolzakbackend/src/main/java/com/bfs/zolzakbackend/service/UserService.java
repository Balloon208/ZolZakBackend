package com.bfs.zolzakbackend.service;

import com.bfs.zolzakbackend.domain.UserFishList;
import com.bfs.zolzakbackend.domain.Users;
import com.bfs.zolzakbackend.repository.UserFishRepository;
import com.bfs.zolzakbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserFishRepository userFishRepository;
    public Users registUser(Users user)
    {
        userRepository.save(user);
        return user;
    }

    public Users removeUser(Long uuid)
    {
        Users user = userRepository.findById(uuid).orElseThrow(() -> new IllegalArgumentException("no such data"));
        userRepository.delete(user);

        return user;
    }

    public Users selectUser(Long uuid) {
        Users user = userRepository.findById(uuid).orElseThrow(() -> new IllegalArgumentException("no such data"));
        return user;
    }

    public List<Users> selectAllUser(){
        List<Users> userlist = userRepository.findAll(Sort.by(Sort.Direction.DESC, "maxdistance"));
        return userlist;
    }

    public List<UserFishList> getAllFish(Long userid) {
        List<UserFishList> userfishlist = userFishRepository.findAllByUserId(userid);
        return userfishlist;
    }

    public void addFish(UserFishList userFishList) {
        userFishRepository.save(userFishList);
    }

    public Users selectUserWithUsernameAndPassword(String username, String password) {
        Users user = userRepository.findByUsernameAndPassword(username, password).orElseThrow(() -> new IllegalArgumentException("no such data"));
        return user;
    }
}
