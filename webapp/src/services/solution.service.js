import request from '../utils/request.js'
export default {
    getSolution: () => request.get(`/estagio/0/`)
}