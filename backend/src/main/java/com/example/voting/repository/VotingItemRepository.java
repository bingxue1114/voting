package com.example.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.voting.model.VotingItem;

public interface VotingItemRepository extends JpaRepository<VotingItem, Long> {
    
}