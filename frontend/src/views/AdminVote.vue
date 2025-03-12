<template>
  <div>
    <h1>後台投票管理</h1>
    
    <!-- 新增投票 -->
    <input v-model="newVote.title" placeholder="標題">
    <input v-model="newVote.description" placeholder="描述">
    <button @click="addVote">新增投票</button>

    <!-- 投票列表 -->
    <ul>
      <li v-for="vote in votes" :key="vote.id">
        <span>{{ vote.title }} - {{ vote.description }}</span>
        <button @click="editVote(vote)">編輯</button>
        <button @click="deleteVote(vote.id)">刪除</button>
      </li>
    </ul>

    <!-- 編輯投票 -->
    <div v-if="editingVote">
      <input v-model="editingVote.title" placeholder="標題">
      <input v-model="editingVote.description" placeholder="描述">
      <button @click="updateVote">更新</button>
    </div>
  </div>
</template>

<script>
import voteService from "@/api/voteService";

export default {
  data() {
    return {
      votes: [],
      newVote: { title: "", description: "" },
      editingVote: null,
    };
  },
  methods: {
    async fetchVotes() {
      const response = await voteService.getAllVotes();
      this.votes = response.data;
    },
    async addVote() {
      await voteService.createVote(this.newVote);
      this.newVote = { title: "", description: "" };
      this.fetchVotes();
    },
    editVote(vote) {
      this.editingVote = { ...vote };
    },
    async updateVote() {
      await voteService.updateVote(this.editingVote.id, this.editingVote);
      this.editingVote = null;
      this.fetchVotes();
    },
    async deleteVote(id) {
      await voteService.deleteVote(id);
      this.fetchVotes();
    },
  },
  mounted() {
    this.fetchVotes();
  },
};
</script>
