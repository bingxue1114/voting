import axios from "axios";

const API_URL = "http://localhost:8080/api/votes";

export default {
    getAllVotes() {
        return axios.get(API_URL);
    },
    createVote(vote) {
        return axios.post(API_URL, vote);
    },
    updateVote(id, vote) {
        return axios.put(`${API_URL}/${id}`, vote);
    },
    deleteVote(id) {
        return axios.delete(`${API_URL}/${id}`);
    }
};