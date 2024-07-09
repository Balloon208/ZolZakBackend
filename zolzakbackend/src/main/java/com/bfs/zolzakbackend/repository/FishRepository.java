package com.bfs.zolzakbackend.repository;

import com.bfs.zolzakbackend.domain.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepository extends JpaRepository<Fish, Long> {

}
