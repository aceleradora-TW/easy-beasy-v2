import http from '../utils/http.js'
export default {
    getSolutions: (id) => http.get(`/stage/`+ id)
}