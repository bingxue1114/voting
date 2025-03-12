package com.example.voting.controller;

import com.example.voting.model.Vote;
import com.example.voting.service.VoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/votes")
@CrossOrigin(origins = "http://localhost:8080")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    // 取得所有投票資料
    @GetMapping
    public List<Vote> getAllVotes() {
        return voteService.getAllVotes();
    }

    // 新增投票資料
    @PostMapping
    public Vote createVote(@RequestBody Vote vote) {
        return voteService.createVote(vote);
    }

    // 計算投票資料
    @GetMapping("/count")
    public Map<String, Long> getVoteCounts() {
        return voteService.countVotesByItem();
    }
}
