package com.bfs.bfsbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users {
    @Id
    private String uuid;
    @Column
    private String name;
    @Column
    private Long coin;
    @Column
    private Long fanmeetingA;
    @Column
    private Long fanmeetingB;
    @Column
    private Long fanmeetingC;
    @Column
    private Long likeability;
    @Column
    private double probability;
    @Column
    private Long month;
    @Column
    private Long day;
    @Column
    private Long ClickLevel;
    @Column
    private Long AutoLevel;
    @Column
    private Long Count_Probability;
    @Column
    private Long ItemCount;
    @Column
    private Long StoryCount;
    @Column
    private Long FanclubCount;
    @Column
    private Long WorldFanMeeting;
    @Column
    private Long WorldConcert;
}
