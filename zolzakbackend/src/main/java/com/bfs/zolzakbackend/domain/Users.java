package com.bfs.zolzakbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Users {
    @Id
    @Column(name = "userid")
    private Long userid;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Long coin;
    @Column
    private Long diamond;
    @Column
    private float maxdistance;
    @Column
    private float distance;
    @Column
    private Long permanenthpupgrade;
    @Column
    private Long permanentspeedupgrade;
    @Column
    private Long permanentitemupgrade;
    @Column
    private Long additionalhpupgrade;
    @Column
    private Long additionalshieldupgrade;
    @Column
    private Long additionalspeedupgrade;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserFishList> userFishList;
    @Column
    private Long equipedfish;
}
