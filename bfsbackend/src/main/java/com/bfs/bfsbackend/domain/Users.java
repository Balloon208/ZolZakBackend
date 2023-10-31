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
    private String playername;
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
}
