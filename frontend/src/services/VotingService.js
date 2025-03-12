import axios from 'axios';

const API_URL = 'http://localhost:8080/api/voting-items';

export default {
    getAllVotingItems() {
        return axios.get(API_URL);
    },

    createVotingItem(votingItem) {
        return axios.post(API_URL, votingItem);
    },

    deleteVotingItem(id) {
        return axios.delete(`${API_URL}/${id}`);
    }
};