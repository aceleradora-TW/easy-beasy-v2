import http from '../utils/http.js'
export default {
    getSolutions: () => http.get(`/estagio/0/`)
}