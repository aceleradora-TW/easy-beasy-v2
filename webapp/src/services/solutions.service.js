import http from '../utils/http.js'
export default {
    getSolutions: () => http.get(`/stage/0/`)
}