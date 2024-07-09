package com.bfs.zolzakbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Fish {
    @Id
    @Column(name = "fishid")
    private Long fishid;
    @Column
    private String fishname;
    @Column
    private Long hp;
    @Column
    private Long speed;
    @Column
    private String description;
    @Column
    private Long cost;
    @OneToMany(mappedBy = "fish")
    @JsonIgnore
    private List<UserFishList> userFishList;
}
