package com.example.voting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.voting.model.VotingItem;
import com.example.voting.service.VotingItemService;

@RestController
@RequestMapping("/api/voting-items")
@CrossOrigin(origins = "http://localhost:8080")
public class VotingItemController {

    @Autowired
    private VotingItemService votingItemService;

        // 取得所有投票項目
        @GetMapping
        public List<VotingItem> getAllVotingItems() {
            return votingItemService.findAll();
        }
    
        // 根據 id 取得單一投票項目
        @GetMapping("/{id}")
        public ResponseEntity<VotingItem> getVotingItemById(@PathVariable Long id) {
            VotingItem votingItem = votingItemService.findById(id);
            
            if (votingItem == null) {
                // 未找到該投票項目，回傳 404 Not Found
                System.out.println("未找到該投票項目，ID: " + id);
                return ResponseEntity.notFound().build();
            }
    
            return ResponseEntity.ok(votingItem); // 找到則返回該投票項目
        }
    
        // 新增投票項目
        @PostMapping
        public VotingItem createVotingItem(@RequestBody VotingItem votingItem) {
            return votingItemService.save(votingItem);
        }
    
        // 刪除投票項目
        @DeleteMapping("/{id}")
        public void deleteVotingItem(@PathVariable Long id) {
            votingItemService.delete(id);
        }

}
