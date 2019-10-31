import http from '../utils/http'

export default {
    getQuestions : () => http.get(`/questions`)
}