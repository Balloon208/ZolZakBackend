package com.bfs.bfsbackend.controller;

import com.bfs.bfsbackend.domain.Users;
import com.bfs.bfsbackend.repository.UserRepository;
import com.bfs.bfsbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
//    RequestMapping(value = "/home", method = RequestMethod.GET)
//    public String home(){
//        return "home";
//    }

    @GetMapping("/api/users/{id}")
    public Users selectWithId(@PathVariable("id") String uuid){
        Users user = userService.selectUser(uuid);
        return user;
    }

    @PostMapping("/api/users/input")
    public Users createUser(@RequestBody Users user){
        System.out.println(user);
        userService.registUser(user);
        return user;
    }

    @DeleteMapping("/api/users/delete/{id}")
    public Users deleteWithId(@PathVariable("id") String uuid){
        Users user = userService.removeUser(uuid);
        return user;
    }
}
