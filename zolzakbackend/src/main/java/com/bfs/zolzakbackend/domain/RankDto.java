package com.bfs.zolzakbackend.domain;

import lombok.Getter;

@Getter
public class RankDto {
    private String username;
    private float maxdistance;

    public RankDto(String username, float maxdistance)
    {
        this.username = username;
        this.maxdistance = maxdistance;
    }
}
