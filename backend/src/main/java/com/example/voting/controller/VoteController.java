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

    @GetMapping
    public List<Vote> getAllVotes() {
        return voteService.getAllVotes();
    }

    @PostMapping
    public Vote createVote(@RequestBody Vote vote) {
        return voteService.createVote(vote);
    }

    @PutMapping("/{id}")
    public Vote updateVote(@PathVariable Long id, @RequestBody Vote updatedVote) {
        return voteService.updateVote(id, updatedVote);
    }

    @DeleteMapping("/{id}")
    public void deleteVote(@PathVariable Long id) {
        voteService.deleteVote(id);
    }

    @GetMapping("/count")
    public Map<String, Long> getVoteCounts() {
        return voteService.countVotesByItem();
    }
}
