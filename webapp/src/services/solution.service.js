import http from '../utils/http.js'
export default {
    getSolution: () => http.get(`/estagio/0/`)
}