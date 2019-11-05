import axios from 'axios';
const client = axios.create({
    baseURL: '/',
    timeout: 5000});
export default client;