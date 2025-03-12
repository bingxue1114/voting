package com.example.voting.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "votes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String voterName;

    @ManyToMany
    @JoinTable(name = "vote_voting_item", joinColumns = @JoinColumn(name = "vote_id"), inverseJoinColumns = @JoinColumn(name = "voting_item_id"))
    private List<VotingItem> votingItems; // 多選投票項目
}
