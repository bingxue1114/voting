<template>
  <div>
    <h1>投票系統</h1>
    <form @submit.prevent="submitVote">
      <input type="text" v-model="voterName" placeholder="你的名字" required />
      
      <h3>選擇項目</h3>
      <div v-for="item in votingItems" :key="item.id">
        <input 
          type="checkbox" 
          :value="item.id" 
          v-model="selectedVotingItems" 
        />
        {{ item.name }}
      </div>

      <button type="submit">提交投票</button>
    </form>

    <h2>投票項目列表</h2>
    <ul>
      <li v-for="(voteCount, itemName) in voteCounts" :key="itemName">
        {{ itemName }}: {{ voteCount }} 票
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      votes: [],
      voteCounts: {},
      voterName: '',
      votingItems: [],
      selectedVotingItems: []  // 儲存選擇的投票項目
    };
  },
  methods: {
    async fetchVotingItems() {
      try {
        const response = await axios.get('http://localhost:8080/api/voting-items');
        this.votingItems = response.data;
      } catch (error) {
        console.error('Failed to fetch voting items:', error);
      }
    },
    async fetchVotes() {
      try {
        const response = await axios.get('http://localhost:8080/api/votes/count');
        this.voteCounts = response.data;
      } catch (error) {
        console.error('Failed to fetch votes count:', error);
      }
    },
    async submitVote() {
      const newVote = {
        voterName: this.voterName,
        votingItems: this.selectedVotingItems.map(id => ({ id }))  // 將選擇的投票項目作為對象傳遞
      };

      try {
        const response = await axios.post('http://localhost:8080/api/votes', newVote);
        console.log(response.status);  // 檢查回傳的狀態碼
        this.voterName = '';
        this.selectedVotingItems = [];
        this.fetchVotes(); // 刷新投票項目統計
      } catch (error) {
        console.error('Failed to submit vote:', error);
        console.log(error.response.status);  // 顯示錯誤狀態碼
      }
    }
  },
  mounted() {
    this.fetchVotingItems();
    this.fetchVotes();
  }
};
</script>
