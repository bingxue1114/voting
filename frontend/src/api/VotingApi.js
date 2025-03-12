import axios from 'axios';

// 設定後端 API 的 URL
const API_URL = 'http://localhost:8080/api/voting-items';

const VotingApi = {
    // 獲取所有投票項目
    getAllVotingItems() {
        return axios.get(API_URL)
            .then(response => response.data)
            .catch(error => {
                console.error("There was an error fetching voting items:", error);
                throw error;
            });
    },

    // 創建新的投票項目
    createVotingItem(votingItem) {
        return axios.post(API_URL, votingItem)
            .then(response => response.data)
            .catch(error => {
                console.error("There was an error creating voting item:", error);
                throw error;
            });
    },

    // 刪除投票項目
    deleteVotingItem(id) {
        return axios.delete(`${API_URL}/${id}`)
            .then(response => response.data)
            .catch(error => {
                console.error("There was an error deleting voting item:", error);
                throw error;
            });
    }
};

export default VotingApi;