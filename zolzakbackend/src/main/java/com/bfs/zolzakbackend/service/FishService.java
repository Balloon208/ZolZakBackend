package com.bfs.zolzakbackend.service;

import com.bfs.zolzakbackend.domain.Fish;
import com.bfs.zolzakbackend.domain.UserFishList;
import com.bfs.zolzakbackend.domain.Users;
import com.bfs.zolzakbackend.repository.FishRepository;
import com.bfs.zolzakbackend.repository.UserFishRepository;
import com.bfs.zolzakbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FishService {
    private final FishRepository fishRepository;
    public Fish selectFish(Long fishid) {
        Fish fish = fishRepository.findById(fishid).orElseThrow(() -> new IllegalArgumentException("no such data"));

        return fish;
    }
}
