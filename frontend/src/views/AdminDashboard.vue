<template>

  <div class="container">
    <div class="row">
      <!-- 新增投票項目 -->
        <h2 class="mt-3">管理投票項目</h2>
        <form @submit.prevent="addVotingItem">
          <div class="row mb-3">
            <label for="inputEmail3" class="col-sm-2 col-form-label">投票項目名稱</label>
            <div class="col-sm-10">
              <input type="text" v-model="newItem.name" class="form-control" placeholder="投票項目名稱" required>
            </div>
          </div>
          <button type="submit" class="btn btn-primary form-control">送出</button>
        </form>
      <!-- 新增投票項目 -->

      <!-- 表格顯示投票項目 -->
        <hr class="mt-3">
        <h2>所有投票項目</h2>
          <div class="col-lg-12 mt-2 mb-2">
              <table style="border:0" class="table table-striped table-responsive-md table-hover">
                  <thead class="thead-dark">
                      <tr>
                          <th>編號</th>
                          <th>項目名稱</th>
                          <th>控制</th>
                      </tr>
                  </thead>
                  <tbody>
                      <tr v-for="item in votingItems" :key="item.id">
                          <td >{{ item.id }}</td>
                          <td >{{ item.name }}</td>
                          <td>
                              <button @click="deleteVotingItem(item.id)" class="btn btn-danger">刪除</button>
                          </td>
                      </tr>
                  </tbody>
              </table>
          </div>
      <!-- 表格顯示投票項目 -->
        
    </div>
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
          this.newItem = { title: ''};  // 清除表單
          this.fetchVotingItems();  // 重新加載
        })
        .catch(error => console.error(error));
    },
    // 刪除投票項目
    deleteVotingItem(id) {
      VotingService.deleteVotingItem(id)
        .then(() => {
          this.fetchVotingItems(); // 刪除後重新載入
        })
        .catch(error => console.error("刪除失敗", error));
    }

  },
  mounted() {
    this.fetchVotingItems();  // 載入頁面後獲取投票項目
  }
};
</script>
