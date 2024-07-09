package com.bfs.zolzakbackend.controller;

import com.bfs.zolzakbackend.domain.Fish;
import com.bfs.zolzakbackend.domain.RankDto;
import com.bfs.zolzakbackend.domain.UserFishList;
import com.bfs.zolzakbackend.domain.Users;
import com.bfs.zolzakbackend.repository.UserRepository;
import com.bfs.zolzakbackend.service.FishService;
import com.bfs.zolzakbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final FishService fishService;
//    RequestMapping(value = "/home", method = RequestMethod.GET)
//    public String home(){
//        return "home";
//    }

//    @GetMapping("/api/users/findbyid/{id}")
//    public Users selectWithId(@PathVariable("id") Long uuid){
//        Users user = userService.selectUser(uuid);
//        return user;
//    }

    @GetMapping("/api/users/findbyname/{username}&{password}")
    public Users selectWithUserName(@PathVariable("username") String username, @PathVariable("password") String password){
        Users user = userService.selectUserWithUsernameAndPassword(username, password);
        return user;
    }

    @GetMapping("/api/users/all")
    public List<RankDto> selectAll(){
        List<Users> userlist = userService.selectAllUser();
        List<RankDto> ranklist = userlist.stream()
                        .map(user -> new RankDto(user.getUsername(), user.getMaxdistance()))
                        .collect(Collectors.toList());
        return ranklist;
    }

    @GetMapping("/api/users/{id}/fish")
    public List<Long> selectAllFish(@PathVariable("id") Long userid){
        List<UserFishList> userfishlist = userService.getAllFish(userid);
        List<Long> fishidlist = userfishlist.stream()
                                .map(UserFishList::getFish)
                                .map((Fish::getFishid))
                                .collect(Collectors.toList());

        return fishidlist;
    }

    @PostMapping("/api/users/{id}/addfish/{fishid}")
    public void addFish(@PathVariable("id") Long userid, @PathVariable("fishid") Long fishid){
        Users user = userService.selectUser(userid);
        Fish fish = fishService.selectFish(fishid);
        UserFishList addinfo = new UserFishList(user, fish);
        userService.addFish(addinfo);
    }

    @PostMapping("/api/users/input")
    public Users createUser(@RequestBody Users user){
        System.out.println(user);
        userService.registUser(user);
        return user;
    }

    @DeleteMapping("/api/users/delete/{id}")
    public Users deleteWithId(@PathVariable("id") Long uuid){
        Users user = userService.removeUser(uuid);
        return user;
    }
}
