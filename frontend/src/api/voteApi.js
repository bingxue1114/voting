import axios from 'axios';

const API_URL = 'http://localhost:8080/api/votes';

export const getAllVotes = () => axios.get(API_URL);
export const createVote = (data) => axios.post(API_URL, data)