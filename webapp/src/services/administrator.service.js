import http from '../utils/http'

export default {
    save: (administrator) => http.post(`/cadastrar/`, administrator)
}