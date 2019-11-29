import http from '../utils/http.js'
export default{
    getQuestions: () => http.get('/question'),
}