import http from '../utils/http'

export default {
    getQuestions: (id) => http.get(`/stage/ ${id}`).data
}