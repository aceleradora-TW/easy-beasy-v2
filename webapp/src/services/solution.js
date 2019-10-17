import request from '../utils/request.js'
export default {
    solution: () => request.get(`/estagio/0/`)
}