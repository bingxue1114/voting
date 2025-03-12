package com.example.voting.service;

import com.example.voting.model.Vote;
import com.example.voting.model.VotingItem;
import com.example.voting.repository.VoteRepository;
import com.example.voting.repository.VotingItemRepository;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VoteService {
    private final VoteRepository voteRepository;
    @SuppressWarnings("unused")
    private final VotingItemRepository votingItemRepository;

    public VoteService(VoteRepository voteRepository, VotingItemRepository votingItemRepository) {
        this.voteRepository = voteRepository;
        this.votingItemRepository = votingItemRepository;
    }

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public Vote createVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public Vote updateVote(Long id, Vote updatedVote) {
        return voteRepository.findById(id).map(vote -> {
            vote.setVoterName(updatedVote.getVoterName());
            vote.setVotingItems(updatedVote.getVotingItems());
            return voteRepository.save(vote);
        }).orElseThrow(() -> new RuntimeException("Vote not found"));
    }

    public void deleteVote(Long id) {
        voteRepository.deleteById(id);
    }

    public Map<String, Long> countVotesByItem() {
        List<Vote> votes = voteRepository.findAll();
        Map<String, Long> voteCounts = new HashMap<>();

        for (Vote vote : votes) {
            for (VotingItem item : vote.getVotingItems()) {
                String itemName = item.getName();
                voteCounts.put(itemName, voteCounts.getOrDefault(itemName, 0L) + 1);
            }
        }

        return voteCounts;
    }
}
