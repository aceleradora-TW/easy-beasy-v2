import axios from 'axios';
const client = axios.create({
    baseURL: '/ws/',
    timeout: 5000});
export default client;
