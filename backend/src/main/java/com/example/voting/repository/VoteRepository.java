package com.example.voting.repository;

import com.example.voting.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    // 這裡不需要寫額外的查詢方法，因為 JpaRepository 已經提供了基本的 CRUD 操作
}
