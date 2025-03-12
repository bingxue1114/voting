<template>

    <div class="container">
      <div class="row">

      <!-- 投票系統 -->
        <h2 class="mt-3">投票系統</h2>

        <form @submit.prevent="submitVote">
          <div class="row mb-3">
            <label for="inputEmail3" class="col-sm-2 col-form-label">名字</label>
            <div class="col-sm-10">
              <input type="text" v-model="voterName" class="form-control" placeholder="你的名字" required>
            </div>
          </div>
          
          <fieldset class="row mb-3">
            <legend class="col-form-label col-sm-2 pt-0">選項 *可多選</legend>
            <div class="col-sm-10">
              <div class="form-check"  v-for="item in votingItems" :key="item.id">
                <input class="form-check-input" type="checkbox" :value="item.id" v-model="selectedVotingItems" checked>
                <label class="form-check-label">
                  {{ item.name }}
                </label>
              </div>
            </div>
          </fieldset>

          <button type="submit" class="btn btn-primary form-control">送出</button>
        </form>
      <!-- 投票系統 -->
        
        <hr class="mt-3">

      <!-- 表格顯示投票比數 -->
        <h2>目前比數</h2>
          <div class="col-lg-12 mt-2 mb-2">
              <table style="border:0" class="table table-striped table-responsive-md table-hover">
                  <thead class="thead-dark">
                      <tr>
                          <th>項目名稱</th>
                          <th>目前票數</th>
                      </tr>
                  </thead>
                  <tbody>
                      <tr v-for="(voteCount, itemName) in voteCounts" :key="itemName">
                          <td >{{ itemName }}</td>
                          <td >{{ voteCount }}票</td>
                      </tr>
                  </tbody>
              </table>
          </div>
        <!-- 表格顯示投票比數 -->

      </div>
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
        console.log(response.status);  // 檢查回傳的狀態
        this.voterName = '';
        this.selectedVotingItems = [];
        this.fetchVotes(); // 刷新投票項目統計
      } catch (error) {
        console.error('Failed to submit vote:', error);
        console.log(error.response.status);  // 顯示錯誤狀態
      }
    }
  },
  mounted() {
    this.fetchVotingItems();
    this.fetchVotes();
  }
};
</script>
