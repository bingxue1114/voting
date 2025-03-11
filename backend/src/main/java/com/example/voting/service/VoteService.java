package com.example.voting.service;

import com.example.voting.model.Vote;
import com.example.voting.repository.VoteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VoteService {
    private final VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public Vote createVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public Vote updateVote(Long id, Vote updatedVote) {
        return voteRepository.findById(id).map(vote -> {
            vote.setTitle(updatedVote.getTitle());
            vote.setDescription(updatedVote.getDescription());
            return voteRepository.save(vote);
        }).orElseThrow(() -> new RuntimeException("Vote not found"));
    }

    public void deleteVote(Long id) {
        voteRepository.deleteById(id);
    }
}
