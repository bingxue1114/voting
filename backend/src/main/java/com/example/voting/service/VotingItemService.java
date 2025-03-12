package com.example.voting.service;

import com.example.voting.model.VotingItem;
import com.example.voting.repository.VotingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VotingItemService {

    // 用於操作資料庫
    @Autowired
    private VotingItemRepository votingItemRepository;

    // 儲存投票項目
    public VotingItem save(VotingItem votingItem) {
        return votingItemRepository.save(votingItem); // 儲存投票項目並返回結果
    }

    // 查詢所有投票項目
    public List<VotingItem> findAll() {
        return votingItemRepository.findAll(); // 獲取所有投票項目
    }

    // 根據 ID 查找單一投票項目
    public VotingItem findById(Long id) {
        Optional<VotingItem> votingItem = votingItemRepository.findById(id);
        return votingItem.orElse(null); // 如果未找到，返回 null
    }

    // 刪除投票項目
    public void delete(Long id) {
        votingItemRepository.deleteById(id);
    }
}
