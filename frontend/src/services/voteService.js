import axios from "axios";

const API_URL = "http://localhost:8080/api/votes";

const handleError = (error) => {
    console.error("API Error:", error);
    throw error; // 重新拋出錯誤，方便在呼叫處處理
};

const handleResponse = (response) => {
    return response.data; // 格式化返回的資料，只返回需要的部分
};

export default {
    // 獲取所有投票
    getAllVotes() {
        return axios
            .get(API_URL)
            .then(handleResponse)
            .catch(handleError);
    },

    // 創建投票
    createVote(vote) {
        return axios
            .post(API_URL, vote)
            .then(handleResponse)
            .catch(handleError);
    },

    // 更新投票
    updateVote(id, vote) {
        return axios
            .put(`${API_URL}/${id}`, vote)
            .then(handleResponse)
            .catch(handleError);
    },

    // 刪除投票
    deleteVote(id) {
        return axios
            .delete(`${API_URL}/${id}`)
            .then(handleResponse)
            .catch(handleError);
    }
};