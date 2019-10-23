import axios from 'axios';
const http = axios.create({
    baseURL: '/',
    timeout: 5000
});
export default http;