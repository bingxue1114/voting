import axios from 'axios';

const API_URL = 'http://localhost:8080/api/votes';

export const getAllVotes = () => axios.get(API_URL);
export const getVoteById = (id) => axios.get(`${API_URL}/${id}`);
export const createVote = (data) => axios.post(API_URL, data);
export const updateVote = (id, data) => axios.put(`${API_URL}/${id}`, data);
export const deleteVote = (id) => axios.delete(`${API_URL}/${id}`);