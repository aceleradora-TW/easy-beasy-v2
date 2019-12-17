import http from '../utils/http.js'

export default {
    save: (question) => http.post('/question/', question),
}