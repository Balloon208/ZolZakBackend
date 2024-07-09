package com.bfs.zolzakbackend.repository;

import com.bfs.zolzakbackend.domain.UserFishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserFishRepository extends JpaRepository<UserFishList, Long> {
    @Query("select uf from UserFishList uf where uf.user.userid = :userid")
    List<UserFishList> findAllByUserId(Long userid);
}
