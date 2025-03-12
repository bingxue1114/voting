<template>
  <div>
    <h2>投票項目管理</h2>
    <ul>
      <li v-for="vote in votes" :key="vote.id">
        {{ vote.title }} - {{ vote.description }}
        <button @click="deleteVote(vote.id)">刪除</button>
      </li>
    </ul>
    <button @click="addVote">新增投票</button>
  </div>
</template>

<script>
import { getAllVotes, createVote, deleteVote } from '@/api/voteApi.js';

export default {
  data() {
    return {
      votes: []
    };
  },
  methods: {
    async fetchVotes() {
      const response = await getAllVotes();
      this.votes = response.data;
    },
    async addVote() {
      await createVote({ title: "新投票", description: "請投票" });
      this.fetchVotes();
    },
    async deleteVote(id) {
      await deleteVote(id);
      this.fetchVotes();
    }
  },
  mounted() {
    this.fetchVotes();
  }
};
</script>
