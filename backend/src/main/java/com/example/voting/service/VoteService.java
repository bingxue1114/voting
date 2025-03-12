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

    // 獲取投票資料
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    // 建立投票資料
    public Vote createVote(Vote vote) {
        return voteRepository.save(vote);
    }

    // 計算投票項目比數
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
