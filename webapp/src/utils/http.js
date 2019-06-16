import axios from 'axios';
const client = axios.create({
    baseURL: 'localhost:8080/ws/',
    timeout: 5000});
export default client;
