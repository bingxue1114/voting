<template>
  <div>
    <h1>管理投票項目</h1>

    <!-- 新增投票項目 -->
    <form @submit.prevent="addVotingItem">
      <input v-model="newItem.name" placeholder="投票項目名稱" required />
      <button type="submit">新增</button>
    </form>

    <!-- 顯示所有投票項目 -->
    <ul>
      <li v-for="item in votingItems" :key="item.id">
        {{ item.id }} - {{ item.name }}
        <button @click="deleteVotingItem(item.id)">刪除</button>
      </li>
    </ul>

  </div>
</template>

<script>
import VotingService from '@/services/VotingService';

export default {
  data() {
    return {
      votingItems: [],  // 用來存儲所有投票項目
      newItem: {
        name: '',
        description: ''
      }
    };
  },
  methods: {
    // 獲取所有投票項目
    fetchVotingItems() {
      VotingService.getAllVotingItems()
        .then(response => {
          this.votingItems = response.data;
        })
        .catch(error => console.error(error));
    },
    // 新增投票項目
    addVotingItem() {
      VotingService.createVotingItem(this.newItem)
        .then(() => {
          this.newItem = { title: ''};  // 重置表單
          this.fetchVotingItems();  // 重新加載投票項目
        })
        .catch(error => console.error(error));
    },
    // 刪除投票項目
    deleteVotingItem(id) {
      VotingService.deleteVotingItem(id)
        .then(() => {
          this.fetchVotingItems(); // 刪除後重新載入投票項目
        })
        .catch(error => console.error("刪除失敗", error));
    }

  },
  mounted() {
    this.fetchVotingItems();  // 在組件掛載後獲取投票項目
  }
};
</script>

<style scoped>
/* 你可以在這裡寫 CSS 樣式 */
</style>
